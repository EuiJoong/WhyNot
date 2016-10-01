package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import freeboard.model.CommentDAO;
import freeboard.model.FreeBoardDAO;
import freeboard.model.FreeBoardDBBean;

@Controller
public class FreeBoardController  {
	
	private FreeBoardDAO freeboardDAO;
	private CommentDAO commentDAO;

	public void setFreeboardDAO(FreeBoardDAO freeboardDAO) {
		this.freeboardDAO = freeboardDAO;
	}
	public void setcommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	
	@RequestMapping(value="/list.freeboard")
	public ModelAndView ListBorad(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FreeboardController_listfreeboard() 실행");
		int pageBlock = 5;
		int pageSize = 5;
		String pageNum = arg0.getParameter("pageNum");
		if(pageNum == null){
			pageNum= "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int start = pageSize*(currentPage-1)+1;
		int end = start + pageSize-1;
		
		int count = freeboardDAO.freegetCount();
		//int count = 1;
		
		if(end>count) end = count;  
		int pageCount = count/pageSize +(count%pageSize==0 ? 0 : 1);
		
		List list = freeboardDAO.listfreeBoard(start,end);

		
		int startPage = (currentPage-1)/pageBlock * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/free/list.jsp");  //이동할 페이지
		mav.addObject("freeboardList", list);
		mav.addObject("count",count);
		mav.addObject("pageBlock",pageBlock);
		mav.addObject("currentPage",currentPage);
		mav.addObject("pageSize",pageSize);
		mav.addObject("pageCount",pageCount);
		mav.addObject("startPage",startPage);
		mav.addObject("endPage",endPage);
		
		return mav;
	}

	@RequestMapping(value="/insertFrom.freeboard")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav=new ModelAndView();
		System.out.println("FreeboardController_insertfreeboard() 실행");
		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		String name = arg0.getParameter("name");
		int bnum = 0,re_step = 0, re_level = 0;
		FreeBoardDBBean dto = null;
		String snum = arg0.getParameter("bnum");
		if (snum != null){//답글일경우 참이 된다 
				bnum = Integer.parseInt(snum);
				System.out.println("글쓰기 폼으로가 기전 bnum"+bnum);
				re_step = Integer.parseInt(arg0.getParameter("re_step"));
				re_level = Integer.parseInt(arg0.getParameter("re_level"));
				System.out.println("글쓰기 폼으로가 기전 re_step"+re_step);
				System.out.println("글쓰기 폼으로가 기전 re_level"+re_level);
		}
		mav.addObject("mnum",mnum);
		mav.addObject("bnum",bnum);
		mav.addObject("name",name);
		mav.addObject("re_step",re_step);
		mav.addObject("re_level",re_level);
		mav.setViewName("board/free/insertForm.jsp");
		return mav;
		}
	
	@RequestMapping(value="/insertPro.freeboard")
	protected ModelAndView writePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("FreeBoardController_insertProfreeBoard() 실행");
		
		FreeBoardDBBean dto = new FreeBoardDBBean();
		
		System.out.println(arg0.getParameter("mnum"));
		dto.setName(arg0.getParameter("name"));
		dto.setMnum(Integer.parseInt(arg0.getParameter("mnum")));
		dto.setSubject(arg0.getParameter("subject"));
		dto.setContent(arg0.getParameter("content"));

		int re_step = 0;
		int re_level = 0;

		if(arg0.getParameter("re_step")!=null) re_step = Integer.parseInt((arg0.getParameter("re_step")));
		if(arg0.getParameter("re_level")!=null) re_level = Integer.parseInt((arg0.getParameter("re_level")));
		
		dto.setRe_step(re_step);
		dto.setRe_level(re_level);
		System.out.println("실행!");
		freeboardDAO.insertfreeBoard(dto);
		
		return new ModelAndView("list.freeboard");
	}
	
	
	@RequestMapping(value="/content.freeboard")
	protected ModelAndView contentBoard(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("FreeBoardController_contentfreeBoard() 실행");
		ModelAndView mav = new ModelAndView();

		FreeBoardDBBean dto = new FreeBoardDBBean();
		System.out.println(arg0.getParameter("mnum")+","+arg0.getParameter("bnum"));
		
		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		int bnum = Integer.parseInt(arg0.getParameter("bnum"));
		String name = arg0.getParameter("name");
		
		boolean cchk = false;

		
		System.out.println(mnum);
		System.out.println(cchk);
		
		int chk = freeboardDAO.freechk(bnum);
		
		System.out.println(chk);
		
		if(chk==mnum)cchk = true;
		
		System.out.println(cchk);
		
		dto = freeboardDAO.getfreeBoard("content",bnum);
		
		List list = commentDAO.listCommnet(bnum);
		System.out.println("vv");
		
		
		mav.setViewName("board/free/content.jsp");  //이동할 페이지
		mav.addObject("cchk",cchk);
		mav.addObject("commentlist",list);
		mav.addObject("boardDTO",dto);
		mav.addObject("mnum",mnum);
		mav.addObject("bnum",bnum);
		mav.addObject("name",name);
		
		return mav;
	}
	
	
	@RequestMapping(value="/delete.freeboard")
		protected ModelAndView Deletepro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("FreeBoardController_deletefreeboard() 실행");
		
			int bnum = Integer.parseInt(arg0.getParameter("bnum"));
			freeboardDAO.deletefreeBoard(bnum);
			
			return new ModelAndView("list.freeboard");
	}
	
	@RequestMapping(value="/updateform.freeboard")
	protected ModelAndView UpdateForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FreeBoardController_updateformfreeboard() 실행");
		ModelAndView mav = new ModelAndView();
		int bnum = Integer.parseInt(arg0.getParameter("bnum"));  //넘어 온값을 int 값으로
		FreeBoardDBBean dto = freeboardDAO.getfreeBoard("content",bnum); 

		mav.addObject("bnum",bnum);
		mav.addObject("freeboardDAO",dto);
		mav.setViewName("board/free/updateForm.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/updatePro.freeboard")
	protected ModelAndView UpdatePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		System.out.println("FreeBoardController_updateProfreeboard() 실행");
		FreeBoardDBBean dto = new FreeBoardDBBean();
		dto.setBnum(Integer.parseInt(arg0.getParameter("bnum")));
		dto.setName(arg0.getParameter("name"));
		dto.setSubject(arg0.getParameter("subject"));
		dto.setContent(arg0.getParameter("content"));
		
		freeboardDAO.updatefreeBoard(dto);
		return new ModelAndView("list.freeboard");
	}
}