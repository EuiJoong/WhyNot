package controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import login.model.LoginModel;
import member.model.MemberDBBean;
import member.mybatis.MemberMybatis;
import mypage.model.MypageDAO;
import mypage.model.ProfimageDBBean;
import mypage.model.ProfitorDBBean;

@Controller
public class MypageController {
	
	private MypageDAO mypageDAO;
	private LoginModel loginModel;
	
	public void setMypageDAO(MypageDAO mypageDAO) {
		this.mypageDAO = mypageDAO;
	}
	
	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}



	@RequestMapping(value="/purchase.mypage")
	public ModelAndView goMain(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MypageController_goMain() 실행");
		ModelAndView mav = new ModelAndView();
		System.out.println(arg0.getParameter("mnum"));
		
		List<Object> onContList = mypageDAO.getPurchaseOncont(Integer.parseInt(arg0.getParameter("mnum")));
		System.out.println("구매갯수: " + onContList.size());
		
		mav.addObject("onContList",onContList);
		mav.setViewName("mypage/mypage_purchase.jsp");
		return mav;
	}
	
	@RequestMapping(value="/sale.mypage")
	public ModelAndView goSale(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MypageController_goSale() 실행");
		ModelAndView mav = new ModelAndView();
		System.out.println(arg0.getParameter("mnum"));
		
		List<Object> onContList = mypageDAO.getSaleOncont(Integer.parseInt(arg0.getParameter("mnum")));
		System.out.println("올린갯수: " + onContList.size());
		
		mav.addObject("onContList",onContList);
		mav.setViewName("mypage/mypage_sale.jsp");
		return mav;
	}
	
	
	@RequestMapping(value="/profile.mypage")
	public ModelAndView goProfile(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> map = new HashMap<>();
		
		System.out.println("MypageController - goProfile() [1]");
		
		System.out.println(arg0.getParameter("mnum"));
		System.out.println(arg0.getAttribute("mnum"));
		
		System.out.println("MypageController - goProfile() [2]");
		
		HttpSession session = arg0.getSession();
		System.out.println(arg0.getAttribute("mnum"));
		System.out.println(arg0.getAttribute("memberDTO.mnum"));
		System.out.println(session.getAttribute("mnum"));		
		
		System.out.println("MypageController - goProfile() [3]");
		
		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		
		System.out.println("MypageController - goProfile() [4]");
		
		map = mypageDAO.loadProfile(mnum);		
		
		System.out.println("MypageController - goProfile() [5]");
		
		
		System.out.println("MypageController - goProfile() [6]");
		
//		ProfitorDBBean pi = (ProfitorDBBean)map.get("peList");
		
		//////////////////////////////////////
		
		
		
//		mav.addObject(map);
		mav.addAllObjects(map);
		mav.setViewName("mypage/mypage_profile.jsp");
				
		return mav;

	}
	
	@RequestMapping(value="/setting.mypage")
	public ModelAndView goSetting(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MypageController_goSetting() 실행");
		return new ModelAndView("mypage/mypage_setting.jsp");

	}
	
	@RequestMapping(value="/validPasswd.mypage")
	public ModelAndView validPasswd(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("MypageController_validPasswd() 실행");
		
		System.out.println(Integer.parseInt(arg0.getParameter("mnum")));
		
		boolean booleana = false;
		
		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		String pswd = arg0.getParameter("pswd");
		
		System.out.println("M_Num : " + mnum + " / pswd : " + pswd);
		
		booleana = mypageDAO.validPasswd(mnum, pswd);
		
		System.out.println("[MypageController.java] 최종적으로 여기 논리형 자료값은 뭘까욥? " + booleana);
		
		
//		return new ModelAndView("mypage/mypage_setting.jsp");
		
		mav.addObject("visitedPw", true);
		mav.addObject("validPw", booleana);
		mav.setViewName("mypage/mypage_setting.jsp");
		
		
		return mav;
	}
	
	@RequestMapping(value="/updatePasswd.mypage")
	public ModelAndView updatePasswd(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("MypageController_updatePasswd() 실행");
		
		System.out.println(arg0.getParameter("mnum"));
		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		
		String updatePw = arg0.getParameter("updatePw");
		
		System.out.println("여기서 일단 들어온 값 확인 : " + mnum + "/" + updatePw);
		
		mypageDAO.updatePasswd(mnum, updatePw);
		
		mav.setViewName("mypage/mypage_setting.jsp");
		
		return mav;
		 
	}
	
	@RequestMapping(value="/profimage_merge.mypage")
	public ModelAndView profimage(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		System.out.println("controller/MypageController.java - profimage [1]");
		
		ModelAndView mav = new ModelAndView();
		
		ProfimageDBBean pi = new ProfimageDBBean();
		
		String dir = arg0.getServletContext().getRealPath("images");
		
		System.out.println("controller/MypageController.java - profimage [2]");
		
		MultipartRequest mr = null;
			
		System.out.println(dir);
		
		try {
			
			System.out.println("controller/MypageController.java - profimage [3]");
			
			mr = new MultipartRequest(arg0, dir, 1024*1024*10, "UTF-8");
			
			System.out.println(mr.getParameter("mnum"));
			
			System.out.println("controller/MypageController.java - profimage [4]");
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("controller/MypageController.java - profimage - catch");
		}
		
		System.out.println("controller/MypageController.java - profimage [5]");
		
		pi.setMnum(Integer.parseInt(mr.getParameter("mnum")));
		pi.setImgname(mr.getFilesystemName("profimage"));
		pi.setImgdir(dir);
		
		System.out.println("controller/MypageController.java - profimage [6]");
		
		mypageDAO.profimageMerge(pi);
		
		
		
		
		HttpSession session = arg0.getSession();
		session.invalidate();
		
		String mnum = mr.getParameter("mnum");
		System.out.println("dd" + mnum);
		
		
		mav.addObject("mnum",mnum);
		mav.setViewName("mypage/re_session.jsp");
	
		
		return mav;
		
	}
	
	@RequestMapping(value="/profitor.mypage")
	public ModelAndView profitor(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		System.out.println("controller/MypageController.java - profitor [1]");
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("controller/MypageController.java - profitor [2]");
		
		String content = arg0.getParameter("content");
		System.out.println(content);
		
		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		
		System.out.println("controller/MypageController.java - profitor [3]");
		
		mypageDAO.profitor(mnum, content);
		
		System.out.println("controller/MypageController.java - profitor [4]");
		
		System.out.println("controller/MypageController.java - profitor [5]");
		
		
		
		
		mav.setViewName("profile.mypage");
		
		System.out.println("controller/MypageController.java - profitor [6]");
		
		return mav;
	}
	
	@RequestMapping(value="/session.mypage")
	public ModelAndView reSession(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MypageController_reSession()실행");
		ModelAndView mav = new ModelAndView();
		System.out.println("reSession"+arg0.getParameter("mnum"));
		int mnum = Integer.parseInt(arg0.getParameter("mnum"));
		System.out.println(mnum);
		MemberDBBean resDTO = loginModel.reLogin(mnum);
		ProfimageDBBean proDTO = mypageDAO.getPhoto(mnum);
		
		HttpSession session = arg0.getSession();
		session.setAttribute("memberDTO", resDTO);
		session.setAttribute("proDto", proDTO);
		session.setMaxInactiveInterval(50000);
		mav.setViewName("profile.mypage");
		return mav;
		
	}
}
