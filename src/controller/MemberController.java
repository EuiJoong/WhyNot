package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;
import login.model.LoginModel;
import member.auth.Gmail;
import member.auth.Gmail1;
import member.auth.TokenKeyMake;
import member.model.MemberDAO;
import member.model.MemberDBBean;
import mypage.model.MypageDAO;
import mypage.model.ProfimageDBBean;
import onlinecontent.model.OnlineContentDAO;

@Controller
public class MemberController {

	private MemberDAO memberDAO;
	private LoginModel loginModel;
	private CategoryDAO categoryDAO;
	private OnlineContentDAO onlineContentDAO;
	private MypageDAO mypageDAO;
	
	
	public void setMypageDAO(MypageDAO mypageDAO) {
		this.mypageDAO = mypageDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public void setOnlineContentDAO(OnlineContentDAO onlineContentDAO) {
		this.onlineContentDAO = onlineContentDAO;
	}

	// --------------- 사용자 ---------------------------
	@RequestMapping(value = "/insert.member")
	public ModelAndView insertFormMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_insertFormMember() 실행");

		ModelAndView mav = new ModelAndView();
		
		String id = arg0.getParameter("id");
		
		if(id!=null)mav.addObject("id",id);
			
		CategoryDBBean dto = new CategoryDBBean();
		/* categoryDAO.listCategory(); */
		List<CategoryDBBean> list = CategoryMybatis.listCategory();
		


		mav.setViewName("member/insertMemberForm.jsp");
		mav.addObject("cateList",list);
		
		return mav;

	}

	@RequestMapping(value = "/insertPro.member")
	public ModelAndView insertProMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_insertProMember() 실행");

		String id = arg0.getParameter("id");
		String tokenKey = new TokenKeyMake().make();

		MemberDBBean dto = new MemberDBBean();
		dto.setId(arg0.getParameter("id"));
		dto.setPassword(arg0.getParameter("password"));
		dto.setName(arg0.getParameter("name"));
		dto.setGender(arg0.getParameter("gender"));
		dto.setBirth(arg0.getParameter("birth"));
		dto.setInterest(arg0.getParameter("interest"));
		dto.setAuth(tokenKey);
		memberDAO.insertMember(dto);
		Gmail.sendMail(id, tokenKey);
		return new ModelAndView("auth/authenticating.jsp");
	}

	@RequestMapping(value = "/authOk.member")
	public ModelAndView authOK(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_authOK() 실행");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("auth/authenticating.jsp");
		String id = arg0.getParameter("id");
		String auth = arg0.getParameter("auth");
		System.out.println(auth);
		System.out.println(id);
		// db안에 인증번호와 받아온 인증번호가 일치할 경우 db auth를 ok로 업데이트 하면서 index.jsp
		HashMap authMap = new HashMap<>();
		authMap.put("id", id);
		authMap.put("auth", auth);
		boolean res = memberDAO.authCHK(authMap);
		if (res == true) {
			return new ModelAndView("auth/authenticateOK.jsp");
		} else { // 다를경우 재발송하면서 authentication.jsp
			Gmail.sendMail(id, auth);
			mav.addObject("id", id);
			return mav;
		}
	}

	// 인증이 성공하였을 경우 간단한 알림 메시지 이후 인덱스로 이동
	@RequestMapping(value = "/goIndex.member")
	public ModelAndView goIndex(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return new ModelAndView("main.app");
	}

	// 로그인
	@RequestMapping(value = "/login.member")
	public ModelAndView loginMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_loginMember()실행");
		ModelAndView mav = new ModelAndView();
		
		String saveId = arg0.getParameter("saveId");
		
		MemberDBBean dto = new MemberDBBean();
		dto.setId(arg0.getParameter("id"));
		dto.setPassword(arg0.getParameter("password"));
		loginModel.setDto(dto);
		
		HashMap<Object, MemberDBBean> resMap = loginModel.loginChk();
		
		// 맵을 분석??
		Set<Map.Entry<Object, MemberDBBean>> entries = resMap.entrySet();
		// set 를 iterator 변환
		Iterator<Entry<Object, MemberDBBean>> i = entries.iterator();
		// iterator 값을 콘솔에 출력한다.
		Object key = null;
		MemberDBBean resDTO = null;
		while (i.hasNext()) {
			// 키값은 로그인 결과갑 , 벨류값은 memberDTO
			Entry<Object, MemberDBBean> entry = i.next();
			key = entry.getKey();
			resDTO = entry.getValue();

		}

		String url = ""; // 다음 주소 값
		switch ((int) key) {
		case LoginModel.OK:
			System.out.println("로그인 성공");
			
			ProfimageDBBean proDto = mypageDAO.getPhoto(resDTO.getMnum());
			
			/*resDTO.getMnum()*/
			// 추천 강좌 db
			List recommandList = onlineContentDAO.recommendContent(resDTO.getMnum()); // 추천
			System.out.println("추천 갯수" + recommandList.size());
			System.out.println(recommandList);
			mav.addObject("recommandList", recommandList);
			
			/*// 카테고리 목록
			List<CategoryDBBean> catelist = categoryDAO.listCategory();//카테고리 목록 
			mav.addObject("catelist",catelist);*/
			
			// 쿠키
			Cookie ck = new Cookie("saveId", resDTO.getId());
			if (saveId != null) {
				ck.setMaxAge(12 * 60 * 60);
			} else {
				ck.setMaxAge(0);
			}
			arg1.addCookie(ck);
			// memberDTO 세션으로 보내기
			HttpSession session = arg0.getSession();
			session.setAttribute("memberDTO", resDTO);
			session.setAttribute("proDto", proDto);
			session.setMaxInactiveInterval(50000);
			
			url = "index.jsp";
			break;
		case LoginModel.NOT_ID:
			url = "login/faillogin.jsp";
			System.out.println("아이디 틀림");
			break;
		case LoginModel.NOT_PW:
			url = "login/faillogin.jsp";
			System.out.println("비밀번호 틀림");
			break;
		case LoginModel.NOT_AUTH:
			System.out.println("비활성화 계정");
			String id = resDTO.getId();
			String tokenKey = new TokenKeyMake().make();
			resDTO.setAuth(tokenKey);
			HashMap reAuthMap = new HashMap<>();
			reAuthMap.put("id", id);
			reAuthMap.put("auth", tokenKey);
			memberDAO.reAuth(reAuthMap);
			Gmail.sendMail(id, tokenKey);
			mav.addObject("auth", id);
			url = "auth/authenticating.jsp";
			break;
		case LoginModel.ERR:
			System.out.println("DB오류");
			break;

		default:
			break;
		}
		mav.setViewName(url);
		return mav;
	}

	// 로그아웃
	@RequestMapping(value = "/logout.member")
	public ModelAndView logoutMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		session.invalidate();
		return new ModelAndView("index.jsp");
	}

	// ----------------- 관리자 용 ----------------------------------

	// 회원목록
	@RequestMapping(value = "/list.member")
	public ModelAndView listMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		List<MemberDBBean> list = memberDAO.listMember();
		return new ModelAndView("admin/member/member_listForm.jsp", "memberList", list);
	}

	// 회원 수정(등급)
	@RequestMapping(value = "/grade.member")
	public ModelAndView gradeMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		return new ModelAndView("admin/member/member_gradeForm.jsp");
	}
	
	// 회원 제재
	@RequestMapping(value = "/acstate.member")
	public ModelAndView acStateMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		return new ModelAndView("admin/member/member_gradeForm.jsp");
	}
	//아이디 중복확인
	@RequestMapping(value = "/idChk.member")
	public ModelAndView chkid(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_idChk() 실행");

		return new ModelAndView("member/idChk.jsp");
	}
	@RequestMapping(value = "/end.member")
	public ModelAndView end(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_idChk() 실행");

		return new ModelAndView("member/end_chk.jsp");
	}
	
	@RequestMapping(value = "/idChkpro.member")
	public ModelAndView chkidpor(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_idChkpro() 실행");

		ModelAndView mav = new ModelAndView();
		String url = "";
		String id = arg0.getParameter("id");
		if(memberDAO.idChk(id)!=0){	
			url = "/member/idChk.jsp";
			String msg = "중복";
			mav.addObject("msg",msg);
		}else{
			url = "member/end_chk.jsp";
		}

		mav.setViewName(url);
		mav.addObject("id",id);
		
		return mav;
	}
	
	@RequestMapping(value="/getpasswd.member")
	public ModelAndView getpasswd(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		System.out.println("getpasswd 실행()");
		return new ModelAndView("login/getpasswd.jsp");
	}
	
	
	@RequestMapping(value="/getpasswdpro.member")
	public ModelAndView getpasswd_pro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.println("getpasswd_pro 실행()");
		String url = "";
		String msg = null;
		String id = arg0.getParameter("id");
		
		
		if(memberDAO.idChk(id)!=0){	
			//해ㅐ당하느 아이디 가지고 다시 패스워드 찾아서 비밀번호를 이메일로 전송
			MemberDBBean passwd =   memberDAO.getPasswd(id);
			String getpasswd = passwd.getPassword();
			mav.addObject("getpasswd",getpasswd); 
			
			 url = "login/getpasswd.jsp";
			 Gmail1.sendMail(id, getpasswd);
			 msg = "해당하는 이메일로 비밀번호를 보냈습니다.";
		}else{
			//없는경우 없다고 알려주기
			url = "login/getpasswd.jsp";
			msg = "등록되지 않은 아이디이거나, 아이디 를 잘못 입력하셨습니다.";
		}

		mav.setViewName(url);
		mav.addObject("msg",msg);
		mav.addObject("id",id);
		
		return mav;
		
	}
}
