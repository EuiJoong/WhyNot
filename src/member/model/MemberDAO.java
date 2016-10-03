package member.model;

import java.util.HashMap;
import java.util.List;

public interface MemberDAO {
	
	//---- User ---------
	public MemberDBBean getMember(int mnum);//개인의 모든 정보
	public void insertMember(MemberDBBean dto);//회원가입
	public void deleteMember(String id);//회원정보 삭제
	public void updateMember(MemberDBBean dto,String id);//회원정보 변경
	public int idChk(String id);
	public boolean authCHK(HashMap authMap);
	public boolean reAuth(HashMap reAuthMap);
	public void findPassword(String id);
	public void chargeMileage(MemberDBBean dto);
	public void tradeMileage(int mnum, int mileage , int seller);
	public MemberDBBean  getPasswd(String id);
	//---- 관리자 ---------
	public List<MemberDBBean> listMember(); //모든 회원정보
	public void sanctionsMember(MemberDBBean dto,int mnum);//회원 제재(관리자용)
	public void updateAuth(String id,String auth); //인증 확안
	
}
