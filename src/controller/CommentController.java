package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import freeboard.model.CommentDAO;
import freeboard.model.CommentDBBean;
import freeboard.model.FreeBoardDAO;
import freeboard.model.FreeBoardDBBean;

@Controller
public class CommentController  {
	
	private CommentDAO commentDAO;

	public void setcommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	

	@RequestMapping(value="/insert.comment")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("CommentController_insert() 실행");
		arg0.setCharacterEncoding("UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		CommentDBBean dto = new CommentDBBean();
		
		System.out.println(arg0.getParameter("bnum")+","+arg0.getParameter("name")+","+arg0.getParameter("mnum")+","+arg0.getParameter("content"));
		
		
		String content = arg0.getParameter("content");
	    content = content.replace("\r\n","<br>");
		System.out.println(content);
		
		
		dto.setBnum(Integer.parseInt(arg0.getParameter("bnum")));
		dto.setName(arg0.getParameter("name"));
		dto.setMnum(Integer.parseInt(arg0.getParameter("mnum")));
		dto.setContent(content);

		System.out.println("실행!");
		commentDAO.insertComment(dto);
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("bnum",dto.getBnum());
		mav.addObject("mnum",10);
		mav.setViewName("content.freeboard");  //이동할 페이지
		
		return mav;
		}
	
	
	@RequestMapping(value="/delete.comment")
		protected ModelAndView Deletepro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("CommentController_delete() 실행");

		int cbnum = Integer.parseInt(arg0.getParameter("cbnum"));
		commentDAO.deleteComment(cbnum);

		ModelAndView mav = new ModelAndView();
		mav.addObject("bnum",Integer.parseInt(arg0.getParameter("bnum")));
		mav.addObject("mnum",Integer.parseInt(arg0.getParameter("mnum")));
		mav.setViewName("content.freeboard");  //이동할 페이지
		
		return mav;
	}
	
}