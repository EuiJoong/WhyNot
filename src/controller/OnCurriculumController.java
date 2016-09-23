package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import assessment.model.AssessmentDAO;
import category.model.CategoryDAO;
import onlinecontent.model.OnlineContentDAO;
import onlinecurriculum.board.model.OnlineCurriculumBoardDAO;
import onlinecurriculum.model.OnlineCurriculumDAO;
import payment.model.PaymentDAO;

@Controller
public class OnCurriculumController {
	private OnlineContentDAO onlineContentDAO;
	private OnlineCurriculumDAO onlineCurriculumDAO;
	private OnlineCurriculumBoardDAO onlineCurriculumBoardDAO;
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

	public void setOnlineCurriculumBoardDAO(OnlineCurriculumBoardDAO onlineCurriculumBoardDAO) {
		this.onlineCurriculumBoardDAO = onlineCurriculumBoardDAO;
	}

	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	public void setAssessmentDAO(AssessmentDAO assessmentDAO) {
		this.assessmentDAO = assessmentDAO;
	}

	// -------------- 커리큘럼 -----------------------------------

	@RequestMapping(value = "/curri_insert.curr") // 커리큘럼 등록
	public ModelAndView insertCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_insertCurri() 실행");
		return new ModelAndView("content/online/curr_insertForm.jsp");

	}

	@RequestMapping(value = "/curri_insertPro.curr") // 커리큘럼 등록Pro
	public ModelAndView insertProCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_insertProCurri() 실행");
		return new ModelAndView("content/cont_detailForm.jsp"); // 나중에 자신이 올린 강좌(학교)
		// 상세페이지로 수정

	}

	@RequestMapping(value = "/curri_detail.curr") // 강의실Form
	public ModelAndView detailCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_detailCurri() 실행");
		return new ModelAndView("content/online/curr_detailForm.jsp");

	}
	
	@RequestMapping(value = "/curri_delete.curr") // 삭제
	public ModelAndView deleteCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_deleteCurri() 실행");
		return new ModelAndView("content/online/curr_deleteForm.jsp");

	}
	
	@RequestMapping(value = "/curri_update.curr") // 수정Form 이동
	public ModelAndView updateCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_updateCurri() 실행");
		return new ModelAndView("content/online/curr_updateForm.jsp");

	}
	
	@RequestMapping(value = "/curri_updatePro.curr") //수정Pro진행
	public ModelAndView updateProCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_updateProCurri() 실행");
		return new ModelAndView("content/online/curr_detailForm.jsp");

	}
}
