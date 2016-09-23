package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.sg.prism.NGShape.Mode;

import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;
import onlinecontent.model.OnlineContentDAO;

@Controller
public class MainController {
	
	private CategoryDAO categoryDAO;
	private OnlineContentDAO onlineContentDAO;
	
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	public void setOnlineContentDAO(OnlineContentDAO onlineContentDAO) {
		this.onlineContentDAO = onlineContentDAO;
	}

	@RequestMapping(value="/main.app")
	public ModelAndView goMain(HttpServletRequest arg0, HttpServletResponse arg1)throws Exception{//user메인 페이지 이동
		System.out.println("MainController_ goMain() 실행");
		List<CategoryDBBean> catelist = categoryDAO.listCategory();//카테고리 목록 
		System.out.println(arg0.getParameter("recommandList"));
		/*List catelist = onlineContentDAO.listOnlineContent(ctnum);*/
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("cateList",catelist);
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping(value="/adminMain.app")
	public ModelAndView goAdminMain(HttpServletRequest arg0, HttpServletResponse arg1)throws Exception{//admin메인 페이지 이동
		System.out.println("MainController_goAdminMain() 실행");
		return new ModelAndView("admin/adminMain.jsp");
	}
	
}
