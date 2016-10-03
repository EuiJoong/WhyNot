package mypage.model;

import java.util.HashMap;
import java.util.List;

import mypage.mybatis.MypageMybatis;

public class MypageDAOImpl implements MypageDAO {
	
	@Override
	public boolean validPasswd(int mnum, String pswd) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> map = new HashMap<>();
		
		boolean booleana = false;
		
		map.put("mnum", mnum);
		map.put("pswd", pswd);
		
		booleana = MypageMybatis.validPassword(map);
		
		System.out.println("[MypageDAOImp] ���� ������ �����~~?? " + booleana);
		
		return booleana;
	}
	
	@Override
	public int updatePasswd(int mnum, String updatePw) {
		// TODO Auto-generated method stub
		
		System.out.println("updatePasswd DAO Ȯ��1");
		
		HashMap<String, Object> map = new HashMap<>();
		
		System.out.println("updatePasswd DAO Ȯ��2");
		
		map.put("mnum",  mnum);
		
		System.out.println("updatePasswd DAO Ȯ��3");
		map.put("updatePw", updatePw);
		
		System.out.println("updatePasswd DAO Ȯ��4");
		
		MypageMybatis.updatePassword(map);
		
		System.out.println("updatePasswd DAO Ȯ��5");
		
		return 0;
	}
	
	@Override
	public int profimageMerge(ProfimageDBBean pi) {
		// TODO Auto-generated method stub
		
		
				
		
		System.out.println("mypage.model/MypageDAOImpl.java - profimageMerge : 1");
		
		MypageMybatis.profimageMerge(pi);
		
		System.out.println("mypage.model/MypageDAOImpl.java - profimageMerge : 2");
		
		
		System.out.println("mypage.model/MypageDAOImpl.java - profimageMerge : 3");
		
		
		System.out.println("mypage.model/MypageDAOImpl.java - profimageMerge : 4");
		
		
		
		return 0;
	}
	
	@Override
	public int profitor(int mnum, String content) {
		// TODO Auto-generated method stub
		
		System.out.println("mypage.model/MypageDAOImpl.java - profitor : 1");
		
		MypageMybatis.profitor(mnum, content);
		
		System.out.println("mypage.model/MypageDAOImpl.java - profitor : 2");
		
		System.out.println("mypage.model/MypageDAOImpl.java - profitor : 3");
		
		System.out.println("mypage.model/MypageDAOImpl.java - profitor : 4");
		
		return 0;
	}
	
	@Override
	public HashMap<String, Object> loadProfile(int mnum) {
		// TODO Auto-generated method stub

		System.out.println("mypage.model/MypageDAOImpl - loadProfile [1]");
		System.out.println("mypage.model/MypageDAOImpl - loadProfile [2]");
		System.out.println("mypage.model/MypageDAOImpl - loadProfile [3]");
		
		HashMap<String, Object> map = new HashMap<>();
				
		map = MypageMybatis.loadProfile(mnum);		

		System.out.println("mypage.model/MypageDAOImpl - loadProfile [4]");
		System.out.println("mypage.model/MypageDAOImpl - loadProfile [5]");
		System.out.println("mypage.model/MypageDAOImpl - loadProfile [6]");
		
		
		return map;
	}

	@Override
	public ProfimageDBBean getPhoto(int mnum) {
		// TODO Auto-generated method stub
		System.out.println("MypageDAOImpl_getPhoto() ����");
		return MypageMybatis.getPhoto(mnum);
	}

	@Override
	public List getPurchaseOncont(int mnum) {
		// TODO Auto-generated method stub
		System.out.println("MypageDAOImpl_getPurchaseOncont() ����");
		return MypageMybatis.getPurchaseOncont(mnum);
	}

	@Override
	public List getSaleOncont(int mnum) {
		// TODO Auto-generated method stub
		System.out.println("MypageDAOImpl_getSaleOncont() ����");
		return MypageMybatis.getSaleOncont(mnum);
	}

	@Override
	public ProfitorDBBean getProfile(int mnum) {
		// TODO Auto-generated method stub
		System.out.println("MypageDAOImpl_getProfile() ����");
		return MypageMybatis.getProfile(mnum);
	}
}
