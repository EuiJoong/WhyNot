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

	public static void insertAssessment(AssessmentDBBean dto) {
		System.out.println("AssessmentMybatis_AssessmentCate() 실행");
		System.out.println(dto.getContent());
		System.out.println(dto.getGrademark());
		SqlSession session = sqlMapper.openSession();
		session.insert("insertAssessment", dto);
		session.commit(); // insert는 반드시 commit()를 해줘야 데이터가 쓰여짐
		session.close();
		System.out.println("평가하기 등록!");
	}



	public static List listAssessment(int ocnum){
		System.out.println("AssessmentMybatis_ListAssessment() 실행");
		System.out.println("ocnum : "+ocnum);
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listAssessment", ocnum);
	
		//session.commit();
		System.out.println("mybatis에서! 리스트 사이즈 : "+list.size());
		session.close();
		return list;
	}
	
	
	
	
	
}
