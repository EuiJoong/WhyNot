package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.ServletUtils;

import assessment.model.AssessmentDBBean;
import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;
import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;
import member.model.MemberDBBean;
import offlinecontent.model.ClassRoomDBBean; 
import offlinecontent.model.OfflineContentDAO;
import offlinecontent.model.OfflineContentDBBean;
import offlinecontent.model.ReserveDateDBBean;
import offlinecontent.model.SponsorDBBean;
import onlinecontent.model.OnlineContentDBBean;
import onlinecurriculum.model.OnlineCurriculumDBBean;
import payment.model.OnlinePaymentDBBean;
import payment.model.PaymentDAO;

@Controller
public class OffContentController {

	private OfflineContentDAO offlineContentDAO;
	private CategoryDAO categoryDAO;
	private PaymentDAO paymentDAO;
	
	public void setOfflineContentDAO(OfflineContentDAO offlineContentDAO) {
		this.offlineContentDAO = offlineContentDAO;
	}
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}
	
	// -------------- �������� ������ -----------------------------------
    @RequestMapping(value = "/offcont_insertForm.offcont") // �ǰ����Form
    public ModelAndView insertFormOffContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertFormOffContent() ����");
		Iterator<String> it = arg0.getParameterMap().keySet().iterator();
		while(it.hasNext()){
			System.out.println("parameter key�� : "+it.next());
		}
		System.out.println("addr : "+arg0.getParameter("addr"));
		System.out.println("reserve_date : "+arg0.getParameter("reserve_date"));
		System.out.println("time : "+arg0.getParameter("time"));
		System.out.println("crnum : "+arg0.getParameter("cr_num"));
		List<CategoryDBBean> list = categoryDAO.listCategory();
		return new ModelAndView("content/offline/cont_insertForm.jsp", "cateList", list);

    }
    
    @RequestMapping(value = "/offcont_insertPro.offcont") // �ǰ����Pro
    public ModelAndView insertProOffContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertProOffContent() ����");
		
		MultipartRequest mr = null;
		String upPath = arg0.getServletContext().getRealPath("images");
		try{
			mr = new MultipartRequest(arg0, upPath, 10*1024*1024,"UTF-8"); 
		}catch(IOException e){}
		OfflineContentDBBean offDTO = new OfflineContentDBBean();
		offDTO.setCtnum(Integer.parseInt(mr.getParameter("ctnum")));
		if(mr.getParameter("mnum")==null){
			List<CategoryDBBean> list = categoryDAO.listCategory();
			Map map = new HashMap();
				map.put("cateList", list);
				map.put("res", "����");
			return new ModelAndView("content/offline/cont_insertForm.jsp", map);
		}
		offDTO.setMnum(Integer.parseInt(mr.getParameter("mnum")));
		offDTO.setTitle(mr.getParameter("title"));
		offDTO.setContent(mr.getParameter("content"));
		offDTO.setPeriod(mr.getParameter("period"));
		offDTO.setGoal_amount(Integer.parseInt(mr.getParameter("goal_amount")));
		offDTO.setMin_amount(Integer.parseInt(mr.getParameter("min_amount")));
		if(mr.getParameter("cr_num") == null || mr.getParameter("cr_num").equals("")) {
			offDTO.setCr_num(0);
		} else {
			offDTO.setCr_num(Integer.parseInt(mr.getParameter("cr_num")));
		}
		offDTO.setReserve_date(mr.getParameter("reserve_date"));
		////////////////////////////////////////////////////////////////////////////
		ClassRoomDBBean crDTO = new ClassRoomDBBean();
		if(mr.getParameter("cr_num") == null || mr.getParameter("cr_num").equals("")) {
			crDTO.setCr_num(0);
		} else {
			crDTO.setCr_num(Integer.parseInt(mr.getParameter("cr_num")));
		}
		crDTO.setTime(mr.getParameter("time"));
		crDTO.setMax_num(Integer.parseInt(mr.getParameter("max_num")));
		crDTO.setAddr(mr.getParameter("addr"));
		crDTO.setReserve_date(mr.getParameter("reserve_date"));
		////////////////////////////////////////////////////////////////////////////
		ReserveDateDBBean rdateDTO = new ReserveDateDBBean();
		rdateDTO.setReserve_date(mr.getParameter("reserve_date"));
		if(mr.getParameter("cr_num") == null || mr.getParameter("cr_num").equals("")) {
			rdateDTO.setCr_num(0);
		} else {
			rdateDTO.setCr_num(Integer.parseInt(mr.getParameter("cr_num")));
		}
		rdateDTO.setCl_reserve_stats("����Ϸ�");
		////////////////////////////////////////////////////////////////////////////
		PhotoDBBean ptDTO = new PhotoDBBean();
		ptDTO.setMnum(Integer.parseInt(mr.getParameter("mnum")));
		String fileName = mr.getFilesystemName("image-file");
		ptDTO.setFilename(fileName.substring(0,fileName.lastIndexOf(".")));
		ptDTO.setFileext(fileName.substring(fileName.lastIndexOf(".")+1));
		ptDTO.setFiledir(upPath);
		////////////////////////////////////////////////////////////////////////////
		System.out.println("addr : "+mr.getParameter("addr"));
		System.out.println("reserve_date : "+mr.getParameter("reserve_date"));
		System.out.println("time : "+mr.getParameter("time"));
		System.out.println("crnum : "+mr.getParameter("cr_num"));
		boolean res = offlineContentDAO.insertContent(offDTO, crDTO, rdateDTO, ptDTO);
		
		
		if(res) return new ModelAndView("content/offline/cont_insertForm.jsp","res","����");
		else {
			List<CategoryDBBean> list = categoryDAO.listCategory();
			Map map = new HashMap();
				map.put("cateList", list);
				map.put("res", "����");
			return new ModelAndView("content/offline/cont_insertForm.jsp", map);
		}
		
    }
	
	@RequestMapping(value = "/classroom_reserve.offcont") // ���ǽ� �뿩
	public ModelAndView reserveClassroom(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OffContentController_reserveClassroom() ����");
		String addr = "";
		String reserve_date= "";
		String time = "";
		Map paramMap = null;
		List searchList = null;
		if(arg0.getParameter("addr")!=null || arg0.getParameter("reserve_date")!=null || arg0.getParameter("time")!=null){
			paramMap = new HashMap<>();
			if(arg0.getParameter("addr")!=null && !arg0.getParameter("addr").equals("#"))
				addr = arg0.getParameter("addr");
			if(arg0.getParameter("reserve_date")!=null && !arg0.getParameter("reserve_date").equals(""))
				reserve_date = arg0.getParameter("reserve_date");
			if(arg0.getParameter("time")!=null && !arg0.getParameter("time").equals("#"))
				time=arg0.getParameter("time");
			paramMap.put("addr", addr);
			paramMap.put("reserve_date", reserve_date);
			paramMap.put("time", time);
			System.out.println("addr :" +addr+", reserve_date :"+reserve_date+", time :"+time);
			searchList = offlineContentDAO.listSearchClassRoom(paramMap);
		}
		
		Map map = new HashMap<>();
		List list = offlineContentDAO.listClassRoom();	// ������ DTO List
		Set<String> set = new TreeSet<>();	// ������ �ּ� �ߺ��ȵǰ� set����..
		set.addAll(list);
		if(searchList != null) {
			for(int i=0; i<searchList.size(); i++) {
				System.out.println("OfflineContentController : "+searchList.get(i).toString());
			}
		}
		map.put("addrSet", set);
		if(searchList != null)
			map.put("searchList", searchList);
		
		return new ModelAndView("content/offline/classroom_reserve.jsp", map);
    }
	
	@RequestMapping(value = "/cont_detail.offcont") // �Ŀ� �󼼺���
	public ModelAndView off_detailContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OfflineContentController_off_detailContent() ����");
		int offnum = Integer.parseInt(arg0.getParameter("offnum"));
		Map map = offlineContentDAO.getContent(offnum);
		
		OfflineContentDBBean offDTO = (OfflineContentDBBean)map.get("offContentDTO");
		String period = offDTO.getPeriod();	// d-day����ϱ�
		map.put("dDay", calDday(Integer.parseInt(period.substring(0,4)), Integer.parseInt(period.substring(4,6)), Integer.parseInt(period.substring(6))));
		
		String tempDate = offDTO.getReserve_date();	// ��¥ ����
		String reserveDate = tempDate.substring(0,4) +"��"+tempDate.substring(4,6)+"��"+tempDate.substring(6)+"��"; 
		map.put("reserveDate", reserveDate);
		
		MemberDBBean memberDTO = (MemberDBBean)arg0.getSession().getAttribute("memberDTO");
		if(memberDTO != null) {
			List<SponsorDBBean> spList = (List)map.get("sponsorList");
			String isPartici = "no";
			for(int i=0; i<spList.size(); i++){	// ���� �������� �ǰ� �������� üũ
				if(memberDTO.getMnum() == spList.get(i).getMnum() && spList.get(i).getParticichk().equals("ok")) {
					isPartici = "ok";
					break;
				}
			}
			map.put("isPartici", isPartici);
		}
		if(arg0.getParameter("res") != null)
			map.put("res", arg0.getParameter("res"));
		
		return new ModelAndView("content/offline/cont_detailForm.jsp", map);
	}
	
	@RequestMapping(value = "/cont_sponsor.offcont") // �Ŀ� �ϱ�
	public ModelAndView off_sponsorContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OfflineContentController_off_sponsorContent() ����");
		int sponsor = ServletRequestUtils.getIntParameter(arg0, "sponsor");
		String particiChk = arg0.getParameter("particiChk");
		int offnum = ServletRequestUtils.getIntParameter(arg0, "offnum");
		System.out.println(sponsor+"/"+particiChk+"/"+offnum);
		SponsorDBBean spDTO = new SponsorDBBean();
		MemberDBBean memberDTO = (MemberDBBean)arg0.getSession().getAttribute("memberDTO");
		Map map = new HashMap();
		map.put("offnum", offnum);
		if(memberDTO == null) {
			map.put("res", "notLogin");
			return new ModelAndView("cont_detail.offcont", map);
		}
		spDTO.setMnum(memberDTO.getMnum());
		spDTO.setOffnum(offnum);
		spDTO.setParticichk(particiChk);
		spDTO.setSpamount(sponsor);
		spDTO.setSpdate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		
		String res = offlineContentDAO.updateSponsor(spDTO);
		map.put("res", res);
		return new ModelAndView("redirect:cont_detail.offcont", map);
	}
	
	 public int calDday(int myear, int mmonth, int mday) {	// d-day���
	        try {
	            Calendar today = Calendar.getInstance(); //���� ���� ��¥
	            Calendar dday = Calendar.getInstance(); 
	            dday.set(myear,mmonth-1,mday);// D-day�� ��¥�� �Է��մϴ�.
	            long day = dday.getTimeInMillis(); 
	            // ���� ���� �ð� ���� ���� ���� 
	            //( 1���� ��(86400000 = 24�ð� * 60�� * 60�� * 1000(1�ʰ�) ) )
	            long tday = today.getTimeInMillis();
	            long count = (day - tday)/(24*60*60*1000); // ���� ��¥���� dday ��¥�� ���ְ� �˴ϴ�.
	            return (int) count; // ��¥�� �Ϸ� + ��������մϴ�.
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	            return -1;
	        } 
	    }
}
