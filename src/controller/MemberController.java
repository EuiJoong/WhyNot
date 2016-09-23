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
import member.model.MemberDAO;
import member.model.MemberDBBean;
import onlinecontent.model.OnlineContentDAO;

@Controller
public class MemberController {

	private MemberDAO memberDAO;
	private LoginModel loginModel;
	private CategoryDAO categoryDAO;
	private OnlineContentDAO onlineContentDAO;
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
		
		CategoryDBBean dto = new CategoryDBBean();
		/*categoryDAO.listCategory();*/
		List<CategoryDBBean> list = CategoryMybatis.listCategory();
		return new ModelAndView("member/insertMemberForm.jsp","cateList",list);

	}

	@RequestMapping(value = "/insertPro.member")
	public ModelAndView insertProMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_insertProMember() ����");
		System.out.println(arg0.getParameter("interest"));
		/*
		 * arg0.setCharacterEncoding("UTF-8");
		 * arg1.setCharacterEncoding("UTF-8");
		 */

		MemberDBBean dto = new MemberDBBean();
		dto.setId(arg0.getParameter("id"));
		dto.setPassword(arg0.getParameter("password"));
		dto.setName(arg0.getParameter("name"));
		dto.setGender(arg0.getParameter("gender"));
		dto.setBirth(arg0.getParameter("birth"));
		dto.setInterest(arg0.getParameter("interest"));
		memberDAO.insertMember(dto);
		return new ModelAndView("index.jsp");
	}
	//�α���
	@RequestMapping(value = "/login.member")
	public ModelAndView loginMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		String saveId = arg0.getParameter("saveId");
		
		MemberDBBean dto = new MemberDBBean();
		dto.setId(arg0.getParameter("id"));
		dto.setPassword(arg0.getParameter("password"));
		loginModel.setDto(dto);
		
		HashMap<Object, MemberDBBean> resMap = loginModel.loginChk();
		
		//���� �м�??
		Set<Map.Entry<Object, MemberDBBean>> entries = resMap.entrySet();
		// set �� iterator ��ȯ
		Iterator<Entry<Object, MemberDBBean>> i = entries.iterator();
		// iterator ���� �ֿܼ� ����Ѵ�.
		Object key = null;
		MemberDBBean resDTO = null;
		while (i.hasNext()) {
			//Ű���� �α��� ����� , �������� memberDTO
			Entry<Object, MemberDBBean> entry = i.next();
			key = entry.getKey();
			resDTO = entry.getValue();

		}
		ModelAndView mav = new ModelAndView();
		
		String url = ""; //���� �ּ� ��
		switch ((int)key) {
		case LoginModel.OK:
			System.out.println("�α��� ����");
			List recommandList = onlineContentDAO.recommendContent(resDTO.getMnum()); //��õ ���� db
			System.out.println("��õ ����" + recommandList.size());
			System.out.println(recommandList);
			mav.addObject("recommandList",recommandList);
			//��Ű
			Cookie ck  = new Cookie("saveId",resDTO.getId());
			if(saveId != null){
				ck.setMaxAge(12*60*60);
			}else{
				ck.setMaxAge(0);
			}
			arg1.addCookie(ck);
			
			//memberDTO �������� ������
			HttpSession session = arg0.getSession();
			session.setAttribute("memberDTO", resDTO);
			
			mav.setViewName("main.app");
			break;
		case LoginModel.NOT_ID:
			System.out.println("���̵� Ʋ��");
			break;
		case LoginModel.NOT_PW:
			System.out.println("��й�ȣ Ʋ��");
			break;
		case LoginModel.ERR:
			System.out.println("DB����");
			break;

		default:
			break;
		}

		return mav;
	}
	//�α׾ƿ�
	@RequestMapping(value="/logout.member")
	public ModelAndView logoutMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		session.invalidate();
		return new ModelAndView("index.jsp");
	}
	
	//----------------- ������ �� ----------------------------------
	
	//ȸ�����
	@RequestMapping(value="/list.member")
	public ModelAndView listMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		List<MemberDBBean> list = memberDAO.listMember();
		return new ModelAndView("admin/member/member_listForm.jsp","memberList",list);
	}
	
	//ȸ�� ����(���)
	@RequestMapping(value="/grade.member")
	public ModelAndView gradeMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		return new ModelAndView("admin/member/member_gradeForm.jsp");
	}
	
	//ȸ�� ����
	@RequestMapping(value="/acstate.member")
	public ModelAndView acStateMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		return new ModelAndView("admin/member/member_gradeForm.jsp");
	}
	
}
