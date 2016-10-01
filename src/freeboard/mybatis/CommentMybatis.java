package freeboard.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import category.model.CategoryDBBean;
import freeboard.model.CommentDBBean;


public class CommentMybatis {
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

	public static List listComment(int bnum) {
		// TODO Auto-generated method stub
		System.out.println("CommentMybatis_ListComment() 실행");
		SqlSession session = sqlMapper.openSession();
	    List list = session.selectList("listComment",bnum);
		session.close();
		return list;
	}

	public static void insertComment(CommentDBBean dto) {
		// TODO Auto-generated method stub 
		System.out.println("CommentMybatis_insertComment() 실행");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertComment", dto);
		session.commit(); // insert는 반드시 commit()를 해줘야 데이터가 쓰여짐
		session.close();
	}


	public static void deleteComment(int cbnum) {
		System.out.println("CommentMybatis_deleteCate() 실행");
		SqlSession session = sqlMapper.openSession();
		session.delete("deleteComment", cbnum);
		session.commit();
		session.close();
	}

}


