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

	@RequestMapping(value = "/insert.poll")//��ǥ�� ���Form
	public ModelAndView insertFormPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_insertFormPoll() ����");
		return new ModelAndView("event/poll/poll_insert.jsp");

	}

	@RequestMapping(value = "/insertPro.poll")//��ǥ�� ���Pro
	public ModelAndView insertProPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_insertProPoll() ����");

		return new ModelAndView("");
	}

	@RequestMapping(value = "/list.poll") //���
	public ModelAndView listPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_listPoll() ����");
		
		return new ModelAndView("event/board_list.jsp");
	}
	
	@RequestMapping(value = "/doPoll.poll") //����ڰ� ��ǥ �ϱ�
	public ModelAndView doPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_doPoll() ����");
		
		return new ModelAndView("");
	}
	
	
	@RequestMapping(value = "/delete.poll") //��ǥ�� ����
	public ModelAndView deletePoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_deletePoll() ����");
		return new ModelAndView("");
	}
	
	@RequestMapping(value = "/update.poll")//��ǥ�� ����Form
	public ModelAndView UpdateFormPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_UpdateFormPoll() ����");
		return new ModelAndView("");
	}

	@RequestMapping(value = "/updatePro.poll")//��ǥ�� ����Pro
	public ModelAndView UpdateProPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_UpdateProPoll() ����");
		return new ModelAndView("");
	}
	
}
