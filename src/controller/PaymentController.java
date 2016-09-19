package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import payment.model.OnlinePaymentDBBean;
import payment.model.PaymentDAO;

@Controller
public class PaymentController {
	
	private PaymentDAO paymentDAO;

	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}
	
	
	@RequestMapping(value="/purchaseOnline.payment")
	public ModelAndView purchaseOnline(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PaymentController_purchaseOnline()");
		OnlinePaymentDBBean dto = new OnlinePaymentDBBean();
		
		dto.setMnum(Integer.parseInt(arg0.getParameter("mnum"))); //로그인한 회원번호
		dto.setOcnum(Integer.parseInt(arg0.getParameter("ocnum"))); //선택한 온라인 컨텐츠 번호
		dto.setAmount(Integer.parseInt(arg0.getParameter("amount"))); //가격
		
		paymentDAO.purchaseOnline(dto);
		System.out.println("DB 구매 성공");
		
		return new ModelAndView();
		
	}
}
