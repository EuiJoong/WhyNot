package onlinecurriculum.qna.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import onlinecurriculum.qna.model.OnlineCurriculumQNADBBean;

public class OnlineCurriculumQNAMybatis  {
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
	
	public static List listCurriQNA(int lsnum) {
		// TODO Auto-generated method stub
		SqlSession session = sqlMapper.openSession();
		List<OnlineCurriculumQNADBBean> list = session.selectList("listContentQa", lsnum);
		session.close();
		return list;
	}
	
	public static void insertCurriQNA(OnlineCurriculumQNADBBean ocqna){
		SqlSession session = sqlMapper.openSession();
		System.out.println("내용:"+ocqna.getContent());
//		Map qnaMap = new HashMap<>();
//		qnaMap.put("lsnum", ocqna.getLsnum());
//		qnaMap.put("content", ocqna.getContent());
//		qnaMap.put("mnum", ocqna.getMnum());
		
		session.insert("insertQNA", ocqna);
		session.commit();
		System.out.println("qna insert");
		session.close();
	}
	
	public static void answerCurriQNA(OnlineCurriculumQNADBBean ocqna){
		SqlSession session = sqlMapper.openSession();
		
		session.insert("answerQNA", ocqna);
		session.commit();
		System.out.println("qna insert");
		session.close();
	}
	
	public static void deleteCurriQNA(int qanum, int mnum){
		SqlSession session = sqlMapper.openSession();
		
		Map<String, Integer> deleteQAMap = new HashMap<>();
		
		deleteQAMap.put("qanum", qanum);
		deleteQAMap.put("mnum",	mnum);
		
		session.delete("deleteQNA", deleteQAMap);
		
		session.commit();
		session.close();
		System.out.println("deleteQA Complete");
	}
	
	
}
