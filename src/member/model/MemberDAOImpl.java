package member.model;

import java.util.List;

import member.mybatis.MemberMybatis;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public MemberDBBean getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(MemberDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl_insertMember() 실행");
		MemberMybatis.insertMember(dto); 
		System.out.println("성공!");
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(MemberDBBean dto, String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MemberDBBean> listMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sanctionsMember(MemberDBBean dto, int mnum) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean idChk(String id) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}

}
