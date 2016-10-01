package requestboard.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import requestboard.model.RequestBoardDBBean;

public class RequestBoardMybatis {
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
	
	public static void insertBoard(RequestBoardDBBean dto) {
		System.out.println("BoardMybatis_insertBoard() 실행");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertBoard", dto);
		session.commit(); // insert는 반드시 commit()를 해줘야 데이터가 쓰여짐
		session.close();
	}
	public static List listBoard(HashMap map) {
		System.out.println("BoardMybatis_ListBoard() 실행");
		SqlSession session = sqlMapper.openSession();
	    List list = session.selectList("listBoard", map);
		session.close();
		return list;
	}
	public static void deleteBoard(int bnum) {
		System.out.println("BoardMybatis_deleteBoard() 실행");
		SqlSession session = sqlMapper.openSession();
		session.delete("deleteBoard", bnum);
		session.commit();
		session.close();
	}
	public static void count(int bnum) {
		// TODO Auto-generated method stub
		System.out.println("BoardMybatis_count() 실행");
		SqlSession session = sqlMapper.openSession();
		session.update("readCount", bnum);
		session.commit();
		session.close();
	}
	public static int getCount() {
		// TODO Auto-generated method stub
		System.out.println("BoardMybatis_getCount() 실행");
		SqlSession session = sqlMapper.openSession();
		int count = session.selectOne("getCount");
		session.close();
		return count;
	}
	public static int chk(int bnum) {
		// TODO Auto-generated method stub
		System.out.println("BoardMybatis_chk() 실행");
		SqlSession session = sqlMapper.openSession();
	    int chk = session.selectOne("chk", bnum);
		session.close();
		return chk;
	}
	public static RequestBoardDBBean getBoard(int bnum) {
		// TODO Auto-generated method stub
		System.out.println("BoardMybatis_getBoard() 실행");
		SqlSession session = sqlMapper.openSession();
		RequestBoardDBBean dto = session.selectOne("getBoard", bnum);
		session.close();
		return dto;
	}
	public static void updateBoard(RequestBoardDBBean dto) {
		// TODO Auto-generated method stub
		SqlSession session = sqlMapper.openSession();
		int res = session.update("updateBoard", dto);
		session.commit();
		session.close();
	}
	
	

	public static void push(int bnum) {
		// TODO Auto-generated method stub
		System.out.println("BoardMybatis_count() 실행");
		SqlSession session = sqlMapper.openSession();
		session.update("push", bnum);
		session.commit();
		session.close();
	}
	
	
}
