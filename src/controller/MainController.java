package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.sg.prism.NGShape.Mode;

import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;
import member.model.MemberDBBean;
import notice.model.NoticeBoardDAO;
import onlinecontent.model.OnlineContentDAO;

@Controller
public class MainController {

	private CategoryDAO categoryDAO;
	private OnlineContentDAO onlineContentDAO;
	private NoticeBoardDAO noticeBoardDAO;
	
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public void setOnlineContentDAO(OnlineContentDAO onlineContentDAO) {
		this.onlineContentDAO = onlineContentDAO;
	}

	public void setNoticeBoardDAO(NoticeBoardDAO noticeBoardDAO) {
		this.noticeBoardDAO = noticeBoardDAO;
	}

	@RequestMapping(value = "/main.app")
	public ModelAndView goMain(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {// user메인
																									// 페이지
																									// 이동
		System.out.println("MainController_ goMain() 실행");

		ModelAndView mav = new ModelAndView();
		
		//카테고리 목록
		List<CategoryDBBean> catelist = categoryDAO.listCategory();// 카테고리 목록

		//Best 목록
		List bestList = onlineContentDAO.getBestContent();
		
		
		// 추천 목록
		if (arg0.getSession().getAttribute("memberDTO") != null) {
			MemberDBBean memberDTO = (MemberDBBean) arg0.getSession().getAttribute("memberDTO");
			List recommandList = onlineContentDAO.recommendContent(memberDTO.getMnum());
			mav.addObject("recommandList", recommandList);
		}
		
		//공지사항 사진 불러오기
		List notiList = noticeBoardDAO.getNotice();
		
		mav.addObject("notiList",notiList);
		mav.addObject("bestList",bestList);
		mav.addObject("cateList", catelist);
		mav.setViewName("index.jsp");
		return mav;
	}

	@RequestMapping(value = "/adminMain.app")
	public ModelAndView goAdminMain(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {// admin메인
																											// 페이지
																											// 이동
		System.out.println("MainController_goAdminMain() 실행");
		return new ModelAndView("admin/adminMain.jsp");
	}
	
	

}
