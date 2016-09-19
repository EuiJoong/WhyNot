package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDBBean;
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
	
	
	@RequestMapping(value = "/select.mileage")
	public ModelAndView insertFormCategory(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("CategoryController_insertFormCategory() ����");
		
		System.out.println(arg0.getAttribute("money"));
		
		return new ModelAndView("admin/category/cate_insertForm.jsp","msg",arg0.getAttribute("msg"));

	}

	@RequestMapping(value = "/insertPro.cate")
	public ModelAndView insertProCategory(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("CategoryController_insertProCategory() ����");

		CategoryDBBean dto = new CategoryDBBean();
		dto.setName(arg0.getParameter("name"));
		CategoryDAO.insertCategory(dto);
		
		return new ModelAndView("list.cate");
	}
	
	
}
