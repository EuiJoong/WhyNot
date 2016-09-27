package controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import assessment.model.AssessmentDAO;
import assessment.model.AssessmentDBBean;
import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;
import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;
import onlinecontent.model.OnlineContentDAO;
import onlinecontent.model.OnlineContentDBBean;
import onlinecontent.mybatis.OnlineContentMybatis;
import onlinecurriculum.model.OnlineCurriculumDAO;
import onlinecurriculum.model.OnlineCurriculumDBBean;
import onlinecurriculum.qna.model.OnlineCurriculumQNADAO;
import payment.model.OnlinePaymentDBBean;
import payment.model.PaymentDAO;
import payment.mybatis.PaymentMybatis;
import attachfile.*;

@Controller
public class OnContentController {

	private OnlineContentDAO onlineContentDAO;
	private OnlineCurriculumDAO onlineCurriculumDAO;
	private OnlineCurriculumQNADAO onlineCurriculumQNADAO;
	private CategoryDAO categoryDAO;
	private PaymentDAO paymentDAO;
	private AssessmentDAO assessmentDAO;

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public void setOnlineContentDAO(OnlineContentDAO onlineContentDAO) {
		this.onlineContentDAO = onlineContentDAO;
	}

	public void setOnlineCurriculumDAO(OnlineCurriculumDAO onlineCurriculumDAO) {
		this.onlineCurriculumDAO = onlineCurriculumDAO;
	}

	public void setOnlineCurriculumQNADAO(OnlineCurriculumQNADAO onlineCurriculumQNADAO) {
		this.onlineCurriculumQNADAO = onlineCurriculumQNADAO;
	}

	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	public void setAssessmentDAO(AssessmentDAO assessmentDAO) {
		this.assessmentDAO = assessmentDAO;
	}

	// -------------- ������ -----------------------------------
	public VideoDBBean insertVideo(FileItem fileItem, HttpServletRequest arg0) throws Exception {
		// ���� ���ε� ó��
		String fileName = fileItem.getName();
		long fileSize = fileItem.getSize() / 1024 + (fileItem.getSize() % 1024 > 0 ? 1 : 0);
		// File uploadedFile = new File(fileName);

		String[] fileNameE = fileName.split("[.]");
		String ext = fileNameE[fileNameE.length - 1];// Ȯ����
		String filetitle = "";

		if (fileNameE.length > 2) {
			for (int i = 0; i < fileNameE.length - 1; i++) {
				filetitle += fileNameE[i] + ".";
			}
		}

		// ���� ����
		for (int i = 0; i < 16; i++) {
			filetitle += (int) (Math.random() * 9);
		}
		filetitle += ".";
		// filetitle:���ϸ�, ext:���� Ȯ����
		String result = filetitle + ext;

		// System.out.println("filename : " + fileName);
		// System.out.println("filesize : " + fileSize);
		Socket client = new Socket("localhost", 12345);
		System.out.println("�������Ӽ���!!");
		InputStream is = fileItem.getInputStream();
		OutputStream os = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(os);

		dout.writeLong(fileSize);
		dout.writeUTF(result);
		System.out.println("��� : " + result);
		byte[] buffer = new byte[1024];

		int len;
		System.out.println("����������..");
		for (; fileSize > 0; fileSize--) {
			len = is.read(buffer);
			os.write(buffer, 0, len);
		}
		dout.close();
		os.close();

		System.out.println("�������ۿϷ�!!");
		// return new ModelAndView("../index.jsp");
		// 1.���ڵ� �ϰ�, ���ϳ����� arg1�� �ھƼ�
		// -------------------------------------------
		/*
		 * File source = new File("movie/sample2.mp4"); File target = new
		 * File("movie/sample22.flv");
		 */
		VideoDBBean v_dto = new VideoDBBean();
		// DB�� ������ ����Ǵ� ���
		String filedir = arg0.getServletContext().getRealPath("/video");
		// String[] fileNameE = fileName.split("[.]");// 0: ���� ����, 1: ����
		// Ȯ����
		System.out.println(fileNameE.length);
		System.out.println(fileNameE[0]);
		System.out.println(fileNameE[1]);

		v_dto.setFilename(filetitle + "mp4");
		v_dto.setFiledir(filedir);
		v_dto.setMnum(0);
		v_dto.setVdnum(0);
		System.out.println("������� �Գ�");
		return v_dto;// ���Ƿ�! �־����� ����!
		// 2.forward�� �� �ִ� �״�� �޿� �Űܼ�..�ٵ� �� �������� ��� ��������

	}

	// ----------------------------- �¶��� ������ (�ΰ�)
	// --------------------------------

	@RequestMapping(value = "/list.oncont")
	public ModelAndView listContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_listContent() ����");
		System.out.println(arg0.getParameter("ctnum")); // ���߿� ��� ��������
		int ctnum = Integer.parseInt(arg0.getParameter("ctnum"));

		// --- ī�װ� ���
		List<CategoryDBBean> cateList = categoryDAO.listCategory();

		List<Object> contList = onlineContentDAO.listOnlineContent(ctnum);
		System.out.println(contList.size());
		ModelAndView mav = new ModelAndView();
		mav.addObject("cateList", cateList);
		mav.addObject("contList", contList);
		mav.setViewName("content/contentList.jsp");
		return mav;

	}

	@RequestMapping(value = "/cont_insert.oncont") // �ΰ����Form(�б�)
	public ModelAndView insertFormContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_insertFormContent() ����");
		List<CategoryDBBean> list = CategoryMybatis.listCategory();
		return new ModelAndView("content/online/cont_insertForm.jsp", "cateList", list);

	}

	@RequestMapping(value = "/cont_insertPro.oncont") // �ΰ����Pro(�б�)
	public ModelAndView insertProContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_insertProContent() ����");
		// ===================================================================

		OnlineContentDBBean oc_dto = null;
		PhotoDBBean p_dto = null;
		VideoDBBean v_dto = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);

		if (isMultipart) {
			File temporaryDir = new File(arg0.getServletContext().getRealPath("/temp"));// ������
			// �ӽ���������
			DiskFileItemFactory factory = new DiskFileItemFactory();
			System.out.println("factory ��������");
			factory.setSizeThreshold(1 * 1024 * 1024);// �޸� �ӽ����� ���ѿ뷮
			factory.setRepository(temporaryDir);
			ServletFileUpload upload = new ServletFileUpload(factory);
			System.out.println("ServletFileUpload ��������");
			upload.setSizeMax(3 * 1024 * 1024 * 1024);// �����ִ� ���ѿ뷮
			List items = null;
			try {
				items = upload.parseRequest(arg0);
			} catch (FileUploadException fe) {
				System.out.println(fe);
				fe.printStackTrace();
			}
			if (items != null) {
				Iterator iter = items.iterator();
				oc_dto = new OnlineContentDBBean();
				while (iter.hasNext()) {
					FileItem fileItem = (FileItem) iter.next();
					if (fileItem.isFormField()) {
						// ������ ������ ������ �Ķ���� ó��
						String name = fileItem.getFieldName();
						System.out.println("���϶� : " + name);
						String value = fileItem.getString("UTF-8");
						System.out.println("���϶� : " + value);
						if (value == null || value.equals(""))
							value = "0";
						Integer ptnum; // ������ȣ
						Integer vdnum; // �������ȣ
						switch (name) {
						case "ctnum":
							oc_dto.setCtnum(Integer.parseInt(value));
							break;
						case "mnum":
							oc_dto.setMnum(Integer.parseInt(value));
							break;
						case "title":
							oc_dto.setTitle(value);
							break;
						case "content":
							oc_dto.setContent(value);
							break;
						case "price":
							oc_dto.setPrice(Integer.parseInt(value));
							break;
						}

					} else {
						// ���� ���ε� ó��
						String name = fileItem.getFieldName();
						System.out.println("�����϶� : " + name + "/ " + fileItem.getName());
						switch (name) {
						case "image-file": // image���� ó��
							System.out.println("���������϶� : " + name);
							String[] nameArr = fileItem.getName().split("[.]");
							String upPath = arg0.getServletContext().getRealPath("/images");
							p_dto = new PhotoDBBean();
							p_dto.setFiledir(upPath);
							p_dto.setFilename(nameArr[0]);
							p_dto.setFileext(nameArr[1]);
							File imageFile = new File(upPath + "\\" + fileItem.getName());
							fileItem.write(imageFile);
							break;
						case "video-file": // video���� ó��
							System.out.println("���������϶� : " + name);

							// ���⼭ �����߻��ؾ� dao�� ���ڱ���!

							if (fileItem.getName() == null || fileItem.getName().equals(""))
								break;

							v_dto = insertVideo(fileItem, arg0); // video���� ���� ��
																	// ���ڵ�
							// �޼ҵ� ȣ��
							break;
						}

					}
				}
			}
		}
		if (v_dto == null) {
			v_dto = new VideoDBBean();
		}
		p_dto.setMnum(oc_dto.getMnum());
		v_dto.setMnum(oc_dto.getMnum());
		onlineContentDAO.insertContent(oc_dto, p_dto, v_dto);

		// ī�װ� ���
		List<CategoryDBBean> cateList = categoryDAO.listCategory();
		// ===================================================================
		return new ModelAndView("main.app", "cateList", cateList); // ���߿�
																					// ������������???
	}

	@RequestMapping(value = "/cont_detail.oncont") // �ΰ� �󼼺���
	public ModelAndView detailContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailContent() ����");
		ModelAndView mav = new ModelAndView();
		int mnum = -1;
		int ocnum = Integer.parseInt(arg0.getParameter("ocnum"));
		if (arg0.getParameter("mnum") != null) {// ��α��� ����
			mnum = Integer.parseInt(arg0.getParameter("mnum")); // �α����� ȸ����ȣ
			// �¶��� ������
			OnlinePaymentDBBean dto = paymentDAO.chkPurchaseOnline(mnum, ocnum);
			boolean isPurchase = false;// ��������
			if (dto != null)
				isPurchase = true; // ���� ������ ������
			mav.addObject("isPurchase", isPurchase);
		} // ����
		OnlineContentDBBean dtoForVideo = new OnlineContentDBBean();
		dtoForVideo.setMnum(mnum);
		dtoForVideo.setOcnum(ocnum);
		VideoDBBean videoDTO = onlineContentDAO.getContent(dtoForVideo);// ���������޾ƿ���
		// getDetailWho
		if (videoDTO != null) {
			mav.addObject("videoDTO", videoDTO);
			System.out.println("videoDTO �־�");
		}

		List<Object> contList = onlineContentDAO.getDetailWho(ocnum);

		if (contList != null) {
			mav.addObject("contList", contList);
			System.out.println("contList �־�");
		}

		List<Object> assessmentList = assessmentDAO.listAssessment(ocnum);

		if (assessmentList != null && assessmentList.size() > 0) {
			mav.addObject("assessmentList", assessmentList);
			System.out.println("�ش� �������� ���� ��ϵ��� �ֽ��ϴ�. " + assessmentList.size());

		} else
			System.out.println("��ϵ� �򰡰� ���׿�!");

		int sum = 0;
		AssessmentDBBean ddto = null;
		Iterator it = assessmentList.iterator();
		while (it.hasNext()) {
			ddto = (AssessmentDBBean) it.next();
			sum += ddto.getGrademark();
			System.out.println("���� : " + ddto.getGrademark());
		}

		int jj = 10;
		double avg = (double) (int) ((double) sum / assessmentList.size() * jj + 0.5) / jj;

		System.out.println("����" + sum);
		System.out.println("����:" + avg);

		// lsnum ���ϱ�
		int lsnum = onlineCurriculumDAO.getLsnum(ocnum);

		// Ŀ��ŧ�� ��� ���ϱ�
		List<OnlineCurriculumDBBean> currList = onlineCurriculumDAO.listCurriculum(lsnum);

		mav.addObject("currList", currList);
		mav.addObject("lsnum", lsnum);
		mav.addObject("avg", avg);

		mav.addObject("ocnum", ocnum);
		// Content�󼼳����� �޾ƿ�
		mav.setViewName("content/online/cont_detailForm.jsp");
		return mav;
	}

	@RequestMapping(value = "/cont_update.oncont")
	public ModelAndView updateFormContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_updateFormCurri() ����");
		ModelAndView mav = new ModelAndView();

		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		int ocnum = Integer.parseInt(arg0.getParameter("ocnum"));

		OnlineContentDBBean dtoForVideo = new OnlineContentDBBean();
		dtoForVideo.setOcnum(ocnum);
		dtoForVideo.setMnum(mnum);
		VideoDBBean dtoResult = onlineContentDAO.getContent(dtoForVideo);

		mav.addObject("videoDTO", dtoResult);

		List<Object> contList = onlineContentDAO.getDetailWho(ocnum);

		if (contList != null) {
			mav.addObject("contList", contList);
			System.out.println("����! contList �־�");
		}
		mav.setViewName("content/online/cont_updateForm.jsp");
		return mav;

	}

	@RequestMapping(value = "/cont_updatePro.oncont")
	public ModelAndView updateProContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_detailProContent() ����");
		//���� ����!
		
		int ptnumO=Integer.parseInt(arg0.getParameter("ptnum"));
		int vdnumO=Integer.parseInt(arg0.getParameter("vdnum"));
        OnlineContentDBBean oc_dto = null;
        PhotoDBBean p_dto = null;
        VideoDBBean v_dto = null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);

        if (isMultipart) {
           File temporaryDir = new File(arg0.getServletContext().getRealPath("/temp"));// ������
                                                        // �ӽ���������
           DiskFileItemFactory factory = new DiskFileItemFactory();
           System.out.println("factory ��������");
           factory.setSizeThreshold(1 * 1024 * 1024);// �޸� �ӽ����� ���ѿ뷮
           factory.setRepository(temporaryDir);
           ServletFileUpload upload = new ServletFileUpload(factory);
           System.out.println("ServletFileUpload ��������");
           upload.setSizeMax(3 * 1024 * 1024 * 1024);// �����ִ� ���ѿ뷮
           List items = null;
           try {
              items = upload.parseRequest(arg0);
           } catch (FileUploadException fe) {
              System.out.println(fe);
              fe.printStackTrace();
           }
           if (items != null) {
              Iterator iter = items.iterator();
              oc_dto = new OnlineContentDBBean();
              while (iter.hasNext()) {
                 FileItem fileItem = (FileItem) iter.next();
                 if (fileItem.isFormField()) {
                    // ������ ������ ������ �Ķ���� ó��
                    String name = fileItem.getFieldName();
                    System.out.println("���϶� : " + name);
                    String value = fileItem.getString("UTF-8");
                    System.out.println("���϶� : " + value);
                    if(value==null || value.equals(""))
                       value="0";
                    Integer ptnum; // ������ȣ
                    Integer vdnum; // �������ȣ
                    switch (name) {
                    case "ctnum":
                       oc_dto.setCtnum(Integer.parseInt(value));
                       break;
                    case "mnum":
                       oc_dto.setMnum(Integer.parseInt(value));
                       break;
                    case "title":
                       oc_dto.setTitle(value);
                       break;
                    case "content":
                       oc_dto.setContent(value);
                       break;
                    case "price":
                       oc_dto.setPrice(Integer.parseInt(value));
                       break;
                    }

                 } else {
                    // ���� ���ε� ó��
                    String name = fileItem.getFieldName();
                    System.out.println("�����϶� : " + name + "/ " + fileItem.getName());
                    switch (name) {
                    case "image-file": // image���� ó��
                       System.out.println("���������϶� : " + name);
                       String[] nameArr = fileItem.getName().split("[.]");
                       String upPath =arg0.getServletContext().getRealPath("/images"); 
                       		//arg0.getServletContext().getRealPath("/images");
                       p_dto = new PhotoDBBean();
                       p_dto.setFiledir(upPath);
                       p_dto.setFilename(nameArr[0]);
                       p_dto.setFileext(nameArr[1]);
                       File imageFile = new File(upPath +"\\"+ fileItem.getName());
                       fileItem.write(imageFile);
                       break;
                    case "video-file": // video���� ó��
                       System.out.println("���������϶� : " + name);

                       
                       if (fileItem.getName() == null || fileItem.getName().equals(""))
                          break;
                       
                       v_dto = insertVideo(fileItem, arg0); // video���� ���� �� ���ڵ�
                                               // �޼ҵ� ȣ��
                       break;
                    }

                 }
              }
           }
        }
        if (v_dto == null) {
           v_dto = new VideoDBBean();
        }
        //mnum, ocnum���
        int ocnum=Integer.parseInt(arg0.getParameter("ocnum"));
        int mnum=Integer.parseInt(arg0.getParameter("mnum"));
        oc_dto.setOcnum(ocnum);
        oc_dto.setMnum(mnum);
        oc_dto.setPtnumO(ptnumO);
        oc_dto.setVdnumO(vdnumO);
        p_dto.setMnum(oc_dto.getMnum());
        v_dto.setMnum(oc_dto.getMnum());
        //onlineContentDAO.insertContent(oc_dto, p_dto, v_dto);
        onlineContentDAO.updateContent(oc_dto, p_dto, v_dto);
        //ī�װ� ���
        List<CategoryDBBean> cateList = categoryDAO.listCategory();
        // ===================================================================
        return new ModelAndView("content/contentList.jsp","cateList", cateList); //
		//return new ModelAndView("content/online/cont_detailForm.jsp");

	}
	
	   @RequestMapping(value = "/insertAssessment.oncont") // detailForm-���ϱ�
	   public ModelAndView insertAssessment(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	      System.out.println("ContentController_insertAssessment() ����");
	      //����
	      System.out.println(arg0.getParameter("mnum"));
		int mnum= Integer.parseInt(arg0.getParameter("mnum"));
		int grademark = ServletRequestUtils.getIntParameter(arg0, "grademark");
		System.out.println(grademark);
		//int asnum =1;//�̰� ����
		String person =arg0.getParameter("writer");
		ModelAndView mav = new ModelAndView();

		int ocnum=Integer.parseInt(arg0.getParameter("ocnum"));
		System.out.println("������ �ѹ� : "+ocnum);
		System.out.println("���� : "+grademark);
		AssessmentDBBean dto = new AssessmentDBBean();
		//dto.setAsnum(asnum);
		dto.setOcnum(ocnum);
		dto.setPerson(person);
		dto.setContent(ServletRequestUtils.getStringParameter(arg0,"assessmentContent"));
		dto.setGrademark(ServletRequestUtils.getIntParameter(arg0, "grademark"));
		assessmentDAO.insertAssessment(dto);
		
//			List<AssessmentDBBean> list = AssessmentDAO.listAssessment();	
//			mva.addObject("list",list);
		mav.setViewName("cont_detail.oncont");
		mav.addObject("ocnum"+ocnum);
		mav.addObject("mnum"+mnum);
		return mav;
		
	/*      List<CategoryDBBean> list = CategoryMybatis.insertAssessment();
	      return new ModelAndView("content/online/cont_detailForm.jsp");*/
	   }

}