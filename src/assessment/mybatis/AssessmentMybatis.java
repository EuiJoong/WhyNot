package assessment.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import assessment.model.AssessmentDBBean;

public class AssessmentMybatis {
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

	public static void insertAssessment(AssessmentDBBean dto) {
		System.out.println("AssessmentMybatis_AssessmentCate() ����");
		System.out.println(dto.getContent());
		System.out.println(dto.getGrademark());
		SqlSession session = sqlMapper.openSession();
		session.insert("insertAssessment", dto);
		session.commit(); // insert�� �ݵ�� commit()�� ����� �����Ͱ� ������
		session.close();
		System.out.println("���ϱ� ���!");
	}



	public static List listAssessment(int ocnum){
		System.out.println("AssessmentMybatis_ListAssessment() ����");
		System.out.println("ocnum : "+ocnum);
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listAssessment", ocnum);
	
		//session.commit();
		System.out.println("mybatis����! ����Ʈ ������ : "+list.size());
		session.close();
		return list;
	}
	
	
	
	
	
}
