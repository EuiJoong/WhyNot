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
	public ModelAndView goAgreement(){//user메인 페이지 이동
		System.out.println("FooterController_ goAgreement() 실행");
		return new ModelAndView("footer/agreement.jsp");
	}
}
