package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MypageController {
	
	@RequestMapping(value="/dashboard.mypage")
	public ModelAndView goMain(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MypageController_goMain() 실행");
		return new ModelAndView("mypage/mypage_dashboard.jsp");

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
}
