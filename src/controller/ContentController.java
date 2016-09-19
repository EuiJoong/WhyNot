package controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
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

import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;
import onlinecontent.model.OnlineContentDAO;
import onlinecontent.model.OnlineContentDBBean;
import onlinecontent.model.OnlineContentVideoDBBean;
import onlinecurriculum.board.model.OnlineCurriculumBoardDAO;
import onlinecurriculum.model.OnlineCurriculumDAO;

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

	@RequestMapping(value = "/insertVideo.content")
	public ModelAndView insertVideo(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// dto
		boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);

		if (isMultipart) {
			System.out.println("isMultipart if문 진입");
			// E:\\java\\Main\\Temp
			// C:\Users\Public\Downloads
			File temporaryDir = new File("E:\\java\\Main\\videoTest\\");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			System.out.println("factory 생성성공");
			factory.setSizeThreshold(1 * 1024 * 1024);
			factory.setRepository(temporaryDir);
			ServletFileUpload upload = new ServletFileUpload(factory);
			System.out.println("ServletFileUpload 생성성공");
			upload.setSizeMax(2 * 1024 * 1024 * 1024);
			System.out.println("upload.getFileSizeMax()" + upload.getFileSizeMax());
			System.out.println("upload.getSizeMax()" + upload.getSizeMax());
			List items = null;
			try {
				items = upload.parseRequest(arg0);
				System.out.println("items받아오기 성공" + items.size());
			} catch (FileUploadException fe) {
				System.out.println(fe);
			}
			if (items != null) {
				System.out.println("items!=null 진입성공");

				FileItem fileItem = (FileItem) items.get(0);

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
				 * File source = new File("movie/sample2.mp4"); File target =
				 * new File("movie/sample22.flv");
				 */
				OnlineContentVideoDBBean v_dto = new OnlineContentVideoDBBean();
				//DB에 실제로 저장되는 경로
				String filedir = "E:\\java\\Main\\videoTest\\";
				String[] fileNameE = fileName.split("[.]");// 0: 파일 네임, 1: 파일
															// 확장자
				System.out.println(fileNameE.length);
				System.out.println(fileNameE[0]);
				System.out.println(fileNameE[1]);

				v_dto.setFilename(fileNameE[0] + ".mp4");
				v_dto.setFiledir(filedir);
				v_dto.setMnum(0);
				v_dto.setVdnum(0);
				System.out.println(onlineContentDAO);
				onlineContentDAO.insertContent(v_dto, 0);// 임의로! 넣어지나 보자!
				// 2.forward로 값 있는 그대로 쭈욱 옮겨서..근데 저 쿼리문은 어떻게 실행하지
				System.out.println("여기까지 왔나");

			}
			// new OnlineContentDAOImpl.insertBoard(dto);
		}
		// return new ModelAndView("redirect:board_list.do");

		return new ModelAndView("content/online/cont_detailForm.jsp");
	}

	@RequestMapping(value = "/list.content")
	public ModelAndView listContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_listContent() 실행");
		System.out.println(arg0.getParameter("ctnum")); // 나중에 목록 갖고오기용
		CategoryDBBean dto = new CategoryDBBean();
		List<CategoryDBBean> list = CategoryMybatis.listCategory();
		return new ModelAndView("content/contentList.jsp", "cateList", list);

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
		
		
		
		return new ModelAndView("content/contentList.jsp"); // 나중에 마이페이지로???
	}

	@RequestMapping(value = "/cont_detail.content") // 인강 상세보기
	public ModelAndView detailContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailContent() 실행");
		return new ModelAndView("content/online/cont_detailForm.jsp");

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
