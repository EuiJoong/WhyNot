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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;
import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;
import onlinecontent.model.OnlineContentDAO;
import onlinecontent.model.OnlineContentDBBean;
import onlinecontent.mybatis.OnlineContentMybatis;
import onlinecurriculum.board.model.OnlineCurriculumBoardDAO;
import onlinecurriculum.model.OnlineCurriculumDAO;
import payment.model.OnlinePaymentDBBean;
import payment.mybatis.PaymentMybatis;
import attachfile.*;

@Controller
public class ContentController {

	private OnlineContentDAO onlineContentDAO;
	private OnlineCurriculumDAO onlineCurriculumDAO;
	private OnlineCurriculumBoardDAO onlineCurriculumBoardDAO;
	private CategoryDAO CategoryDAO;

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.CategoryDAO = categoryDAO;
	}

	public void setOnlineContentDAO(OnlineContentDAO onlineContentDAO) {
		this.onlineContentDAO = onlineContentDAO;
	}

	public void setOnlineCurriculumDAO(OnlineCurriculumDAO onlineCurriculumDAO) {
		this.onlineCurriculumDAO = onlineCurriculumDAO;
	}

	public void setOnlineCurriculumBoardDAO(OnlineCurriculumBoardDAO onlineCurriculumBoardDAO) {
		this.onlineCurriculumBoardDAO = onlineCurriculumBoardDAO;
	}

	// -------------- ������ -----------------------------------

	public VideoDBBean insertVideo(FileItem fileItem) throws Exception {

		// ���� ���ε� ó��
		String fileName = fileItem.getName();
		long fileSize = fileItem.getSize() / 1024 + (fileItem.getSize() % 1024 > 0 ? 1 : 0);
		// File uploadedFile = new File(fileName);
		System.out.println("filename : " + fileName);
		System.out.println("filesize : " + fileSize);
		Socket client = new Socket("127.0.0.1", 12345);
		System.out.println("�������Ӽ���!!");
		InputStream is = fileItem.getInputStream();
		OutputStream os = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(os);

		dout.writeLong(fileSize);
		dout.writeUTF(fileName);
		System.out.println("��� : " + fileName);
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
		String filedir = "C:\\Users\\Administrator\\Desktop\\testvideo\\";
		String[] fileNameE = fileName.split("[.]");// 0: ���� ����, 1: ����
													// Ȯ����
		System.out.println(fileNameE.length);
		System.out.println(fileNameE[0]);
		System.out.println(fileNameE[1]);

		v_dto.setFilename(fileNameE[0] + ".mp4");
		v_dto.setFiledir(filedir);
		v_dto.setMnum(0);
		v_dto.setVdnum(0);
		System.out.println("������� �Գ�");
		return v_dto;// ���Ƿ�! �־����� ����!
		// 2.forward�� �� �ִ� �״�� �޿� �Űܼ�..�ٵ� �� �������� ��� ��������

	}

	@RequestMapping(value = "/list.content")
	public ModelAndView listContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_listContent() ����");
		System.out.println(arg0.getParameter("ctnum")); // ���߿� ��� ��������
		int ctnum = Integer.parseInt(arg0.getParameter("ctnum"));
		
		//--- ī�װ� ��� 
		List<CategoryDBBean> cateList = CategoryDAO.listCategory();
		
		List<Object> contList = onlineContentDAO.listOnlineContent(ctnum);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cateList",cateList);
		mav.addObject("contList",contList);
		mav.setViewName("content/contentList.jsp");
		return mav;

	}

	@RequestMapping(value = "/cont_insert.content") // �ΰ����Form(�б�)
	public ModelAndView insertFormContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertFormContent() ����");
		List<CategoryDBBean> list = CategoryMybatis.listCategory();
		return new ModelAndView("content/online/cont_insertForm.jsp", "cateList", list);

	}

	@RequestMapping(value = "/cont_insertPro.content") // �ΰ����Pro(�б�)
	public ModelAndView insertProContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertProContent() ����");
		// ===================================================================
		arg0.setCharacterEncoding("UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		System.out.println("����:"+arg0.getParameter("title"));
		System.out.println("����:"+arg0.getParameter("content"));
		
		OnlineContentDBBean oc_dto = null;
		PhotoDBBean p_dto = null;
		VideoDBBean v_dto = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);

		if (isMultipart) {
			File temporaryDir = new File("C:\\Users\\Administrator\\Desktop\\testvideo\\");// ������
																		// �ӽ���������
			DiskFileItemFactory factory = new DiskFileItemFactory();
			System.out.println("factory ��������");
			factory.setSizeThreshold(1 * 1024 * 1024);// �޸� �ӽ����� ���ѿ뷮
			factory.setRepository(temporaryDir);
			ServletFileUpload upload = new ServletFileUpload(factory);
			System.out.println("ServletFileUpload ��������");
			upload.setSizeMax(2 * 1024 * 1024 * 1024);// �����ִ� ���ѿ뷮
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
							String upPath = "C:\\Users\\Administrator\\Desktop\\testvideo\\";
							p_dto = new PhotoDBBean();
							p_dto.setFiledir(upPath);
							p_dto.setFilename(nameArr[0]);
							p_dto.setFileext(nameArr[1]);
							File imageFile = new File(upPath + fileItem.getName());
							fileItem.write(imageFile);
							break;
						case "video-file": // video���� ó��
							System.out.println("���������϶� : " + name);
							if (fileItem.getName() == null || fileItem.getName().equals(""))
								break;
							v_dto = insertVideo(fileItem); // video���� ���� �� ���ڵ�
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

		// ===================================================================
		return new ModelAndView("content/contentList.jsp"); // ���߿� ������������???
	}

	@RequestMapping(value = "/cont_detail.content") // �ΰ� �󼼺���
	public ModelAndView detailContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailContent() ����");
		int mnum = Integer.parseInt(arg0.getParameter("mnum")); // ������ ȸ����ȣ
		int ocnum = Integer.parseInt(arg0.getParameter("ocnum")); // �¶��� ������ ��ȣ

		// ���� �ߴ��� ���ߴ��� Ȯ��
		OnlinePaymentDBBean dto = PaymentMybatis.chkPurchaseOnline(mnum, ocnum);
		boolean isPurchase = false;
		if (mnum == dto.getMnum() && ocnum == dto.getOcnum()) // ��� ����� ������
			isPurchase = true;
		return new ModelAndView("content/online/cont_detailForm.jsp", "isPurchase", isPurchase);
	}

	// -------------- Ŀ��ŧ�� -----------------------------------

	@RequestMapping(value = "/curri_insert.content") // Ŀ��ŧ�� ���
	public ModelAndView insertFormCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertFormCurri() ����");
		return new ModelAndView("content/online/cont_insertForm.jsp");

	}

	@RequestMapping(value = "/curri_insertPro.content") // Ŀ��ŧ�� ���Pro
	public ModelAndView insertProCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertProCurri() ����");
		return new ModelAndView("content/contentList.jsp"); // ���߿� �ڽ��� �ø� ����(�б�)
															// ���������� ����

	}

	@RequestMapping(value = "/curri_detail.content") // ���ǽ�Form
	public ModelAndView detailCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailCurri() ����");
		return new ModelAndView("content/online/curr_detailForm.jsp");

	}
}
