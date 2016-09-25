package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDBBean;
import event.poll.model.EventPollDAO;

@Controller
public class PollController {
	
	private EventPollDAO eventPollDAO;
	
	public void setEventPollDAO(EventPollDAO eventPollDAO) {
		this.eventPollDAO = eventPollDAO;
	}

	@RequestMapping(value = "/insert.poll")//투표글 등록Form
	public ModelAndView insertFormPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_insertFormPoll() 실행");
		return new ModelAndView("event/poll/poll_insert.jsp");

	}

	@RequestMapping(value = "/insertPro.poll")//투표글 등록Pro
	public ModelAndView insertProPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_insertProPoll() 실행");

		return new ModelAndView("");
	}

	@RequestMapping(value = "/list.poll") //목록
	public ModelAndView listPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_listPoll() 실행");
		
		return new ModelAndView("event/board_list.jsp");
	}
	
	@RequestMapping(value = "/doPoll.poll") //사용자가 투표 하기
	public ModelAndView doPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_doPoll() 실행");
		
		return new ModelAndView("");
	}
	
	
	@RequestMapping(value = "/delete.poll") //투표글 삭제
	public ModelAndView deletePoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_deletePoll() 실행");
		return new ModelAndView("");
	}
	
	@RequestMapping(value = "/update.poll")//투표글 수정Form
	public ModelAndView UpdateFormPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_UpdateFormPoll() 실행");
		return new ModelAndView("");
	}

	@RequestMapping(value = "/updatePro.poll")//투표글 수정Pro
	public ModelAndView UpdateProPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_UpdateProPoll() 실행");
		return new ModelAndView("");
	}
	
}
