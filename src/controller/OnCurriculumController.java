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

	// -------------- Ŀ��ŧ�� -----------------------------------

	@RequestMapping(value = "/curri_insert.curr") // Ŀ��ŧ�� ���
	public ModelAndView insertCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_insertCurri() ����");
		return new ModelAndView("content/online/curr_insertForm.jsp");

	}

	@RequestMapping(value = "/curri_insertPro.curr") // Ŀ��ŧ�� ���Pro
	public ModelAndView insertProCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_insertProCurri() ����");
		return new ModelAndView("content/cont_detailForm.jsp"); // ���߿� �ڽ��� �ø� ����(�б�)
		// ���������� ����

	}

	@RequestMapping(value = "/curri_detail.curr") // ���ǽ�Form
	public ModelAndView detailCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_detailCurri() ����");
		return new ModelAndView("content/online/curr_detailForm.jsp");

	}
	
	@RequestMapping(value = "/curri_delete.curr") // ����
	public ModelAndView deleteCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_deleteCurri() ����");
		return new ModelAndView("content/online/curr_deleteForm.jsp");

	}
	
	@RequestMapping(value = "/curri_update.curr") // ����Form �̵�
	public ModelAndView updateCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_updateCurri() ����");
		return new ModelAndView("content/online/curr_updateForm.jsp");

	}
	
	@RequestMapping(value = "/curri_updatePro.curr") //����Pro����
	public ModelAndView updateProCurri(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_updateProCurri() ����");
		return new ModelAndView("content/online/curr_detailForm.jsp");

	}
}
