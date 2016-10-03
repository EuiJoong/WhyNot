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

	// --------------- ����� ---------------------------
	@RequestMapping(value = "/insert.member")
	public ModelAndView insertFormMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_insertFormMember() ����");

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
		System.out.println("MemberController_insertProMember() ����");

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
		System.out.println("MemberController_authOK() ����");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("auth/authenticating.jsp");
		String id = arg0.getParameter("id");
		String auth = arg0.getParameter("auth");
		System.out.println(auth);
		System.out.println(id);
		// db�ȿ� ������ȣ�� �޾ƿ� ������ȣ�� ��ġ�� ��� db auth�� ok�� ������Ʈ �ϸ鼭 index.jsp
		HashMap authMap = new HashMap<>();
		authMap.put("id", id);
		authMap.put("auth", auth);
		boolean res = memberDAO.authCHK(authMap);
		if (res == true) {
			return new ModelAndView("auth/authenticateOK.jsp");
		} else { // �ٸ���� ��߼��ϸ鼭 authentication.jsp
			Gmail.sendMail(id, auth);
			mav.addObject("id", id);
			return mav;
		}
	}

	// ������ �����Ͽ��� ��� ������ �˸� �޽��� ���� �ε����� �̵�
	@RequestMapping(value = "/goIndex.member")
	public ModelAndView goIndex(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return new ModelAndView("main.app");
	}

	// �α���
	@RequestMapping(value = "/login.member")
	public ModelAndView loginMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_loginMember()����");
		ModelAndView mav = new ModelAndView();
		
		String saveId = arg0.getParameter("saveId");
		
		MemberDBBean dto = new MemberDBBean();
		dto.setId(arg0.getParameter("id"));
		dto.setPassword(arg0.getParameter("password"));
		loginModel.setDto(dto);
		
		HashMap<Object, MemberDBBean> resMap = loginModel.loginChk();
		
		// ���� �м�??
		Set<Map.Entry<Object, MemberDBBean>> entries = resMap.entrySet();
		// set �� iterator ��ȯ
		Iterator<Entry<Object, MemberDBBean>> i = entries.iterator();
		// iterator ���� �ֿܼ� ����Ѵ�.
		Object key = null;
		MemberDBBean resDTO = null;
		while (i.hasNext()) {
			// Ű���� �α��� ����� , �������� memberDTO
			Entry<Object, MemberDBBean> entry = i.next();
			key = entry.getKey();
			resDTO = entry.getValue();

		}

		String url = ""; // ���� �ּ� ��
		switch ((int) key) {
		case LoginModel.OK:
			System.out.println("�α��� ����");
			
			ProfimageDBBean proDto = mypageDAO.getPhoto(resDTO.getMnum());
			
			/*resDTO.getMnum()*/
			// ��õ ���� db
			List recommandList = onlineContentDAO.recommendContent(resDTO.getMnum()); // ��õ
			System.out.println("��õ ����" + recommandList.size());
			System.out.println(recommandList);
			mav.addObject("recommandList", recommandList);
			
			/*// ī�װ� ���
			List<CategoryDBBean> catelist = categoryDAO.listCategory();//ī�װ� ��� 
			mav.addObject("catelist",catelist);*/
			
			// ��Ű
			Cookie ck = new Cookie("saveId", resDTO.getId());
			if (saveId != null) {
				ck.setMaxAge(12 * 60 * 60);
			} else {
				ck.setMaxAge(0);
			}
			arg1.addCookie(ck);
			// memberDTO �������� ������
			HttpSession session = arg0.getSession();
			session.setAttribute("memberDTO", resDTO);
			session.setAttribute("proDto", proDto);
			session.setMaxInactiveInterval(50000);
			
			url = "index.jsp";
			break;
		case LoginModel.NOT_ID:
			url = "login/faillogin.jsp";
			System.out.println("���̵� Ʋ��");
			break;
		case LoginModel.NOT_PW:
			url = "login/faillogin.jsp";
			System.out.println("��й�ȣ Ʋ��");
			break;
		case LoginModel.NOT_AUTH:
			System.out.println("��Ȱ��ȭ ����");
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
			System.out.println("DB����");
			break;

		default:
			break;
		}
		mav.setViewName(url);
		return mav;
	}

	// �α׾ƿ�
	@RequestMapping(value = "/logout.member")
	public ModelAndView logoutMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		session.invalidate();
		return new ModelAndView("index.jsp");
	}

	// ----------------- ������ �� ----------------------------------

	// ȸ�����
	@RequestMapping(value = "/list.member")
	public ModelAndView listMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		List<MemberDBBean> list = memberDAO.listMember();
		return new ModelAndView("admin/member/member_listForm.jsp", "memberList", list);
	}

	// ȸ�� ����(���)
	@RequestMapping(value = "/grade.member")
	public ModelAndView gradeMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		return new ModelAndView("admin/member/member_gradeForm.jsp");
	}
	
	// ȸ�� ����
	@RequestMapping(value = "/acstate.member")
	public ModelAndView acStateMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		return new ModelAndView("admin/member/member_gradeForm.jsp");
	}
	//���̵� �ߺ�Ȯ��
	@RequestMapping(value = "/idChk.member")
	public ModelAndView chkid(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_idChk() ����");

		return new ModelAndView("member/idChk.jsp");
	}
	@RequestMapping(value = "/end.member")
	public ModelAndView end(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_idChk() ����");

		return new ModelAndView("member/end_chk.jsp");
	}
	
	@RequestMapping(value = "/idChkpro.member")
	public ModelAndView chkidpor(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_idChkpro() ����");

		ModelAndView mav = new ModelAndView();
		String url = "";
		String id = arg0.getParameter("id");
		if(memberDAO.idChk(id)!=0){	
			url = "/member/idChk.jsp";
			String msg = "�ߺ�";
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

		System.out.println("getpasswd ����()");
		return new ModelAndView("login/getpasswd.jsp");
	}
	
	
	@RequestMapping(value="/getpasswdpro.member")
	public ModelAndView getpasswd_pro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.println("getpasswd_pro ����()");
		String url = "";
		String msg = null;
		String id = arg0.getParameter("id");
		
		
		if(memberDAO.idChk(id)!=0){	
			//�ؤ����ϴ� ���̵� ������ �ٽ� �н����� ã�Ƽ� ��й�ȣ�� �̸��Ϸ� ����
			MemberDBBean passwd =   memberDAO.getPasswd(id);
			String getpasswd = passwd.getPassword();
			mav.addObject("getpasswd",getpasswd); 
			
			 url = "login/getpasswd.jsp";
			 Gmail1.sendMail(id, getpasswd);
			 msg = "�ش��ϴ� �̸��Ϸ� ��й�ȣ�� ���½��ϴ�.";
		}else{
			//���°�� ���ٰ� �˷��ֱ�
			url = "login/getpasswd.jsp";
			msg = "��ϵ��� ���� ���̵��̰ų�, ���̵� �� �߸� �Է��ϼ̽��ϴ�.";
		}

		mav.setViewName(url);
		mav.addObject("msg",msg);
		mav.addObject("id",id);
		
		return mav;
		
	}
}
