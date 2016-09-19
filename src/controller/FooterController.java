package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;

@Controller
public class FooterController {

	@RequestMapping(value="/agreement.footer")
	public ModelAndView goAgreement(){//user���� ������ �̵�
		System.out.println("FooterController_ goAgreement() ����");
		return new ModelAndView("footer/agreement.jsp");
	}
}
