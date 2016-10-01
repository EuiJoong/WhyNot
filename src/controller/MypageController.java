package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import mypage.model.MypageDAO;
import mypage.model.ProfimageDBBean;

@Controller
public class MypageController {
	
	private MypageDAO mypageDAO;

	public void setMypageDAO(MypageDAO mypageDAO) {
		this.mypageDAO = mypageDAO;
	}

	@RequestMapping(value="/purchase.mypage")
	public ModelAndView goMain(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MypageController_goMain() 실행");
		return new ModelAndView("mypage/mypage_purchase.jsp");

	}
	
	@RequestMapping(value="/profile.mypage")
	public ModelAndView goProfile(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MypageController_goProfile() 실행");
		return new ModelAndView("mypage/mypage_profile.jsp");

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
	public ModelAndView updatePasswd(HttpServletRequest arg0, HttpServletRequest arg1) throws Exception {
		
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
	public ModelAndView profimage(HttpServletRequest arg0, HttpServletRequest arg1) throws Exception {
		
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
		
		mav.setViewName("mypage/mypage_profile.jsp");
		
		return mav;
		
	}
}
