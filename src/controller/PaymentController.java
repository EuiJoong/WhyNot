package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import login.model.LoginModel;
import member.model.MemberDAO;
import member.model.MemberDBBean;
import payment.model.MileagePaymentDBBean;
import payment.model.OnlinePaymentDBBean;
import payment.model.PaymentDAO;

@Controller
public class PaymentController {

	private PaymentDAO paymentDAO;
	private MemberDAO memberDAO;
	private LoginModel loginModel;

	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}

	@RequestMapping(value = "/purchaseOnline.payment")
	public ModelAndView purchaseOnline(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PaymentController_purchaseOnline()");
		OnlinePaymentDBBean dto = new OnlinePaymentDBBean();

		dto.setMnum(Integer.parseInt(arg0.getParameter("mnum"))); // �α����� ȸ����ȣ
		dto.setOcnum(Integer.parseInt(arg0.getParameter("ocnum")));
		dto.setAmount(Integer.parseInt(arg0.getParameter("amount"))); // ����
		paymentDAO.purchaseOnline(dto); // ���� ���� ���

		// ���ϸ��� ����
		int seller = Integer.parseInt(arg0.getParameter("seller"));
		memberDAO.tradeMileage(Integer.parseInt(arg0.getParameter("mnum")),
				Integer.parseInt(arg0.getParameter("amount")), seller);
		System.out.println("�����Ϸ� ");
		// ���� ����
		HttpSession session = arg0.getSession();
		session.invalidate();
		System.out.println("���� ���� ");
		// ���� �� ���� ���� ����.....?
		return new ModelAndView("login/getLogin.jsp");

	}

	@RequestMapping(value = "/paymentForm.payment")
	public ModelAndView paymentForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PaymentController_paymentForm()");

		return new ModelAndView("payment/mileage/selectPayment.jsp");

	}

	@RequestMapping(value = "/select.payment")
	public ModelAndView selectMileage(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PaymentController_selectMileage()");

		System.out.println(arg0.getParameter("mnum") + "," + arg0.getParameter("amount") + ","
				+ arg0.getParameter("box") + "," + arg0.getParameter("tool") + "," + arg0.getParameter("bway"));

		int mnum = Integer.parseInt(arg0.getParameter("mnum")); // �α����� ȸ����ȣ

		int amount = 0;
		if (arg0.getParameter("amount").equals("amount")) {
			System.out.println("1");
			amount = Integer.parseInt(arg0.getParameter("box")); // ����
		} else {
			System.out.println("2");
			amount = Integer.parseInt(arg0.getParameter("amount")); // ����
		}

		System.out.println(amount);

		int tool = Integer.parseInt(arg0.getParameter("tool"));
		int bway = Integer.parseInt(arg0.getParameter("bway")); // 1 ���� 2ȯ��

		System.out.println(mnum);
		String url = null;
		switch (tool) {
		case 1:
			url = "payment/mileage/tel_Payment.jsp";
			break;
		case 2:
			url = "payment/mileage/card_Payment.jsp";
			break;
		}

		System.out.println("���� ����");

		HttpSession session = arg0.getSession();
		session.invalidate();

		ModelAndView mav = new ModelAndView();

		mav.addObject("mnum", mnum);
		mav.addObject("amount", amount);
		mav.addObject("bway", bway);
		mav.setViewName(url);
		return mav;

	}

	@RequestMapping(value = "/purchasePro.payment")
	public ModelAndView purchaseMileage(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PaymentController_purchaseMileage()");

		MileagePaymentDBBean dto = new MileagePaymentDBBean();

		dto.setMnum(Integer.parseInt(arg0.getParameter("mnum"))); // �α����� ȸ����ȣ
		dto.setAmount(Integer.parseInt(arg0.getParameter("amount"))); // ����
		dto.setBway(Integer.parseInt(arg0.getParameter("bway"))); // 1 ���� 2ȯ��

		paymentDAO.purchaseMileage(dto);

		MemberDBBean mdto = new MemberDBBean();

		mdto.setMnum(Integer.parseInt(arg0.getParameter("mnum")));
		mdto.setMileage(Integer.parseInt(arg0.getParameter("amount")));

		memberDAO.chargeMileage(mdto);

		System.out.println("DB ���� ����");

		HttpSession session = arg0.getSession();

		MemberDBBean resDTO = memberDAO.getMember(mdto.getMnum());

		System.out.println(resDTO);
		session.setAttribute("memberDTO", resDTO);

		System.out.println("���� �ʱ�ȭ ����");

		return new ModelAndView("payment/mileage/end_Payment.jsp");

	}

	@RequestMapping(value = "/login.payment") // ���� ����
	public ModelAndView getLogin(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MainController_getLogin() ����");

		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		int ocnum = Integer.parseInt(arg0.getParameter("onnum"));
		MemberDBBean resDTO = loginModel.reLogin(mnum);
		HttpSession session = arg0.getSession();
		session.setAttribute("memberDTO", resDTO);

		return new ModelAndView("cont_detail.oncont?ocnum=" + ocnum);
	}

}
