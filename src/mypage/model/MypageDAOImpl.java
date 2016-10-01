package mypage.model;

import java.util.HashMap;

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
		
		System.out.println("[MypageDAOImp] 여기 논리값을 뭘까요~~?? " + booleana);
		
		return booleana;
	}
	
	@Override
	public int updatePasswd(int mnum, String updatePw) {
		// TODO Auto-generated method stub
		
		System.out.println("updatePasswd DAO 확인1");
		
		HashMap<String, Object> map = new HashMap<>();
		
		System.out.println("updatePasswd DAO 확인2");
		
		map.put("mnum",  mnum);
		
		System.out.println("updatePasswd DAO 확인3");
		map.put("updatePw", updatePw);
		
		System.out.println("updatePasswd DAO 확인4");
		
		MypageMybatis.updatePassword(map);
		
		System.out.println("updatePasswd DAO 확인5");
		
		return 0;
	}
	
	@Override
	public int profimageMerge(ProfimageDBBean pi) {
		// TODO Auto-generated method stub
		
		MypageMybatis.profimageMerge(pi);
				
		
		System.out.println("mypage.model/MypageDAOImpl.java : 1");
		
		
		System.out.println("mypage.model/MypageDAOImpl.java : 2");
		
		
		System.out.println("mypage.model/MypageDAOImpl.java : 3");
		
		
		System.out.println("mypage.model/MypageDAOImpl.java : 4");
		
		
		
		return 0;
	}
}
