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

	// -------------- 컨텐츠 -----------------------------------
	public VideoDBBean insertVideo(FileItem fileItem, HttpServletRequest arg0) throws Exception {
		// 파일 업로드 처리
		String fileName = fileItem.getName();
		long fileSize = fileItem.getSize() / 1024 + (fileItem.getSize() % 1024 > 0 ? 1 : 0);
		// File uploadedFile = new File(fileName);

		String[] fileNameE = fileName.split("[.]");
		String ext = fileNameE[fileNameE.length - 1];// 확장자
		String filetitle = "";

		if (fileNameE.length > 2) {
			for (int i = 0; i < fileNameE.length - 1; i++) {
				filetitle += fileNameE[i] + ".";
			}
		}

		// 이제 난수
		for (int i = 0; i < 16; i++) {
			filetitle += (int) (Math.random() * 9);
		}
		filetitle += ".";
		// filetitle:파일명, ext:파일 확장자
		String result = filetitle + ext;

		// System.out.println("filename : " + fileName);
		// System.out.println("filesize : " + fileSize);
		Socket client = new Socket("localhost", 12345);
		System.out.println("서버접속성공!!");
		InputStream is = fileItem.getInputStream();
		OutputStream os = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(os);

		dout.writeLong(fileSize);
		dout.writeUTF(result);
		System.out.println("경로 : " + result);
		byte[] buffer = new byte[1024];

		int len;
		System.out.println("파일전송중..");
		for (; fileSize > 0; fileSize--) {
			len = is.read(buffer);
			os.write(buffer, 0, len);
		}
		dout.close();
		os.close();

		System.out.println("파일전송완료!!");
		// return new ModelAndView("../index.jsp");
		// 1.인코딩 하고, 파일네임을 arg1에 박아서
		// -------------------------------------------
		/*
		 * File source = new File("movie/sample2.mp4"); File target = new
		 * File("movie/sample22.flv");
		 */
		VideoDBBean v_dto = new VideoDBBean();
		// DB에 실제로 저장되는 경로
		String filedir = arg0.getServletContext().getRealPath("/video");
		// String[] fileNameE = fileName.split("[.]");// 0: 파일 네임, 1: 파일
		// 확장자
		System.out.println(fileNameE.length);
		System.out.println(fileNameE[0]);
		System.out.println(fileNameE[1]);

		v_dto.setFilename(filetitle + "mp4");
		v_dto.setFiledir(filedir);
		v_dto.setMnum(0);
		v_dto.setVdnum(0);
		System.out.println("여기까지 왔나");
		return v_dto;// 임의로! 넣어지나 보자!
		// 2.forward로 값 있는 그대로 쭈욱 옮겨서..근데 저 쿼리문은 어떻게 실행하지

	}

	// ----------------------------- 온라인 컨텐츠 (인강)
	// --------------------------------

	@RequestMapping(value = "/list.oncont")
	public ModelAndView listContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_listContent() 실행");
		System.out.println(arg0.getParameter("ctnum")); // 나중에 목록 갖고오기용
		int ctnum = Integer.parseInt(arg0.getParameter("ctnum"));

		// --- 카테고리 목록
		List<CategoryDBBean> cateList = categoryDAO.listCategory();

		List<Object> contList = onlineContentDAO.listOnlineContent(ctnum);
		System.out.println(contList.size());
		ModelAndView mav = new ModelAndView();
		mav.addObject("cateList", cateList);
		mav.addObject("contList", contList);
		mav.setViewName("content/contentList.jsp");
		return mav;

	}

	@RequestMapping(value = "/cont_insert.oncont") // 인강등록Form(학교)
	public ModelAndView insertFormContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_insertFormContent() 실행");
		List<CategoryDBBean> list = CategoryMybatis.listCategory();
		return new ModelAndView("content/online/cont_insertForm.jsp", "cateList", list);

	}

	@RequestMapping(value = "/cont_insertPro.oncont") // 인강등록Pro(학교)
	public ModelAndView insertProContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_insertProContent() 실행");
		// ===================================================================

		OnlineContentDBBean oc_dto = null;
		PhotoDBBean p_dto = null;
		VideoDBBean v_dto = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);

		if (isMultipart) {
			File temporaryDir = new File(arg0.getServletContext().getRealPath("/temp"));// 동영상
			// 임시저장폴더
			DiskFileItemFactory factory = new DiskFileItemFactory();
			System.out.println("factory 생성성공");
			factory.setSizeThreshold(1 * 1024 * 1024);// 메모리 임시저장 제한용량
			factory.setRepository(temporaryDir);
			ServletFileUpload upload = new ServletFileUpload(factory);
			System.out.println("ServletFileUpload 생성성공");
			upload.setSizeMax(3 * 1024 * 1024 * 1024);// 파일최대 제한용량
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
						// 파일을 제외한 나머지 파라미터 처리
						String name = fileItem.getFieldName();
						System.out.println("값일때 : " + name);
						String value = fileItem.getString("UTF-8");
						System.out.println("값일때 : " + value);
						if (value == null || value.equals(""))
							value = "0";
						Integer ptnum; // 사진번호
						Integer vdnum; // 동영상번호
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
						// 파일 업로드 처리
						String name = fileItem.getFieldName();
						System.out.println("파일일때 : " + name + "/ " + fileItem.getName());
						switch (name) {
						case "image-file": // image파일 처리
							System.out.println("사진파일일때 : " + name);
							String[] nameArr = fileItem.getName().split("[.]");
							String upPath = arg0.getServletContext().getRealPath("/images");
							p_dto = new PhotoDBBean();
							p_dto.setFiledir(upPath);
							p_dto.setFilename(nameArr[0]);
							p_dto.setFileext(nameArr[1]);
							File imageFile = new File(upPath + "\\" + fileItem.getName());
							fileItem.write(imageFile);
							break;
						case "video-file": // video파일 처리
							System.out.println("비디오파일일때 : " + name);

							// 여기서 난수발생해야 dao에 들어가겠구나!

							if (fileItem.getName() == null || fileItem.getName().equals(""))
								break;

							v_dto = insertVideo(fileItem, arg0); // video파일 전송 및
																	// 인코딩
							// 메소드 호출
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

		// 카테고리 목록
		List<CategoryDBBean> cateList = categoryDAO.listCategory();
		// ===================================================================
		return new ModelAndView("main.app", "cateList", cateList); // 나중에
																					// 마이페이지로???
	}

	@RequestMapping(value = "/cont_detail.oncont") // 인강 상세보기
	public ModelAndView detailContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailContent() 실행");
		ModelAndView mav = new ModelAndView();
		int mnum = -1;
		int ocnum = Integer.parseInt(arg0.getParameter("ocnum"));
		if (arg0.getParameter("mnum") != null) {// 비로그인 구별
			mnum = Integer.parseInt(arg0.getParameter("mnum")); // 로그인자 회원번호
			// 온라인 컨텐츠
			OnlinePaymentDBBean dto = paymentDAO.chkPurchaseOnline(mnum, ocnum);
			boolean isPurchase = false;// 결제내역
			if (dto != null)
				isPurchase = true; // 결제 내역이 있으면
			mav.addObject("isPurchase", isPurchase);
		} // 여기
		OnlineContentDBBean dtoForVideo = new OnlineContentDBBean();
		dtoForVideo.setMnum(mnum);
		dtoForVideo.setOcnum(ocnum);
		VideoDBBean videoDTO = onlineContentDAO.getContent(dtoForVideo);// 비디오정보받아오기
		// getDetailWho
		if (videoDTO != null) {
			mav.addObject("videoDTO", videoDTO);
			System.out.println("videoDTO 있엉");
		}

		List<Object> contList = onlineContentDAO.getDetailWho(ocnum);

		if (contList != null) {
			mav.addObject("contList", contList);
			System.out.println("contList 있엉");
		}

		List<Object> assessmentList = assessmentDAO.listAssessment(ocnum);

		if (assessmentList != null && assessmentList.size() > 0) {
			mav.addObject("assessmentList", assessmentList);
			System.out.println("해당 콘텐츠는 평가한 기록들이 있습니다. " + assessmentList.size());

		} else
			System.out.println("등록된 평가가 없네요!");

		int sum = 0;
		AssessmentDBBean ddto = null;
		Iterator it = assessmentList.iterator();
		while (it.hasNext()) {
			ddto = (AssessmentDBBean) it.next();
			sum += ddto.getGrademark();
			System.out.println("평점 : " + ddto.getGrademark());
		}

		int jj = 10;
		double avg = (double) (int) ((double) sum / assessmentList.size() * jj + 0.5) / jj;

		System.out.println("점수" + sum);
		System.out.println("평점:" + avg);

		// lsnum 구하기
		int lsnum = onlineCurriculumDAO.getLsnum(ocnum);

		// 커리큘럼 목록 구하기
		List<OnlineCurriculumDBBean> currList = onlineCurriculumDAO.listCurriculum(lsnum);

		mav.addObject("currList", currList);
		mav.addObject("lsnum", lsnum);
		mav.addObject("avg", avg);

		mav.addObject("ocnum", ocnum);
		// Content상세내역을 받아옴
		mav.setViewName("content/online/cont_detailForm.jsp");
		return mav;
	}

	@RequestMapping(value = "/cont_update.oncont")
	public ModelAndView updateFormContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_updateFormCurri() 실행");
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
			System.out.println("수정! contList 있엉");
		}
		mav.setViewName("content/online/cont_updateForm.jsp");
		return mav;

	}

	@RequestMapping(value = "/cont_updatePro.oncont")
	public ModelAndView updateProContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_detailProContent() 실행");
		//이제 여기!
		
		int ptnumO=Integer.parseInt(arg0.getParameter("ptnum"));
		int vdnumO=Integer.parseInt(arg0.getParameter("vdnum"));
        OnlineContentDBBean oc_dto = null;
        PhotoDBBean p_dto = null;
        VideoDBBean v_dto = null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);

        if (isMultipart) {
           File temporaryDir = new File(arg0.getServletContext().getRealPath("/temp"));// 동영상
                                                        // 임시저장폴더
           DiskFileItemFactory factory = new DiskFileItemFactory();
           System.out.println("factory 생성성공");
           factory.setSizeThreshold(1 * 1024 * 1024);// 메모리 임시저장 제한용량
           factory.setRepository(temporaryDir);
           ServletFileUpload upload = new ServletFileUpload(factory);
           System.out.println("ServletFileUpload 생성성공");
           upload.setSizeMax(3 * 1024 * 1024 * 1024);// 파일최대 제한용량
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
                    // 파일을 제외한 나머지 파라미터 처리
                    String name = fileItem.getFieldName();
                    System.out.println("값일때 : " + name);
                    String value = fileItem.getString("UTF-8");
                    System.out.println("값일때 : " + value);
                    if(value==null || value.equals(""))
                       value="0";
                    Integer ptnum; // 사진번호
                    Integer vdnum; // 동영상번호
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
                    // 파일 업로드 처리
                    String name = fileItem.getFieldName();
                    System.out.println("파일일때 : " + name + "/ " + fileItem.getName());
                    switch (name) {
                    case "image-file": // image파일 처리
                       System.out.println("사진파일일때 : " + name);
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
                    case "video-file": // video파일 처리
                       System.out.println("비디오파일일때 : " + name);

                       
                       if (fileItem.getName() == null || fileItem.getName().equals(""))
                          break;
                       
                       v_dto = insertVideo(fileItem, arg0); // video파일 전송 및 인코딩
                                               // 메소드 호출
                       break;
                    }

                 }
              }
           }
        }
        if (v_dto == null) {
           v_dto = new VideoDBBean();
        }
        //mnum, ocnum등록
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
        //카테고리 목록
        List<CategoryDBBean> cateList = categoryDAO.listCategory();
        // ===================================================================
        return new ModelAndView("content/contentList.jsp","cateList", cateList); //
		//return new ModelAndView("content/online/cont_detailForm.jsp");

	}
	
	   @RequestMapping(value = "/insertAssessment.oncont") // detailForm-평가하기
	   public ModelAndView insertAssessment(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	      System.out.println("ContentController_insertAssessment() 실행");
	      //여기
	      System.out.println(arg0.getParameter("mnum"));
		int mnum= Integer.parseInt(arg0.getParameter("mnum"));
		int grademark = ServletRequestUtils.getIntParameter(arg0, "grademark");
		System.out.println(grademark);
		//int asnum =1;//이건 뭐지
		String person =arg0.getParameter("writer");
		ModelAndView mav = new ModelAndView();

		int ocnum=Integer.parseInt(arg0.getParameter("ocnum"));
		System.out.println("컨텐츠 넘버 : "+ocnum);
		System.out.println("평점 : "+grademark);
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