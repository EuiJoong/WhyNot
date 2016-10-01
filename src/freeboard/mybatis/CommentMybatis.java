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

	public static List listComment(int bnum) {
		// TODO Auto-generated method stub
		System.out.println("CommentMybatis_ListComment() ����");
		SqlSession session = sqlMapper.openSession();
	    List list = session.selectList("listComment",bnum);
		session.close();
		return list;
	}

	public static void insertComment(CommentDBBean dto) {
		// TODO Auto-generated method stub 
		System.out.println("CommentMybatis_insertComment() ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertComment", dto);
		session.commit(); // insert�� �ݵ�� commit()�� ����� �����Ͱ� ������
		session.close();
	}


	public static void deleteComment(int cbnum) {
		System.out.println("CommentMybatis_deleteCate() ����");
		SqlSession session = sqlMapper.openSession();
		session.delete("deleteComment", cbnum);
		session.commit();
		session.close();
	}

}


