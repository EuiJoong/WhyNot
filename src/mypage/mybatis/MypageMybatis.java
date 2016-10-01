package mypage.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import mypage.model.ProfimageDBBean;

public class MypageMybatis {
	
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = ��ġ ����
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			// 1.SqlMapConfig.xml
			// ������ ���� ���� ������
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// ���̹�Ƽ���� �ٲ�鼭 ����Ÿ������ ó���� ���ְ� ��
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
		
		System.out.println("[MypageMybatis.java] DB���� ���� ���������?? " + res);
		
		if(res>0) {
			booleana = true;
		}else{
			booleana = false;
		}	
		
		System.out.println("[MypageMybatis.java] �� ������� �����ϱ��?? " + booleana);
		
		
		
		return booleana;		
	}
	
	public static int updatePassword(HashMap<String, Object> map) {
		
		System.out.println("updatePassword Ȯ��1");
		
		SqlSession session = sqlMapper.openSession();
		
		System.out.println("updatePassword Ȯ��2");
		
		int res = session.update("updatePassword", map);

		System.out.println("updatePassword Ȯ��3");
		
		session.commit();
		session.close();
		
		System.out.println("updatePassword Ȯ��4");
		
		return 0;		
	}
	
	public static int profimageMerge(ProfimageDBBean pi) {
		
		System.out.println("mypage.mybatis/MypageMybatis.java 1");
		
		SqlSession session = sqlMapper.openSession();
		
		System.out.println("mypage.mybatis/MypageMybatis.java 2");
		
		int res = session.insert("profimage", pi);
		session.commit();
		session.close();
		
		System.out.println("mypage.mybatis/MypageMybatis.java 3");
		
		System.out.println("mypage.mybatis/MypageMybatis.java 4");
		
		return 0;		
	}
}
