package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import requestboard.model.RequestBoardDAO;
import requestboard.model.RequestBoardDBBean;

@Controller
public class RequestBoardController {

	private RequestBoardDAO requestBoardDAO;

	public void setRequestBoardDAO(RequestBoardDAO requestBoardDAO) {
		this.requestBoardDAO = requestBoardDAO;
	}

	@RequestMapping(value = "/list.requestboard")
	public ModelAndView ListBorad(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("requestboardController_listpushboard() 실행");
		int pageBlock = 10;
		int pageSize = 20;
		String pageNum = arg0.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int start = pageSize * (currentPage - 1) + 1;
		int end = start + pageSize - 1;

		int count = requestBoardDAO.getCount();
		// int count = 1;

		if (end > count)
			end = count;
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);

		List list = requestBoardDAO.listBoard(start, end);

		int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;

		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/request/list.jsp"); // 이동할 페이지
		mav.addObject("pushboardList", list);
		mav.addObject("count", count);
		mav.addObject("pageBlock", pageBlock);
		mav.addObject("currentPage", currentPage);
		mav.addObject("pageSize", pageSize);
		mav.addObject("pageCount", pageCount);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);

		return mav;
	}

	@RequestMapping(value = "/insertFrom.requestboard")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PushboardController_insertpushboard() 실행");
		ModelAndView mav = new ModelAndView();
		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		String id = arg0.getParameter("id");
		RequestBoardDBBean dto = null;

		mav.addObject("mnum", mnum);
		mav.addObject("id", id);
		mav.setViewName("board/request/insertForm.jsp");
		return mav;
	}

	@RequestMapping(value = "/insertPro.requestboard")
	protected ModelAndView writePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("FreeBoardController_insertProfreeBoard() 실행");

		RequestBoardDBBean dto = new RequestBoardDBBean();

		System.out.println(arg0.getParameter("mnum"));
		dto.setId(arg0.getParameter("id"));
		dto.setMnum(Integer.parseInt(arg0.getParameter("mnum")));
		dto.setSubject(arg0.getParameter("subject"));
		dto.setContent(arg0.getParameter("content"));

		System.out.println("실행!");
		requestBoardDAO.insertBoard(dto);

		return new ModelAndView("list.requestboard");
	}

	@RequestMapping(value = "/content.requestboard")
	protected ModelAndView contentBoard(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("PushBoardController_contentpushBoard() 실행");
		ModelAndView mav = new ModelAndView();

		RequestBoardDBBean dto = new RequestBoardDBBean();
		System.out.println(arg0.getParameter("mnum") + "," + arg0.getParameter("bnum"));

		dto.setId(arg0.getParameter("id"));
		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		int bnum = Integer.parseInt(arg0.getParameter("bnum"));
		String id = arg0.getParameter("id");

		boolean cchk = false;

		System.out.println(mnum);
		System.out.println(cchk);

		int chk = requestBoardDAO.chk(bnum);

		System.out.println(chk);

		if (chk == mnum)
			cchk = true;

		System.out.println(cchk);

		dto = requestBoardDAO.getBoard("content", bnum);

		System.out.println("vv");

		mav.setViewName("board/request/content.jsp"); // 이동할 페이지
		mav.addObject("cchk", cchk);
		mav.addObject("boardDTO", dto);
		mav.addObject("mnum", mnum);
		mav.addObject("bnum", bnum);
		mav.addObject("id", id);

		return mav;
	}

	@RequestMapping(value = "/delete.requestboard")
	protected ModelAndView Deletepro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PushBoardController_deletepushboard() 실행");

		int bnum = Integer.parseInt(arg0.getParameter("bnum"));
		requestBoardDAO.deleteBoard(bnum);

		return new ModelAndView("list.requestboard");
	}

	@RequestMapping(value = "/push.requestboard")
	protected ModelAndView push(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PushBoardController_deletepushboard() 실행");

		int bnum = Integer.parseInt(arg0.getParameter("bnum"));
		requestBoardDAO.push(bnum);

		return new ModelAndView("list.requestboard");
	}

	@RequestMapping(value = "/updateform.requestboard")
	protected ModelAndView UpdateForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("PushBoardController_updateformpushboard() 실행");
		ModelAndView mav = new ModelAndView();
		int bnum = Integer.parseInt(arg0.getParameter("bnum")); // 넘어 온값을 int
																// 값으로
		RequestBoardDBBean dto = requestBoardDAO.getBoard("content", bnum);

		mav.addObject("bnum", bnum);
		mav.addObject("pushboardDAO", dto);
		mav.setViewName("board/request/updateForm.jsp");

		return mav;
	}

	@RequestMapping(value = "/updatePro.requestboard")
	protected ModelAndView UpdatePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		System.out.println("FreeBoardController_updateProfreeboard() 실행");
		RequestBoardDBBean dto = new RequestBoardDBBean();
		dto.setBnum(Integer.parseInt(arg0.getParameter("bnum")));
		dto.setId(arg0.getParameter("id"));
		dto.setSubject(arg0.getParameter("subject"));
		dto.setContent(arg0.getParameter("content"));

		requestBoardDAO.updateBoard(dto);
		return new ModelAndView("list.requestboard");
	}
}