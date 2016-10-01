package freeboard.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import freeboard.model.FreeBoardDBBean;

public class FreeBoardMybatis {
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = ��ġ ���� 
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			//1.SqlMapConfig.xml 
			// ������ ���� ���� ������
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// ���̹�Ƽ���� �ٲ�鼭 ����Ÿ������ ó���� ���ְ� ��
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	
	public static void insertfreeBoard(FreeBoardDBBean dto) {
		System.out.println("BoardMybatis_insertBoard() ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertfreeBoard", dto);
		session.commit(); // insert�� �ݵ�� commit()�� ����� �����Ͱ� ������
		session.close();
	}
	public static List listfreeBoard(HashMap map) {
		System.out.println("BoardMybatis_ListBoard() ����");
		SqlSession session = sqlMapper.openSession();
	    List list = session.selectList("listfreeBoard", map);
		session.close();
		return list;
	}
	public static void deletefreeBoard(int bnum) {
		System.out.println("BoardMybatis_deleteBoard() ����");
		SqlSession session = sqlMapper.openSession();
		session.delete("deletefreeBoard", bnum);
		session.commit();
		session.close();
	}
	public static int freecount(int bnum) {
		// TODO Auto-generated method stub
		System.out.println("BoardMybatis_count() ����");
		SqlSession session = sqlMapper.openSession();
		session.update("freereadCount", bnum);
		session.commit();
		session.close();
		return 0;
	}
	public static int freegetCount() {
		// TODO Auto-generated method stub
		System.out.println("BoardMybatis_getCount() ����");
		SqlSession session = sqlMapper.openSession();
		int count = session.selectOne("freegetCount");
		session.close();
		return count;
	}
	public static int freechk(int bnum) {
		// TODO Auto-generated method stub
		System.out.println("BoardMybatis_chk() ����");
		SqlSession session = sqlMapper.openSession();
	    int chk = session.selectOne("freechk", bnum);
		session.close();
		return chk;
	}
	public static FreeBoardDBBean getfreeBoard(int bnum) {
		// TODO Auto-generated method stub
		System.out.println("BoardMybatis_getBoard() ����");
		SqlSession session = sqlMapper.openSession();
		FreeBoardDBBean dto = session.selectOne("getfreeBoard", bnum);
		session.close();
		return dto;
	}
	public static void updatefreeBoard(FreeBoardDBBean dto) {
		// TODO Auto-generated method stub
		SqlSession session = sqlMapper.openSession();
		int res = session.update("updatefreeBoard", dto);
		session.commit();
		session.close();
	}
	
	
	
	
	
}
