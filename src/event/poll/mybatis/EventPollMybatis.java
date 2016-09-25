package event.poll.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import event.poll.model.EventPollDAO;

public class EventPollMybatis{
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
	public static void insertPoll() {
		// TODO Auto-generated method stub
		System.out.println("EventPollMybatis_insertPoll() ����");
		
	}
	public static void deletePoll() {
		// TODO Auto-generated method stub
		System.out.println("EventPollMybatis_deletePoll() ����");
		
	}
	public static void updatePoll() {
		// TODO Auto-generated method stub
		System.out.println("EventPollMybatis_updatePoll() ����");
		
	}
	public static void detailPoll() {
		// TODO Auto-generated method stub
		System.out.println("EventPollMybatis_detailPoll() ����");
		
	}
	public static void doPoll() {
		// TODO Auto-generated method stub
		System.out.println("EventPollMybatis_doPoll() ����");
		
	}
	
	
}
