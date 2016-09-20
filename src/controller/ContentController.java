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

	// -------------- 컨텐츠 -----------------------------------

	public VideoDBBean insertVideo(FileItem fileItem) throws Exception {

		// 파일 업로드 처리
		String fileName = fileItem.getName();
		long fileSize = fileItem.getSize() / 1024 + (fileItem.getSize() % 1024 > 0 ? 1 : 0);
		// File uploadedFile = new File(fileName);
		System.out.println("filename : " + fileName);
		System.out.println("filesize : " + fileSize);
		Socket client = new Socket("127.0.0.1", 12345);
		System.out.println("서버접속성공!!");
		InputStream is = fileItem.getInputStream();
		OutputStream os = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(os);

		dout.writeLong(fileSize);
		dout.writeUTF(fileName);
		System.out.println("경로 : " + fileName);
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
		String filedir = "C:\\Users\\Administrator\\Desktop\\testvideo\\";
		String[] fileNameE = fileName.split("[.]");// 0: 파일 네임, 1: 파일
													// 확장자
		System.out.println(fileNameE.length);
		System.out.println(fileNameE[0]);
		System.out.println(fileNameE[1]);

		v_dto.setFilename(fileNameE[0] + ".mp4");
		v_dto.setFiledir(filedir);
		v_dto.setMnum(0);
		v_dto.setVdnum(0);
		System.out.println("여기까지 왔나");
		return v_dto;// 임의로! 넣어지나 보자!
		// 2.forward로 값 있는 그대로 쭈욱 옮겨서..근데 저 쿼리문은 어떻게 실행하지

	}

	@RequestMapping(value = "/list.content")
	public ModelAndView listContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_listContent() 실행");
		System.out.println(arg0.getParameter("ctnum")); // 나중에 목록 갖고오기용
		int ctnum = Integer.parseInt(arg0.getParameter("ctnum"));
		
		//--- 카테고리 목록 
		List<CategoryDBBean> cateList = CategoryDAO.listCategory();
		
		List<Object> contList = onlineContentDAO.listOnlineContent(ctnum);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cateList",cateList);
		mav.addObject("contList",contList);
		mav.setViewName("content/contentList.jsp");
		return mav;

	}

	@RequestMapping(value = "/cont_insert.content") // 인강등록Form(학교)
	public ModelAndView insertFormContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertFormContent() 실행");
		List<CategoryDBBean> list = CategoryMybatis.listCategory();
		return new ModelAndView("content/online/cont_insertForm.jsp", "cateList", list);

	}

	@RequestMapping(value = "/cont_insertPro.content") // 인강등록Pro(학교)
	public ModelAndView insertProContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertProContent() 실행");
		// ===================================================================
		arg0.setCharacterEncoding("UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		System.out.println("제목:"+arg0.getParameter("title"));
		System.out.println("내용:"+arg0.getParameter("content"));
		
		OnlineContentDBBean oc_dto = null;
		PhotoDBBean p_dto = null;
		VideoDBBean v_dto = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);

		if (isMultipart) {
			File temporaryDir = new File("C:\\Users\\Administrator\\Desktop\\testvideo\\");// 동영상
																		// 임시저장폴더
			DiskFileItemFactory factory = new DiskFileItemFactory();
			System.out.println("factory 생성성공");
			factory.setSizeThreshold(1 * 1024 * 1024);// 메모리 임시저장 제한용량
			factory.setRepository(temporaryDir);
			ServletFileUpload upload = new ServletFileUpload(factory);
			System.out.println("ServletFileUpload 생성성공");
			upload.setSizeMax(2 * 1024 * 1024 * 1024);// 파일최대 제한용량
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
							String upPath = "C:\\Users\\Administrator\\Desktop\\testvideo\\";
							p_dto = new PhotoDBBean();
							p_dto.setFiledir(upPath);
							p_dto.setFilename(nameArr[0]);
							p_dto.setFileext(nameArr[1]);
							File imageFile = new File(upPath + fileItem.getName());
							fileItem.write(imageFile);
							break;
						case "video-file": // video파일 처리
							System.out.println("비디오파일일때 : " + name);
							if (fileItem.getName() == null || fileItem.getName().equals(""))
								break;
							v_dto = insertVideo(fileItem); // video파일 전송 및 인코딩
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

		// ===================================================================
		return new ModelAndView("content/contentList.jsp"); // 나중에 마이페이지로???
	}

	@RequestMapping(value = "/cont_detail.content") // 인강 상세보기
	public ModelAndView detailContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailContent() 실행");
		int mnum = Integer.parseInt(arg0.getParameter("mnum")); // 구매자 회원번호
		int ocnum = Integer.parseInt(arg0.getParameter("ocnum")); // 온라인 컨텐츠 번호

		// 결제 했는지 안했는지 확인
		OnlinePaymentDBBean dto = PaymentMybatis.chkPurchaseOnline(mnum, ocnum);
		boolean isPurchase = false;
		if (mnum == dto.getMnum() && ocnum == dto.getOcnum()) // 디비에 기록이 있으면
			isPurchase = true;
		return new ModelAndView("content/online/cont_detailForm.jsp", "isPurchase", isPurchase);
	}

	// -------------- 커리큘럼 -----------------------------------

	@RequestMapping(value = "/curri_insert.content") // 커리큘럼 등록
	public ModelAndView insertFormCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertFormCurri() 실행");
		return new ModelAndView("content/online/cont_insertForm.jsp");

	}

	@RequestMapping(value = "/curri_insertPro.content") // 커리큘럼 등록Pro
	public ModelAndView insertProCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertProCurri() 실행");
		return new ModelAndView("content/contentList.jsp"); // 나중에 자신이 올린 강좌(학교)
															// 상세페이지로 수정

	}

	@RequestMapping(value = "/curri_detail.content") // 강의실Form
	public ModelAndView detailCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailCurri() 실행");
		return new ModelAndView("content/online/curr_detailForm.jsp");

	}
}
