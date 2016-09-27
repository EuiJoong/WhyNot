package onlinecurriculum.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import attachfile.model.ClassVideoDBBean;
import attachfile.model.TextDBBean;
import onlinecurriculum.model.OnlineCurriculumDBBean;  

public class OnlineCurriculumMybatis{
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
	
	public static List getCurriculum(OnlineCurriculumDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("OnlineCurriculumMybatis_getCurriculum() ����");
		SqlSession session = sqlMapper.openSession();
		List currList =  session.selectList("getCurr",dto);
		session.close();
		return currList;
	}
	public static List<OnlineCurriculumDBBean> listCurriculum(int lsnum) {
		// TODO Auto-generated method stub
		System.out.println("OnlineCurriculumMybatis_listCurriculum() ����");
		SqlSession session = sqlMapper.openSession();
		List<OnlineCurriculumDBBean> currList = session.selectList("listCurr",lsnum);
		session.close();
		
		return currList;
	}
	
	public static List<OnlineCurriculumDBBean> listCurriculumData(OnlineCurriculumDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("OnlineCurriculumMybatis_listCurriculumData() ����");
		SqlSession session = sqlMapper.openSession();
		List<OnlineCurriculumDBBean> currOne = session.selectList("listCurrData",dto);
		session.close();
		return currOne;
	}
	
	public static void createLesson(int ocnum){
		System.out.println("OnlineCurriculumMybatis_createLesson() ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("createLesson",ocnum);
		session.commit();
		session.close();
		System.out.println("Lesson ���� �Ϸ�!!");
		
	}
	
	public static int getLsnum(int ocnum){
		System.out.println("OnlineCurriculumMybatis_getLsnum() ����");
		SqlSession session = sqlMapper.openSession();
		int lsnum =  session.selectOne("getLsnum",ocnum);
		session.close();
		return lsnum;
	}
	
	public static void insertCurriculum(OnlineCurriculumDBBean oc_dto ,TextDBBean t_dto, ClassVideoDBBean v_dto) {
		// TODO Auto-generated method stub
		System.out.println("OnlineCurriculumMybatis_insertCurriculum() ����");
		SqlSession session = sqlMapper.openSession();
		System.out.println(oc_dto);
		Map curriculumMap = new HashMap<>();
		curriculumMap.put("oc_dto", oc_dto);
		curriculumMap.put("t_dto", t_dto);
		curriculumMap.put("v_dto", v_dto);
		if (t_dto.getFilename() == null || t_dto.getFilename().equals(""))
			session.insert("insertContent_textNo", curriculumMap);
		else
			session.insert("insertContent_textOk", curriculumMap);
		session.commit();
		session.close();
		System.out.println("session insert");
		
	}
	public static void updateCurriculum(OnlineCurriculumDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}
	public static void deleteCurriculum(OnlineCurriculumDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}

}
