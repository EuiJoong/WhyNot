package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import event.poll.model.PollDAO;
import event.poll.model.PollDBBean;

@Controller
public class PollController {
	
	private PollDAO pollDAO;
	
	public void setPollDAO(PollDAO pollDAO) {
		this.pollDAO = pollDAO;
	}

	@RequestMapping(value = "/list.poll") //목록
	public ModelAndView listPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_listPoll() 실행");
		String para = arg0.getParameter("eventNum");
		List<PollDBBean> pollList = null;
		if(para!=null)
		{
			int eventNum = Integer.parseInt(para);
			pollList = pollDAO.listPoll(eventNum);
		}
		else pollList = pollDAO.listPoll();
		System.out.println(pollList.size());
		List<PollDBBean> eventList = pollDAO.getAllEvent();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/poll/poll_list.jsp");
		mav.addObject("pollList", pollList);
		mav.addObject("eventList", eventList);
		return mav;
	}
}
