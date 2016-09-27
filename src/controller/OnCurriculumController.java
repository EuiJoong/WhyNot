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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import assessment.model.AssessmentDAO;
import attachfile.model.ClassVideoDBBean;
import attachfile.model.PhotoDBBean;
import attachfile.model.TextDBBean;
import attachfile.model.VideoDBBean;
import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import onlinecontent.model.OnlineContentDAO;
import onlinecontent.model.OnlineContentDBBean;
import onlinecurriculum.model.OnlineCurriculumDAO;
import onlinecurriculum.model.OnlineCurriculumDBBean;
import onlinecurriculum.qna.model.OnlineCurriculumQNADAO;
import onlinecurriculum.qna.model.OnlineCurriculumQNADBBean;
import payment.model.PaymentDAO;

@Controller
public class OnCurriculumController {
	private OnlineContentDAO onlineContentDAO;
	private OnlineCurriculumDAO onlineCurriculumDAO;
	private OnlineCurriculumQNADAO onlineCurriculumQNADAO;
	private CategoryDAO categoryDAO;
	private PaymentDAO paymentDAO;
	private AssessmentDAO assessmentDAO;

	public void setOnlineContentDAO(OnlineContentDAO onlineContentDAO) {
		this.onlineContentDAO = onlineContentDAO;
	}

	public void setOnlineCurriculumDAO(OnlineCurriculumDAO onlineCurriculumDAO) {
		this.onlineCurriculumDAO = onlineCurriculumDAO;
	}

	public void setOnlineCurriculumQNADAO(OnlineCurriculumQNADAO onlineCurriculumQNADAO) {
		this.onlineCurriculumQNADAO = onlineCurriculumQNADAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	public void setAssessmentDAO(AssessmentDAO assessmentDAO) {
		this.assessmentDAO = assessmentDAO;
	}

	// -------------- 컨텐츠 -----------------------------------
	public ClassVideoDBBean insertVideo(FileItem fileItem, HttpServletRequest arg0) throws Exception {
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
		ClassVideoDBBean v_dto = new ClassVideoDBBean();
		// DB에 실제로 저장되는 경로
		String filedir = arg0.getServletContext().getRealPath("/video");
		// String[] fileNameE = fileName.split("[.]");// 0: 파일 네임, 1: 파일
		// 확장자
		System.out.println(fileNameE.length);
		System.out.println(fileNameE[0]);
		System.out.println(fileNameE[1]);

		v_dto.setFilename(filetitle + "mp4");
		v_dto.setFiledir(filedir);
		/* v_dto.setVdnum(0); */
		System.out.println("여기까지 왔나");
		return v_dto;// 임의로! 넣어지나 보자!
		// 2.forward로 값 있는 그대로 쭈욱 옮겨서..근데 저 쿼리문은 어떻게 실행하지

	}

	// -------------- 커리큘럼 -----------------------------------

	@RequestMapping(value = "/curri_insert.curr") // 커리큘럼 등록
	public ModelAndView insertCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnCurriculumController_insertCurri() 실행");
		int lsnum = Integer.parseInt(arg0.getParameter("lsnum"));
		int ocnum = Integer.parseInt(arg0.getParameter("ocnum"));
		System.out.println(arg0.getParameter("lsnum"));
		System.out.println(arg0.getParameter("ocnum"));

		ModelAndView mav = new ModelAndView();
		mav.setViewName("content/online/curr_insertForm.jsp");
		mav.addObject("lsnum", lsnum);
		mav.addObject("ocnum", ocnum);

		return mav;

	}

	@RequestMapping(value = "/curri_insertPro.curr") // 커리큘럼 등록Pro
	public ModelAndView insertProCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		System.out.println("OnCurriculumController_insertProCurri() 실행");
		System.out.println(arg0.getParameter("ocnum"));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cont_detail.oncont");
		mav.addObject("ocnum", arg0.getParameter("ocnum"));

		OnlineCurriculumDBBean oc_dto = null;
		TextDBBean t_dto = null;
		ClassVideoDBBean v_dto = null;

		boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);

		if (isMultipart) {
			Integer lsnum = Integer.parseInt(arg0.getParameter("lsnum"));
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
				oc_dto = new OnlineCurriculumDBBean();
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
						Integer ttnum; // 파일번호
						Integer vdnum; // 동영상번호
						switch (name) {
						case "lsnum":
							oc_dto.setLsnum(Integer.parseInt(value));
						case "title":
							oc_dto.setTitle(value);
							break;
						}

					} else {
						// 파일 업로드 처리
						String name = fileItem.getFieldName();
						System.out.println("파일일때 : " + name + "/ " + fileItem.getName());
						switch (name) {
						case "image-file": // image파일 처리
							System.out.println("사진파일일때 : " + name);

							if (fileItem.getName() == null || fileItem.getName().equals(""))
								break;

							String[] nameArr = fileItem.getName().split("[.]");
							String upPath = arg0.getServletContext().getRealPath("/images");
							t_dto = new TextDBBean();
							t_dto.setFiledir(upPath);
							t_dto.setFilename(nameArr[0]);
							t_dto.setFileext(nameArr[1]);
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
			v_dto = new ClassVideoDBBean();
		}
		
		t_dto.setLsnum(oc_dto.getLsnum());
		/*
		 * t_dto.setMnum(oc_dto.getMnum()); v_dto.setMnum(oc_dto.getMnum());
		 */
		onlineCurriculumDAO.insertCurriculum(oc_dto, t_dto, v_dto);

		// ===================================================================

		return mav; // 나중에 자신이 올린

		// 상세페이지로 수정

	}

	@RequestMapping(value = "/curri_detail.curr") // 강의실Form
	public ModelAndView detailCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnCurriculumController_detailCurri() 실행");
		System.out.println("lsnum:"+ arg0.getParameter("lsnum") + " clnum:"+arg0.getParameter("clnum") + " ttnum:"+arg0.getParameter("ttnum"));
		OnlineCurriculumDBBean dto = new OnlineCurriculumDBBean();
		dto.setLsnum(Integer.parseInt(arg0.getParameter("lsnum")));
		dto.setClnum(Integer.parseInt(arg0.getParameter("clnum")));
		dto.setTtnum(Integer.parseInt(arg0.getParameter("ttnum")));
		String writer = arg0.getParameter("writer");
		
		//1개 모든 데이터
		List currData = onlineCurriculumDAO.getCurriculum(dto);
		//커리큘럼 목록
		List currList = onlineCurriculumDAO.listCurriculum(Integer.parseInt(arg0.getParameter("lsnum")));
		Iterator it = currData.iterator();
		while(it.hasNext()){
			System.out.println("cont" + it.next());
		}
		//Q&A 목록
		OnlineCurriculumQNADBBean qnadto = new OnlineCurriculumQNADBBean();
		qnadto.setLsnum(Integer.parseInt(arg0.getParameter("lsnum")));
		qnadto.setClnum(Integer.parseInt(arg0.getParameter("clnum")));
		List<OnlineCurriculumQNADBBean> qnaList = onlineCurriculumQNADAO.listOnlineContentQa(qnadto);
		System.out.println("질답 사이즈"+qnaList.size());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("currList",currList);
		mav.addObject("currData",currData);
		mav.addObject("qnaList",qnaList);
		mav.addObject("writer",writer);
		
		mav.setViewName("content/online/curr_detailForm.jsp");
		
		return mav;
	}

	@RequestMapping(value = "/curri_delete.curr") // 삭제
	public ModelAndView deleteCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_deleteCurri() 실행");
		
		OnlineCurriculumQNADBBean ocqna = new OnlineCurriculumQNADBBean();
		ocqna.setLsnum(Integer.parseInt(arg0.getParameter("lsnum")));
		ocqna.setClnum(Integer.parseInt(arg0.getParameter("clnum")));
		
		List<OnlineCurriculumQNADBBean> list = onlineCurriculumQNADAO.listOnlineContentQa(ocqna);

		return new ModelAndView("content/online/curr_detailForm.jsp", "qnaList", list);
	}

	@RequestMapping(value = "/curri_update.curr") // 수정Form 이동
	public ModelAndView updateCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnCurriculumController_updateCurri() 실행");
		return new ModelAndView("content/online/curr_updateForm.jsp");

	}

	@RequestMapping(value = "/curri_updatePro.curr") // 수정Pro진행
	public ModelAndView updateProCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_updateProCurri() 실행");
		return new ModelAndView("content/online/curr_detailForm.jsp");

	}

	@RequestMapping(value = "/qna_insert.curr") // 질문과 답변 등록
	public ModelAndView insertQNA(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnCurriculumController_insertQNA() 실행");

		OnlineCurriculumQNADBBean ocqna = new OnlineCurriculumQNADBBean();

		System.out.println(arg0.getParameter("lsnum"));
		System.out.println(arg0.getParameter("content"));
		System.out.println(arg0.getParameter("mnum"));
		System.out.println(arg0.getParameter("clnum"));
		int lsnum = Integer.parseInt(arg0.getParameter("lsnum"));
		String content = arg0.getParameter("content");
		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		int clnum = Integer.parseInt(arg0.getParameter("clnum"));
	
		ocqna.setLsnum(lsnum);
		ocqna.setContent(content);
		ocqna.setMnum(mnum);
		ocqna.setClnum(clnum);
		onlineCurriculumQNADAO.insertOnlineContentQa(ocqna);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("curri_detail.curr");
		
		return mav;

	}

	@RequestMapping(value = "/qna_answer.curr") // 댓글 답글
	public ModelAndView answerQNA(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnCurriculumController_answerQNA() 실행");

		OnlineCurriculumQNADBBean ocqna = new OnlineCurriculumQNADBBean();

		System.out.println(arg0.getParameter("lsnum"));
		System.out.println(arg0.getParameter("content"));
		System.out.println(arg0.getParameter("mnum"));
		System.out.println(arg0.getParameter("qanum"));
		System.out.println(arg0.getParameter("qanum"));
		int lsnum = Integer.parseInt(arg0.getParameter("lsnum"));
		String content = arg0.getParameter("content");
		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		int qanum = Integer.parseInt(arg0.getParameter("qanum"));
		int clnum = Integer.parseInt(arg0.getParameter("clnum"));
		ocqna.setLsnum(lsnum);
		ocqna.setContent(content);
		ocqna.setMnum(mnum);
		ocqna.setQanum(qanum);
		ocqna.setClnum(clnum);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("curri_detail.curr");
		mav.addObject("lsnum",lsnum);
		mav.addObject("lsnum",lsnum);
		mav.addObject("clnum",clnum);
		onlineCurriculumQNADAO.answerOnlineContentQa(ocqna);

		return mav;
	}

	@RequestMapping(value = "qna_delete.curr") // 댓글 삭제
	public ModelAndView deleteQNA(HttpServletRequest arg0, HttpServletRequest arg1) throws Exception {
		System.out.println("OnCurriculumController_deleteQNA() 실행");

		System.out.println("qanum : " + arg0.getParameter("qanum"));
		System.out.println("mnum : " + arg0.getParameter("mnum"));
		System.out.println("lsnum : " + arg0.getParameter("lsnum"));
		int qanum = Integer.parseInt(arg0.getParameter("qanum"));
		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		int lsnum = Integer.parseInt(arg0.getParameter("lsnum"));
		onlineCurriculumQNADAO.deleteOnlineContentQa(qanum, mnum,Integer.parseInt(arg0.getParameter("clnum")));

		ModelAndView mav = new ModelAndView();
		mav.setViewName("curri_detail.curr");
		mav.addObject("lsnum",lsnum);
		mav.addObject("clnum",Integer.parseInt(arg0.getParameter("clnum")));
		return mav;
	}

}
