package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDBBean;
import event.poll.model.CurrPollDBBean;
import event.poll.model.EventPollDAO;
import event.poll.model.PollDAO;
import event.poll.model.PollDBBean;

@Controller
public class PollController {

	private PollDAO pollDAO;
	private EventPollDAO eventPollDAO;

	public void setPollDAO(PollDAO pollDAO) {
		this.pollDAO = pollDAO;
	}

	public void setEventPollDAO(EventPollDAO eventPollDAO) {
		this.eventPollDAO = eventPollDAO;
	}

	@RequestMapping(value = "/list.poll") // �ֻ���(���� ��������..?) ��ǥ ��Ȳ����
	public ModelAndView listPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_listPoll() ����");
		// �̰ž���
		List list = eventPollDAO.getPoll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("currpollList", list);
		if (list.size() != 0)
			mav.addObject("eventtitle", ((CurrPollDBBean) list.get(0)).getEventtitle());
		else
			mav.addObject("eventtitle",0);
		/*System.out.println("�̺�Ʈ : " + ((CurrPollDBBean) list.get(0)).getEventtitle());
		System.out.println("currpollList.size() : " + list.size());*/
		mav.setViewName("vote/voteView.jsp");
		return mav;
	}

	@RequestMapping(value = "/doPoll.poll") // ����ڰ� ��ǥ �ϱ�
	public ModelAndView doPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_doPoll() ����");

		String para = arg0.getParameter("eventNum");
		List<PollDBBean> pollList = null;
		if (para != null) {
			int eventNum = Integer.parseInt(para);
			pollList = pollDAO.listPoll(eventNum);
		} else
			pollList = pollDAO.listPoll();
		System.out.println(pollList.size());
		List<PollDBBean> eventList = pollDAO.getAllEvent();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/poll/poll_list.jsp");
		mav.addObject("pollList", pollList);
		mav.addObject("eventList", eventList);
		return mav;
	}
}
