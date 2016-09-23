package login.model;

import java.util.HashMap;

import login.mybatis.LoginMybatis;
import member.model.MemberDBBean;

public class LoginModel {

	public static final int OK = 0;
	public static final int NOT_ID = 1;
	public static final int NOT_PW = 2;
	public static final int NOT_AUTH = 3;
	public static final int ERR = -1;
	
	private MemberDBBean dto;

	public MemberDBBean getDto() {
		return dto;
	}

	public void setDto(MemberDBBean dto) {
		this.dto = dto;
	}

	public HashMap<Object, MemberDBBean> loginChk() {
		System.out.println("LoginModel_loginChk() ����");
		MemberDBBean resDTO = LoginMybatis.chkLogin(dto);// LoginMybatis �̵�
		HashMap<Object, MemberDBBean> res = new HashMap<>();
		if (resDTO != null) {
			if (dto.getPassword().equals(resDTO.getPassword())) {
				if(resDTO.getAuth().equals("ok"))
				{
					res.put(OK, resDTO);
					return res;
				}
				else
				{
					res.put(NOT_AUTH, resDTO);
					return res;
				}
			} else {
				res.put(NOT_PW, null);
				return res;
			}
		} else {
			res.put(NOT_ID, null);
			return res;
		}
	}
	
	public MemberDBBean reLogin(int mnum){
		System.out.println("LoginModel_reLogin() ����");
		MemberDBBean resDTO = LoginMybatis.reLogin(mnum);
		
		return resDTO;
		
	}
}
