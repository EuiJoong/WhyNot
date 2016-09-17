package member.model;

import java.util.List;

public interface MemberDAO {
	
	//---- User ---------
	public MemberDBBean getMember(String id);//개인의 모든 정보
	public void insertMember(MemberDBBean dto);//회원가입
	public void deleteMember(String id);//회원정보 삭제
	public void updateMember(MemberDBBean dto,String id);//회원정보 변경
	public boolean idChk(String id);
	//---- 관리자 ---------
	public List<MemberDBBean> listMember(); //모든 회원정보
	public void sanctionsMember(MemberDBBean dto,int mnum);//회원 제재(관리자용)
	
}
