package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import onlinecontent.model.OnlineContentDAO;
import onlinecurriculum.board.model.OnlineCurriculumBoardDAO;
import onlinecurriculum.model.OnlineCurriculumDAO;

@Controller
public class ContentController {

	private OnlineContentDAO onlineContentDAO;
	private OnlineCurriculumDAO onlineCurriculumDAO;
	private OnlineCurriculumBoardDAO onlineCurriculumBoardDAO;
	
	public void setOnlineContentDAO(OnlineContentDAO onlineContentDAO) {
		this.onlineContentDAO = onlineContentDAO;
	}

	public void setOnlineCurriculumDAO(OnlineCurriculumDAO onlineCurriculumDAO) {
		this.onlineCurriculumDAO = onlineCurriculumDAO;
	}
	
	public void setOnlineCurriculumBoardDAO(OnlineCurriculumBoardDAO onlineCurriculumBoardDAO) {
		this.onlineCurriculumBoardDAO = onlineCurriculumBoardDAO;
	}
	
	// --------------  컨텐츠  -----------------------------------
	

	@RequestMapping(value = "/list.content")
	public ModelAndView listContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_listContent() 실행");
		return new ModelAndView("content/contentList.jsp");

	}

	@RequestMapping(value = "/cont_insert.content") // 인강등록Form(학교)
	public ModelAndView insertFormContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertFormContent() 실행");
		return new ModelAndView("content/online/cont_insertForm.jsp");

	}
	
	@RequestMapping(value = "/cont_insertPro.content") // 인강등록Pro(학교)
	public ModelAndView insertProContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertProContent() 실행");
		return new ModelAndView("content/contentList.jsp"); //나중에 마이페이지로???

	}

	@RequestMapping(value = "/cont_detail.content") // 인강 상세보기
	public ModelAndView detailContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailContent() 실행");
		return new ModelAndView("content/online/cont_detailForm.jsp");

	}
	
	// --------------  커리큘럼 -----------------------------------
	
	@RequestMapping(value = "/curri_insert.content") // 커리큘럼 등록
	public ModelAndView insertFormCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertFormCurri() 실행");
		return new ModelAndView("content/online/cont_insertForm.jsp");

	}
	
	@RequestMapping(value = "/curri_insertPro.content") // 커리큘럼 등록Pro
	public ModelAndView insertProCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertProCurri() 실행");
		return new ModelAndView("content/contentList.jsp"); //나중에 자신이 올린 강좌(학교) 상세페이지로 수정

	}

	@RequestMapping(value = "/curri_detail.content") // 강의실Form
	public ModelAndView detailCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_detailCurri() 실행");
		return new ModelAndView("content/online/curr_detailForm.jsp");

	}
}
