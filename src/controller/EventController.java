package controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDBBean;
import event.poll.model.EventDAO;
import event.poll.model.EventDBBean;

@Controller
public class EventController {
	
	private EventDAO eventDAO;
	
	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}
	
	@RequestMapping(value = "/list.event")
	public ModelAndView listEvent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		System.out.println("EventController_listEvent() 角青");
		List<EventDBBean> list = eventDAO.listEvent();
		return new ModelAndView("admin/event/event_list.jsp", "eventList", list);
	}
	
	@RequestMapping(value = "/insert.event")
	public ModelAndView insertFormEvent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("EventController_insertFormEvent() 角青");
		return new ModelAndView("admin/event/event_insertForm.jsp");

	}

	@RequestMapping(value = "/insertPro.event")
	public ModelAndView insertProEvent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		System.out.println("EventController_insertProEvent() 角青");
		
		EventDBBean dto = new EventDBBean();
		String date = arg0.getParameter("dateYY") + "-" + arg0.getParameter("dateMM") + "-" + arg0.getParameter("dateDD");
		dto.setEventTitle(arg0.getParameter("eventTitle"));
		dto.setDeadLine(date);
		eventDAO.insertEvent(dto);
		System.out.println("insertProEvent() 己傍!");
		return new ModelAndView("list.event");
	}
	
	@RequestMapping(value = "/delete.event")
	public ModelAndView deleteEvent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("EventController_deleteEvent() 角青");
		eventDAO.deleteEvent(Integer.parseInt(arg0.getParameter("eventNum")));
		System.out.println("昏力己傍!");
		return new ModelAndView("list.event");
	}
	
	@RequestMapping(value = "/update.event")
	public ModelAndView UpdateFormEvent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("EventController_UpdateFormEvent() 角青");
		int eventNum = Integer.parseInt(arg0.getParameter("eventNum"));
		EventDBBean dto = eventDAO.getEvent(eventNum);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/event/event_updateForm.jsp");
		mav.addObject("eventDTO", dto);
		System.out.println("EventController_UpdateFormEvent() 己傍!");
		System.out.println(dto.getEventNum());
		return mav;
	}

	@RequestMapping(value = "/updatePro.event")
	public ModelAndView UpdateProEvent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("EventController_UpdateProEvent() 角青");
		EventDBBean dto = new EventDBBean();
		dto.setEventNum(Integer.parseInt(arg0.getParameter("eventNum")));
		dto.setEventTitle(arg0.getParameter("eventTitle"));
		String date = arg0.getParameter("dateYY") + "-" + arg0.getParameter("dateMM") + "-" + arg0.getParameter("dateDD");
		dto.setDeadLine(date);
		eventDAO.updateEvent(dto);
		return new ModelAndView("list.event");
	}
}
