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
		
		dto.setMnum(Integer.parseInt(arg0.getParameter("mnum"))); //�α����� ȸ����ȣ
		dto.setOcnum(Integer.parseInt(arg0.getParameter("ocnum"))); //������ �¶��� ������ ��ȣ
		dto.setAmount(Integer.parseInt(arg0.getParameter("amount"))); //����
		
		paymentDAO.purchaseOnline(dto);
		System.out.println("DB ���� ����");
		
		return new ModelAndView();
		
	}
}
