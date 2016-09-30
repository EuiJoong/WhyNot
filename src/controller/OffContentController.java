package controller;

import java.io.IOException;
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

import attachfile.model.PhotoDBBean;
import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;
import offlinecontent.model.ClassRoomDBBean; 
import offlinecontent.model.OfflineContentDAO;
import offlinecontent.model.OfflineContentDBBean;
import offlinecontent.model.ReserveDateDBBean;
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
	
	// -------------- 오프라인 컨텐츠 -----------------------------------
    @RequestMapping(value = "/offcont_insertForm.offcont") // 실강등록Form
    public ModelAndView insertFormOffContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertFormOffContent() 실행");
		Iterator<String> it = arg0.getParameterMap().keySet().iterator();
		while(it.hasNext()){
			System.out.println("parameter key값 : "+it.next());
		}
		System.out.println("addr : "+arg0.getParameter("addr"));
		System.out.println("reserve_date : "+arg0.getParameter("reserve_date"));
		System.out.println("time : "+arg0.getParameter("time"));
		System.out.println("crnum : "+arg0.getParameter("cr_num"));
		List<CategoryDBBean> list = categoryDAO.listCategory();
		return new ModelAndView("content/offline/cont_insertForm.jsp", "cateList", list);

    }
    
    @RequestMapping(value = "/offcont_insertPro.offcont") // 실강등록Pro
    public ModelAndView insertProOffContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ContentController_insertProOffContent() 실행");
		
		MultipartRequest mr = null;
		String upPath = arg0.getServletContext().getRealPath("images");
		try{
			mr = new MultipartRequest(arg0, upPath, 10*1024*1024,"UTF-8"); 
		}catch(IOException e){}
		OfflineContentDBBean offDTO = new OfflineContentDBBean();
		offDTO.setCtnum(Integer.parseInt(mr.getParameter("ctnum")));
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
		rdateDTO.setCl_reserve_stats("예약완료");
		////////////////////////////////////////////////////////////////////////////
		PhotoDBBean ptDTO = new PhotoDBBean();
		ptDTO.setMnum(Integer.parseInt(mr.getParameter("mnum")));
		String fileName = mr.getFilesystemName("image-file");
		String randomName = System.currentTimeMillis() + (int)Math.random()*10000 +"_";
		ptDTO.setFilename(randomName+fileName.substring(0,fileName.indexOf(".")));
		ptDTO.setFileext(fileName.substring(fileName.lastIndexOf(".")+1));
		ptDTO.setFiledir(upPath);
		////////////////////////////////////////////////////////////////////////////
		System.out.println("addr : "+mr.getParameter("addr"));
		System.out.println("reserve_date : "+mr.getParameter("reserve_date"));
		System.out.println("time : "+mr.getParameter("time"));
		System.out.println("crnum : "+mr.getParameter("cr_num"));
		boolean res = offlineContentDAO.insertContent(offDTO, crDTO, rdateDTO, ptDTO);
		
		
		if(res) return new ModelAndView("main.app");
		else {
			List<CategoryDBBean> list = categoryDAO.listCategory();
			Map map = new HashMap();
				map.put("cateList", list);
				map.put("res", "실패");
			return new ModelAndView("content/offline/cont_insertForm.jsp", map);
		}
		
    }
	
	@RequestMapping(value = "/classroom_reserve.offcont") // 강의실 대여
	public ModelAndView reserveClassroom(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("OffContentController_reserveClassroom() 실행");
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
		List list = offlineContentDAO.listClassRoom();	// 강의장 DTO List
		Set<String> set = new TreeSet<>();	// 강의장 주소 중복안되게 set으로..
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
}
