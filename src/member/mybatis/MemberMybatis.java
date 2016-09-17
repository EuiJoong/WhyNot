package member.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import member.model.MemberDBBean;

//SqlMapConfig.xml에 등록된 것들을 java코드로 사용할 수 있도록 해주는 곳
public class MemberMybatis  {

	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = 위치 지정 
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			//1.SqlMapConfig.xml 
			// 들어오는 값을 지정 시켜줌
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// 마이바티스로 바뀌면서 세션타입으로 처리를 해주게 됌
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	public static void insertMember(MemberDBBean dto) {
		System.out.println("MemberMybatis_insertBoard() 실행");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertMember", dto);
		session.commit(); // insert는 반드시 commit()를 해줘야 데이터가 쓰여짐
		session.close();
	}
	
	public static MemberDBBean getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void deleteMember(String id) {
		// TODO Auto-generated method stub
		
	}
	public static void updateMember(MemberDBBean dto, String id) {
		// TODO Auto-generated method stub
		
	}
	//아이디 중복 확인
	public static boolean idChk(String id) {
		// TODO Auto-generated method stub
		System.out.println("MemberMybatis_idChk() 실행");
		SqlSession session = sqlMapper.openSession();
		boolean res = session.selectOne("idChk", id);
		session.close();
		
		return false;
	}
	public static List<MemberDBBean> listMember() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void sanctionsMember(MemberDBBean dto, int mnum) {
		// TODO Auto-generated method stub
		
	}

	
	

}
