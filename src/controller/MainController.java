package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value="/main.app")
	public ModelAndView goMain(){//user메인 페이지 이동
		System.out.println("MainController_ goMain() 실행");
		return new ModelAndView("index.jsp");
	}
	
	@RequestMapping(value="/adminMain.app")
	public ModelAndView goAdminMain(){//admin메인 페이지 이동
		System.out.println("MainController_goAdminMain() 실행");
		return new ModelAndView("admin/adminMain.jsp");
	}
	
}
