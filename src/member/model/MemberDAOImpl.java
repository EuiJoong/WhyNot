package member.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

import member.mybatis.MemberMybatis;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public MemberDBBean getMember(int mnum) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl_getMember()����");
		return MemberMybatis.getMember(mnum);
	}

	@Override
	public void insertMember(MemberDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl_insertMember() ����");
		MemberMybatis.insertMember(dto); 
		System.out.println("����!");
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
		System.out.println("MemberDAOImpl_listMember() ����");
		return MemberMybatis.listMember();
	}

	@Override
	public void sanctionsMember(MemberDBBean dto, int mnum) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean authCHK(HashMap authMap)
	{
		//Enumeration<HashMap> k =  Collections.enumeration(authMap.entrySet());
		Iterator it = authMap.entrySet().iterator();
		
		while(it.hasNext())
		{
			Map.Entry en = (Map.Entry)it.next();
			System.out.println(en.getKey()+"    "+en.getValue());
			System.out.println("!!!");
		}
		System.out.println("MemberDAOImpl_authCHK() ����");
		System.out.println("����!");
		System.out.println("================== ������� �����̴�==================");
		return MemberMybatis.authCHK(authMap);
	}
	
	@Override
	public boolean reAuth(HashMap reAuthMap) {
		// TODO Auto-generated method stub
		return MemberMybatis.reAuth(reAuthMap);
	}

	@Override
	public int idChk(String id) {
		// TODO Auto-generated method stub
		return MemberMybatis.idChk(id);
	}

	@Override
	public void findPassword(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chargeMileage(MemberDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl_chargeMileage() ����");
		MemberMybatis.chargeMileage(dto);
		System.out.println("����!");
	}

	@Override
	public void updateAuth(String id, String auth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tradeMileage(int mnum, int mileage, int seller) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl_tradeMileage() ����");
		HashMap<String, Object> map = new HashMap<>();
		map.put("mnum", mnum);
		map.put("mileage", mileage);
		map.put("seller", seller);
		MemberMybatis.tradeMileage(map);
	}

	@Override
	public MemberDBBean getPasswd(String id) {
		// TODO Auto-generated method stub
		return MemberMybatis.getPasswd(id);
	}

}
