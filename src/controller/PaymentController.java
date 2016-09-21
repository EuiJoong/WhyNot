package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import payment.model.MileagePaymentDBBean;
import payment.model.OnlinePaymentDBBean;
import payment.model.PaymentDAO;

@Controller
public class PaymentController {

	private PaymentDAO paymentDAO;

	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}
	
	@RequestMapping(value = "/purchaseOnline.payment")
	public ModelAndView purchaseOnline(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PaymentController_purchaseOnline()");
		OnlinePaymentDBBean dto = new OnlinePaymentDBBean();

		dto.setMnum(Integer.parseInt(arg0.getParameter("mnum"))); // 로그인한 회원번호
		dto.setOcnum(Integer.parseInt(arg0.getParameter("ocnum"))); // 선택한 온라인
																	// 컨텐츠 번호
		dto.setAmount(Integer.parseInt(arg0.getParameter("amount"))); // 가격

		paymentDAO.purchaseOnline(dto);
		System.out.println("DB 구매 성공");

		return new ModelAndView();

	}
	
	@RequestMapping(value = "/select.payment")
	public ModelAndView selectMileage(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PaymentController_selectMileage()");
		
		System.out.println(arg0.getParameter("mnum")+","+arg0.getParameter("amount")+","+arg0.getParameter("tool")+","+arg0.getParameter("bway"));
		
		int mnum = Integer.parseInt(arg0.getParameter("mnum")); // 로그인한 회원번호
		int amount = Integer.parseInt(arg0.getParameter("amount")); // 가격
		int tool = Integer.parseInt(arg0.getParameter("tool"));
		int bway = Integer.parseInt(arg0.getParameter("bway")); // 1 구매 2환전

		System.out.println(mnum);
		String url = null;
		switch (tool) {
		case 1: url = "payment/mileage/tel_Payment.jsp"; break;
		case 2: url = "payment/mileage/card_Payment.jsp"; break;
		}
		
		System.out.println("충전 선택");

		ModelAndView mav = new ModelAndView();

		mav.addObject("mnum", mnum);
		mav.addObject("amount", amount);
		mav.addObject("bway", bway);
		mav.setViewName(url);
		return mav;

	}

	
	
	
	@RequestMapping(value = "/purchase.payment")
	public ModelAndView purchaseMileage(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PaymentController_purchaseMileage()");
		
		MileagePaymentDBBean dto = new MileagePaymentDBBean();
		
		dto.setMnum(Integer.parseInt(arg0.getParameter("mnum"))); // 로그인한 회원번호
		dto.setAmount(Integer.parseInt(arg0.getParameter("amount"))); // 가격
		dto.setBway(Integer.parseInt(arg0.getParameter("bway"))); // 1 구매 2환전

		paymentDAO.purchaseMileage(dto);
		System.out.println("DB 구매 성공");

		return new ModelAndView();

	}

}
