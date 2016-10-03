package mypage.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import mypage.model.ProfimageDBBean;
import mypage.model.ProfitorDBBean;

public class MypageMybatis {
	
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = 위치 지정
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			// 1.SqlMapConfig.xml
			// 들어오는 값을 지정 시켜줌
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// 마이바티스로 바뀌면서 세션타입으로 처리를 해주게 됌
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

	public static boolean validPassword(HashMap<String, Object> map) {
		
		SqlSession session = sqlMapper.openSession();
		
		Boolean booleana = null;
		
		int res = session.selectOne("validPassword", map);
		
		System.out.println("[MypageMybatis.java] DB에서 뭐가 나왔을까요?? " + res);
		
		if(res>0) {
			booleana = true;
		}else{
			booleana = false;
		}	
		
		System.out.println("[MypageMybatis.java] 논리 결과값은 무엇일까요?? " + booleana);
		
		
		
		return booleana;		
	}
	
	public static int updatePassword(HashMap<String, Object> map) {
		
		System.out.println("updatePassword 확인1");
		
		SqlSession session = sqlMapper.openSession();
		
		System.out.println("updatePassword 확인2");
		
		int res = session.update("updatePassword", map);

		System.out.println("updatePassword 확인3");
		
		session.commit();
		session.close();
		
		System.out.println("updatePassword 확인4");
		
		return 0;		
	}
	
	public static int profimageMerge(ProfimageDBBean pi) {
		
		System.out.println("mypage.mybatis/MypageMybatis.java 1");
		
		SqlSession session = sqlMapper.openSession();
		
		System.out.println("mypage.mybatis/MypageMybatis.java 2");
		
		int res = session.insert("profimage", pi);
		
		System.out.println("mypage.mybatis/MypageMybatis.java 3");
		
		session.commit();
		session.close();
				
		System.out.println("mypage.mybatis/MypageMybatis.java 4");
		
		return 0;		
	}
	
	public static int profitor(int mnum, String content) {
		
		System.out.println("mypage.mybatis/MypageMybatis.java - profitor [1]");
		
		SqlSession session = sqlMapper.openSession();
		
		System.out.println("mypage.mybatis/MypageMybatis.java - profitor [2]");
		
//		HashMap<String, Object> map = new HashMap<>();
		ProfitorDBBean pe = new ProfitorDBBean();
		
		System.out.println("mypage.mybatis/MypageMybatis.java - profitor [3]");
		
		pe.setMnum(mnum);
		pe.setContent(content);
		
		System.out.println("mypage.mybatis/MypageMybatis.java - profitor [4]");
		
		int res = session.insert("profitor", pe);
		
		System.out.println("mypage.mybatis/MypageMybatis.java - profitor [5]");
		
		session.commit();
		session.close();
		
		System.out.println("mypage.mybatis/MypageMybatis.java - profitor [6]");
		
		return 0;
	}
	
	public static HashMap<String, Object> loadProfile(int mnum) {
		
		System.out.println("mypage/mybatis - loadProfile [1]");
		
		SqlSession session = sqlMapper.openSession();
		
		HashMap<String, Object> map = new HashMap<>();
		
		System.out.println("mypage/mybatis - loadProfile [2]");
		
		//프로필 사진 불러와욧!
		//session.selectList("loadpi", mnum);
		
		
		//에디터 내용 불러와욧!
		
		System.out.println("mypage/mybatis - loadProfile [pre mnum] : " + mnum);

		session.selectList("loadPe", mnum);
		
		List<ProfitorDBBean> peList = session.selectList("loadPe", mnum);
		session.close();
		System.out.println("peList.size() : " + peList.size());
		
		if(peList.size()!=0){
			System.out.println("mypage/mybatis - loadProfile [post mnum] : " + peList.get(0).getPenum());
			
			map.put("pe", peList.get(0));
		} else{
			map.put("pe", new ProfitorDBBean());
		}
		
		System.out.println("mypage/mybatis - loadProfile [3]");
				
		System.out.println("mypage/mybatis - loadProfile [4]");
		
		System.out.println("mypage/mybatis - loadProfile [5]");
		
		System.out.println("mypage/mybatis - loadProfile [6]");
		
		return map;
	}
	
	public static ProfimageDBBean getPhoto(int mnum) {
		System.out.println("MypageMybatis_getPhoto() 실행");
		System.out.println(mnum);
		SqlSession session = sqlMapper.openSession();
		List<ProfimageDBBean> list = session.selectList("getPhoto",mnum);
		session.close();
		ProfimageDBBean dto = null;
		if(list.size() != 0){
			dto = list.get(0);
		}
		System.out.println(dto);
		return dto;
	}
	public static List getPurchaseOncont(int mnum) {
		System.out.println("MypageMybatis_getPurchaseOncont()실행");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("purchaseOncont", mnum);
		session.close();
		return list;
	}
	
	public static List getSaleOncont(int mnum) {
		// TODO Auto-generated method stub
		System.out.println("MypageMybatis_getSaleOncont()실행");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("saleOncont", mnum);
		session.close();
		return list;
	}
	
	public static ProfitorDBBean getProfile(int mnum) {
		// TODO Auto-generated method stub
		System.out.println("MypageMybatis_getProfile() 실행");
		SqlSession session = sqlMapper.openSession();
		List<ProfitorDBBean> list = session.selectList("loadPe",mnum);
		ProfitorDBBean dto = null;
		if(list.size() != 0){
			dto = list.get(0);
		}
		System.out.println(dto);
		session.close();
		return dto;
	}
}
