package event.poll.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.ibatis.common.resources.Resources;
import event.poll.model.EventDBBean;

public class EventMybatis {
	
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
	public static void insertEvent(EventDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("EventMybatis_insertEvent() 실행");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertEvent", dto);
		session.commit(); // insert는 반드시 commit()를 해줘야 데이터가 쓰여짐
		session.close();
	}
	
	public static void deleteEvent() {
		// TODO Auto-generated method stub
		System.out.println("EventMybatis_deleteEvent() 실행");
		
	}
	public static void updateEvent(EventDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("EventMybatis_updateEvent() 실행");
		SqlSession session = sqlMapper.openSession();
		session.update("updateEvent", dto);
		session.commit();
		session.close();
	}
	
	public static List<EventDBBean> listEvent()
	{
		// TODO Auto-generated method stub
		System.out.println("EventMybatis_listEvent() 실행");
		SqlSession session = sqlMapper.openSession();
		List<EventDBBean> list = session.selectList("listEvent");
		session.close();
		return list;
	}
	
	public static EventDBBean getEvent(int eventNum) {
		// TODO Auto-generated method stub
		System.out.println("EventMybatis_getEvent() 실행");
		return null;
	}
	
	
}
