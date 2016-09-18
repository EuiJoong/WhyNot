package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;

@Controller
public class MainController {
	
	@RequestMapping(value="/main.app")
	public ModelAndView goMain(){//user메인 페이지 이동
		System.out.println("MainController_ goMain() 실행");
		CategoryDBBean dto = new CategoryDBBean();
		List<CategoryDBBean> list = CategoryMybatis.listCategory();
		return new ModelAndView("index.jsp","cateList",list);
	}
	
	@RequestMapping(value="/adminMain.app")
	public ModelAndView goAdminMain(){//admin메인 페이지 이동
		System.out.println("MainController_goAdminMain() 실행");
		return new ModelAndView("admin/adminMain.jsp");
	}
	
}
