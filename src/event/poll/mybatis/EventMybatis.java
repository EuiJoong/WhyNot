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
	public static void insertEvent(EventDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("EventMybatis_insertEvent() ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertEvent", dto);
		session.commit(); // insert�� �ݵ�� commit()�� ����� �����Ͱ� ������
		session.close();
	}
	
	public static void deleteEvent() {
		// TODO Auto-generated method stub
		System.out.println("EventMybatis_deleteEvent() ����");
		
	}
	public static void updateEvent(EventDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("EventMybatis_updateEvent() ����");
		SqlSession session = sqlMapper.openSession();
		session.update("updateEvent", dto);
		session.commit();
		session.close();
	}
	
	public static List<EventDBBean> listEvent()
	{
		// TODO Auto-generated method stub
		System.out.println("EventMybatis_listEvent() ����");
		SqlSession session = sqlMapper.openSession();
		List<EventDBBean> list = session.selectList("listEvent");
		session.close();
		return list;
	}
	
	public static EventDBBean getEvent(int eventNum) {
		// TODO Auto-generated method stub
		System.out.println("EventMybatis_getEvent() ����");
		return null;
	}
	
	
}
