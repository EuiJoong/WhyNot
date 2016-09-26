package event.poll.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import event.poll.model.EventDBBean;
import event.poll.model.NomineeDBBean;

public class NomineeMybatis
{
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
	
	public static List<NomineeDBBean> listNominee()
	{
		System.out.println("NomineeMybatis_listNominee() 실행");
		SqlSession session = sqlMapper.openSession();
		List<NomineeDBBean> list = session.selectList("listNominee");
		session.close();
		System.out.println("NomineeMybatis_listNominee() 성공");
		return list;
	}
	
	public static List<NomineeDBBean> getEventNum()
	{
		System.out.println("NomineeMybatis_getEventNum() 실행");
		SqlSession session = sqlMapper.openSession();
		List<NomineeDBBean> list = session.selectList("getEventNum");
		session.close();
		System.out.println("NomineeMybatis_getEventNum() 성공");
		return list;
	}
	
	public static void insertNominee(NomineeDBBean dto) {
		System.out.println("NomineeMybatis_insertNominee() 실행");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertNominee", dto);
		session.commit();
		session.close();
		System.out.println("NomineeMybatis_insertNominee() 성공!");
	}
	
	public static void deleteNominee(int nomiNum) {
		System.out.println("NomineeMybatis_deleteNominee() 실행");
		SqlSession session = sqlMapper.openSession();
		session.delete("deleteNominee", nomiNum);
		session.commit();
		session.close();
	}
	
	public static void updateNominee(NomineeDBBean dto) {
		System.out.println("NomineeMybatis_updateNominee() 실행");
		SqlSession session = sqlMapper.openSession();
		session.update("updateNominee", dto);
		session.commit();
		session.close();
	}
	
	public static NomineeDBBean getNominee(int nomiNum) {
		System.out.println("EventMybatis_getEvent() 실행");
		NomineeDBBean dto = new NomineeDBBean();
		SqlSession session = sqlMapper.openSession();
		dto = (NomineeDBBean) session.selectOne("getNominee", nomiNum); 
		session.commit();
		session.close();
		return dto;
	}
}
