package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDAO;
import category.model.CategoryDBBean;

@Controller
public class CategoryController {

	private CategoryDAO CategoryDAO;

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.CategoryDAO = categoryDAO;
	}


	@RequestMapping(value = "/insert.cate")
	public ModelAndView insertFormCategory(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("CategoryController_insertFormCategory() 실행");
		
		System.out.println(arg0.getAttribute("msg"));
		
		return new ModelAndView("admin/category/cate_insertForm.jsp","msg",arg0.getAttribute("msg"));

	}

	@RequestMapping(value = "/insertPro.cate")
	public ModelAndView insertProCategory(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("CategoryController_insertProCategory() 실행");

		CategoryDBBean dto = new CategoryDBBean();
		dto.setName(arg0.getParameter("name"));
		CategoryDAO.insertCategory(dto);
		
		return new ModelAndView("list.cate");
	}

	@RequestMapping(value = "/list.cate")
	public ModelAndView listCategory(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("CategoryController_listCategory() 실행");
		
		CategoryDBBean dto = new CategoryDBBean();
		List<CategoryDBBean> list = CategoryDAO.listCategory();
		return new ModelAndView("admin/category/cate_listForm.jsp","cateList",list);
	}

	@RequestMapping(value = "/delete.cate")
	public ModelAndView deleteCategory(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("CategoryController_listCategory() 실행");
		CategoryDAO.deleteCategory(Integer.parseInt(arg0.getParameter("ctnum")));

		return new ModelAndView("list.cate");
	}
	
	@RequestMapping(value = "/update.cate")
	public ModelAndView UpdateFormCategory(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("CategoryController_UpdateFormCategory() 실행");
		return new ModelAndView("admin/category/cate_updateForm.jsp");
	}

	@RequestMapping(value = "/updatePro.cate")
	public ModelAndView UpdateProCategory(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("CategoryController_UpdateProCategory() 실행");
		
		CategoryDBBean dto = new CategoryDBBean();
		dto.setName(arg0.getParameter("name"));
		dto.setCtnum(Integer.parseInt(arg0.getParameter("ctnum")));
		CategoryDAO.updateCategory(dto);
		
		return new ModelAndView("list.cate");
	}

	@RequestMapping(value = "/chk.cate")
	public ModelAndView UpCategory(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("CategoryController_chkCategory() 실행");

		String url = null;
		String msg = "";
		
		if(arg0.getParameter("name")==null||arg0.getParameter("name")==""){
			url = "insert.cate";
		}else{
		Boolean chk = CategoryDAO.chkCategory(arg0.getParameter("name"));
		
		if(chk){
			msg = "중복!";
			url = "insert.cate";
		}else{
			url = "insertPro.cate";
		}}
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(url);
		mav.addObject("msg",msg);
		System.out.println(msg);
		
		return mav;
	}


	
}
