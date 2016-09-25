package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;
import offlinecontent.model.OfflineContentDAO;
import onlinecontent.model.OnlineContentDAO;

public class SearchController {
	private OnlineContentDAO onlineContentDAO;
	private OfflineContentDAO offlineContentDAO;

	public void setOnlineContentDAO(OnlineContentDAO onlineContentDAO) {
		this.onlineContentDAO = onlineContentDAO;
	}

	public void setOfflineContentDAO(OfflineContentDAO offlineContentDAO) {
		this.offlineContentDAO = offlineContentDAO;
	}
	
	@RequestMapping(value = "/cont.search") // �ΰ����Form(�б�)
	public ModelAndView searchContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OnContentController_searchContent() ����");
		/*List searchList = Online*/
		return new ModelAndView("content/online/cont_insertForm.jsp");

	}
}
