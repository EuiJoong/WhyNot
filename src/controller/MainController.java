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
	
	private CategoryDAO categoryDAO;
	
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@RequestMapping(value="/main.app")
	public ModelAndView goMain(){//user���� ������ �̵�
		System.out.println("MainController_ goMain() ����");
		List<CategoryDBBean> list = categoryDAO.listCategory();
		return new ModelAndView("index.jsp","cateList",list);
	}
	
	@RequestMapping(value="/adminMain.app")
	public ModelAndView goAdminMain(){//admin���� ������ �̵�
		System.out.println("MainController_goAdminMain() ����");
		return new ModelAndView("admin/adminMain.jsp");
	}
	
}
