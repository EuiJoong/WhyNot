package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {
	
	@RequestMapping(value = "/event_list.event")//투표글 등록Pro
	public ModelAndView insertProPoll(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("PollController_insertProPoll() 실행");

		return new ModelAndView("");
	}
}
