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

	@RequestMapping(value = "/list.poll") // 최상위(현재 진행중인..?) 투표 현황보기
	public ModelAndView listPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_listPoll() 실행");
		// 이거쓰자
		List list = eventPollDAO.getPoll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("currpollList", list);
		if (list.size() != 0)
			mav.addObject("eventtitle", ((CurrPollDBBean) list.get(0)).getEventtitle());
		else
			mav.addObject("eventtitle",0);
		/*System.out.println("이벤트 : " + ((CurrPollDBBean) list.get(0)).getEventtitle());
		System.out.println("currpollList.size() : " + list.size());*/
		mav.setViewName("vote/voteView.jsp");
		return mav;
	}

	@RequestMapping(value = "/doPoll.poll") // 사용자가 투표 하기
	public ModelAndView doPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_doPoll() 실행");

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
