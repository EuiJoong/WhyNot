package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import event.poll.model.EventDBBean;
import event.poll.model.NomineeDAO;
import event.poll.model.NomineeDBBean;

@Controller
public class NomineeController
{

	private NomineeDAO nomineeDAO;
	
	public void setNomineeDAO(NomineeDAO nomineeDAO)
	{
		this.nomineeDAO = nomineeDAO;
	}
	
	@RequestMapping(value = "/list.nominee")
	public ModelAndView listNominee(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		System.out.println("NomineeController_listNominee() 角青");
		List<NomineeDBBean> list = nomineeDAO.listNominee();
		System.out.println("NomineeController_listNominee() 己傍");
		return new ModelAndView("admin/nominee/nominee_list.jsp", "nomineeList", list);
	}
	
	@RequestMapping(value = "/insert.nominee")
	public ModelAndView insertFormNominee(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		System.out.println("NomineeController_insertFormNominee() 角青");
		System.out.println("NomineeController_getEvent");
		List<NomineeDBBean> list = nomineeDAO.getEventNum();
		return new ModelAndView("admin/nominee/nominee_insertForm.jsp", "eventNumList", list);
	}
	
	@RequestMapping(value = "/insertPro.nominee")
	public ModelAndView insertProEvent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		System.out.println("NomineeController_insertProNominee() 角青");
		
		NomineeDBBean dto = new NomineeDBBean();
		dto.setNomiName(arg0.getParameter("nomiName"));
		dto.setEventNum(Integer.parseInt(arg0.getParameter("eventNum")));
		nomineeDAO.insertNominee(dto);
		System.out.println("insertProNominee() 己傍!");
		return new ModelAndView("list.nominee");
	}
	
	@RequestMapping(value = "/delete.nominee")
	public ModelAndView deleteNominee(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("NomineeController_deleteNominee() 角青");
		nomineeDAO.deleteNominee(Integer.parseInt(arg0.getParameter("nomiNum")));
		System.out.println("昏力己傍!");
		return new ModelAndView("list.nominee");
	}
	
	@RequestMapping(value = "/update.nominee")
	public ModelAndView UpdateFormEvent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("NomineeController_UpdateFormNominee() 角青");
		int nomiNum = Integer.parseInt(arg0.getParameter("nomiNum"));
		NomineeDBBean dto = nomineeDAO.getNominee(nomiNum);
		ModelAndView mav = new ModelAndView();
		List<NomineeDBBean> list = nomineeDAO.getEventNum();
		mav.setViewName("admin/nominee/nominee_updateForm.jsp");
		mav.addObject("nomiDTO", dto);
		mav.addObject("eventNumList", list);
		System.out.println("NomineeController_UpdateFormNominee() 己傍!");
		System.out.println(dto.getNomiNum());
		return mav;
	}

	@RequestMapping(value = "/updatePro.nominee")
	public ModelAndView UpdateProNominee(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("NomineeController_UpdateProNominee() 角青");
		NomineeDBBean dto = new NomineeDBBean();
		dto.setNomiNum(Integer.parseInt(arg0.getParameter("nomiNum")));
		dto.setNomiName(arg0.getParameter("nomiName"));
		dto.setEventNum(Integer.parseInt(arg0.getParameter("eventNum")));
		nomineeDAO.updateNominee(dto);
		return new ModelAndView("list.nominee");
	}
}
