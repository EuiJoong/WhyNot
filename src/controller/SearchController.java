package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;
import offlinecontent.model.OfflineContentDAO;
import onlinecontent.model.OnlineContentDAO;

@Controller
public class SearchController {
	private OnlineContentDAO onlineContentDAO;
	private OfflineContentDAO offlineContentDAO;
	/*private OfflineContentDAO offlineContentDAO;*/
	private CategoryDAO categoryDAO;

	public void setOnlineContentDAO(OnlineContentDAO onlineContentDAO) {
		this.onlineContentDAO = onlineContentDAO;
	}

	/*public void setOfflineContentDAO(OfflineContentDAO offlineContentDAO) {
		this.offlineContentDAO = offlineContentDAO;
	}
	*/
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	public void setOfflineContentDAO(OfflineContentDAO offlineContentDAO) {
		this.offlineContentDAO = offlineContentDAO;
	}

	@RequestMapping(value = "/cont.search") // 인강등록Form(학교)
	public ModelAndView searchContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_searchContent() 실행");
		ModelAndView mav = new ModelAndView();
		List searchList = onlineContentDAO.searchContent(arg0.getParameter("searchStr"));
		List off_searchList = offlineContentDAO.searchContent(arg0.getParameter("searchStr"));
		List cateList = categoryDAO.listCategory();
		System.out.println("검색결과 갯수 online: "+searchList.size());
		System.out.println("검색결과 갯수 offline: "+off_searchList.size());
		
		mav.addObject("searchList",searchList);
		mav.addObject("off_searchList",off_searchList);
		mav.addObject("cateList",cateList);
		mav.setViewName("content/contentList.jsp");
		return mav;

	}

}
