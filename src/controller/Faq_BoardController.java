package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import faqboard.model.FaqBoardDAO;
import faqboard.model.FaqboardDBBean;
import faqboard.model.FaqcodeDBBean;

@Controller
public class Faq_BoardController {

	private FaqBoardDAO faqBoardDAO;

	public void setFaqBoardDAO(FaqBoardDAO faqBoardDAO) {
		this.faqBoardDAO = faqBoardDAO;
	}

	@RequestMapping(value = "/list.faq")
	public ModelAndView listFAQ(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		return new ModelAndView("board/faq/faqmenu.jsp");
	}

	// FAQ �Խ��� ���� �̵� �ڵ� ������
	@RequestMapping(value = "/Faqboardlist.faq")
	public ModelAndView listFAOBoard(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("insertFormCategory");
		ModelAndView mav = new ModelAndView();
		FaqcodeDBBean dto = new FaqcodeDBBean();
		List<FaqcodeDBBean> list = faqBoardDAO.codelist();
		List<FaqboardDBBean> wholeboardlist = faqBoardDAO.getwholeboardlist();// ��ü
																				// ����Ʈ

		int count = faqBoardDAO.getCodeCount();

		System.out.println(list);

		mav.addObject("list", list);
		mav.addObject("wholeboardlist", wholeboardlist);
		mav.addObject("count", count);
		mav.setViewName("board/faq/faqBoardList.jsp");
		return mav;
	}

	// �ڵ� �� �޾ƿͼ� FAQboard ���� ���ڵ忡 �´� ���� ������ �ٽ� ����Ʈ�� �̵�
	@RequestMapping(value = "/faqboard.faq")
	public ModelAndView faqboardList(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		FaqcodeDBBean dto = new FaqcodeDBBean();
		List<FaqcodeDBBean> list = faqBoardDAO.codelist();
		int code = ServletRequestUtils.getIntParameter(arg0, "code");
		int count = faqBoardDAO.getCodeCount();

		System.out.println(list);

		List<FaqboardDBBean> boardlist = faqBoardDAO.boardlist(code);

		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("boardlist", boardlist);
		mav.setViewName("board/faq/faqBoardList.jsp");
		return mav;
	}

	// �ڵ� ���� �ϴ°� ���� �̵�
	@RequestMapping(value = "/faqcodeinsert.faq")
	public ModelAndView faqcodeinsert(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();

		return new ModelAndView("board/faq/faqcodeinsert.jsp");
	}

	// �ڵ� ���� �ϴ°����� ���� �޾Ƽ� ó��
	@RequestMapping(value = "/faqcodeinsert_pro.faq")
	public ModelAndView faqcodeinsert_pro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String code = arg0.getParameter("code");

		boolean isCode = faqBoardDAO.checkCode(code);
		String msg;
		String url = null;
		if (isCode) {
			msg = "�̹� ������� �ڵ��Դϴ�,";
			url = "board/faq/faqcodeinsert.jsp";
			System.out.println(1);
		} else {
			FaqcodeDBBean dto = new FaqcodeDBBean();
			dto.setCode(arg0.getParameter("code"));
			dto.setName(arg0.getParameter("name"));
			faqBoardDAO.faqcodeinsert(dto);
			msg = "�ڵ���� ����";
			url = "board/faq/faqmenu.jsp";
			System.out.println(2);

		}
		mav.addObject("msg", msg);
		mav.setViewName(url);
		return mav;
	}

	@RequestMapping(value = "/faqcodelist.faq")
	public ModelAndView faqCodelist(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		FaqcodeDBBean dto = new FaqcodeDBBean();
		List<FaqcodeDBBean> list = faqBoardDAO.codelist();
		System.out.println(list);

		mav.addObject("list", list);
		mav.setViewName("board/faq/faqcodelist.jsp");
		return mav;
	}

	@RequestMapping(value = "/faqcodeDelete.faq")
	public ModelAndView faqCodeDelete(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();

		String msg;
		String code = arg0.getParameter("code");

		faqBoardDAO.deletcode(code);
		msg = "Code ���� ����";
		mav.addObject("msg", msg);
		mav.setViewName("board/faq/faqmenu.jsp");
		return mav;
	}

	@RequestMapping(value = "/faqcodeUpdate.faq")
	public ModelAndView faqCodeUpdate(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();

		String code = arg0.getParameter("code");

		mav.addObject("code", code);
		mav.setViewName("board/faq/faqcodeupdate.jsp");
		return mav;
	}

	@RequestMapping(value = "/faqcodeUpdate_pro.faq")
	public ModelAndView faqCodeUpdate_pro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();

		String msg;
		FaqcodeDBBean codeDto = new FaqcodeDBBean();
		codeDto.setCode(arg0.getParameter("code"));
		codeDto.setName(arg0.getParameter("name"));
		faqBoardDAO.UpdateCode(codeDto);
		msg = "Code ���� ����";
		mav.addObject("msg", msg);
		mav.setViewName("board/faq/faqmenu.jsp");

		return mav;
	}

	@RequestMapping(value = "/faqboardinsert.faq")
	public ModelAndView faqboardform(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();

		FaqcodeDBBean dto = new FaqcodeDBBean();
		List<FaqcodeDBBean> list = faqBoardDAO.codelist();
		System.out.println(list);
		mav.addObject("list", list);
		mav.setViewName("board/faq/faqboardinsertform.jsp");
		return mav;
	}

	@RequestMapping(value = "/faqboardinsert_pro.faq")
	public ModelAndView faqboardinsert_pro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String msg;
		String content = arg0.getParameter("content");
		content = content.replace("\r\n", "<br>");

		FaqboardDBBean FaqBoardDto = new FaqboardDBBean();
		FaqBoardDto.setFaq_code(arg0.getParameter("faq_code"));
		FaqBoardDto.setTitle(arg0.getParameter("title"));
		FaqBoardDto.setContent(content);
		faqBoardDAO.insertfaqboard(FaqBoardDto);
		msg = "FAQ�Խ��� ��� ����";
		mav.addObject("msg", msg);
		mav.setViewName("board/faq/faqmenu.jsp");
		return mav;
	}

	@RequestMapping(value = "/FaqBoardUpdate.faq")
	public ModelAndView faqboardUpdate(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int qnum = ServletRequestUtils.getIntParameter(arg0, "qnum");
		FaqcodeDBBean dto = new FaqcodeDBBean();
		List<FaqcodeDBBean> list = faqBoardDAO.codelist();

		FaqboardDBBean boardDto = faqBoardDAO.getfaqboard(qnum);
		String content = boardDto.getContent().replace("<br>", "\r\n");
		System.out.println(list);
		mav.addObject("list", list);
		mav.addObject("qnum", qnum);
		mav.addObject("boardDto", boardDto);
		mav.addObject("content", content);
		mav.setViewName("board/faq/faqboardUpdateform.jsp");
		return mav;
	}

	@RequestMapping(value = "/faqboardUpdate_pro.faq")
	public ModelAndView faqboardUpdate_pro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String msg;
		String content = arg0.getParameter("content");
		content = content.replace("\r\n", "<br>");
		FaqboardDBBean boarddto = new FaqboardDBBean();
		boarddto.setQnum(ServletRequestUtils.getIntParameter(arg0, "qnum"));
		boarddto.setFaq_code(arg0.getParameter("faq_code"));
		boarddto.setTitle(arg0.getParameter("title"));
		boarddto.setContent(content);
		faqBoardDAO.updatefaqboard(boarddto);

		msg = "FAQ�Խ��� ���� ����";
		mav.addObject("msg", msg);
		mav.setViewName("board/faq/faqmenu.jsp");
		return mav;
	}

	@RequestMapping(value = "/FaqBoardDelete.faq")
	public ModelAndView faqboardDelete(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String msg;

		int qnum = ServletRequestUtils.getIntParameter(arg0, "qnum");
		System.out.println("qnum" + qnum);
		faqBoardDAO.deletfaqboard(qnum);

		msg = "���� ����";
		mav.addObject("msg", msg);
		mav.setViewName("board/faq/faqmenu.jsp");
		return mav;
	}
}
