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
		System.out.println("NomineeController_listNominee() ����");
		List<NomineeDBBean> list = nomineeDAO.listNominee();
		System.out.println("NomineeController_listNominee() ����");
		return new ModelAndView("admin/nominee/nominee_list.jsp", "nomineeList", list);
	}
	
	@RequestMapping(value = "/insert.nominee")
	public ModelAndView insertFormNominee(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		System.out.println("NomineeController_insertFormNominee() ����");
		System.out.println("NomineeController_getEvent");
		List<NomineeDBBean> list = nomineeDAO.getEventNum();
		return new ModelAndView("admin/nominee/nominee_insertForm.jsp", "eventNumList", list);
	}
	
	@RequestMapping(value = "/insertPro.nominee")
	public ModelAndView insertProEvent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		System.out.println("NomineeController_insertProNominee() ����");
		
		NomineeDBBean dto = new NomineeDBBean();
		dto.setNomiName(arg0.getParameter("nomiName"));
		dto.setEventNum(Integer.parseInt(arg0.getParameter("eventNum")));
		nomineeDAO.insertNominee(dto);
		System.out.println("insertProNominee() ����!");
		return new ModelAndView("list.nominee");
	}
	
	@RequestMapping(value = "/delete.nominee")
	public ModelAndView deleteNominee(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("NomineeController_deleteNominee() ����");
		nomineeDAO.deleteNominee(Integer.parseInt(arg0.getParameter("nomiNum")));
		System.out.println("��������!");
		return new ModelAndView("list.nominee");
	}
	
	@RequestMapping(value = "/update.nominee")
	public ModelAndView UpdateFormEvent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("NomineeController_UpdateFormNominee() ����");
		int nomiNum = Integer.parseInt(arg0.getParameter("nomiNum"));
		NomineeDBBean dto = nomineeDAO.getNominee(nomiNum);
		ModelAndView mav = new ModelAndView();
		List<NomineeDBBean> list = nomineeDAO.getEventNum();
		mav.setViewName("admin/nominee/nominee_updateForm.jsp");
		mav.addObject("nomiDTO", dto);
		mav.addObject("eventNumList", list);
		System.out.println("NomineeController_UpdateFormNominee() ����!");
		System.out.println(dto.getNomiNum());
		return mav;
	}

	@RequestMapping(value = "/updatePro.nominee")
	public ModelAndView UpdateProNominee(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("NomineeController_UpdateProNominee() ����");
		NomineeDBBean dto = new NomineeDBBean();
		dto.setNomiNum(Integer.parseInt(arg0.getParameter("nomiNum")));
		dto.setNomiName(arg0.getParameter("nomiName"));
		dto.setEventNum(Integer.parseInt(arg0.getParameter("eventNum")));
		nomineeDAO.updateNominee(dto);
		return new ModelAndView("list.nominee");
	}
}
