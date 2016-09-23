package member.model;

import java.util.List;

import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

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
		System.out.println("MemberDAOImpl_listMember() 실행");
		return MemberMybatis.listMember();
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

	@Override
	public void findPassword(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chargeMileage(int mnum, int mileage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAuth(String id, String auth) {
		// TODO Auto-generated method stub
		
	}

}
