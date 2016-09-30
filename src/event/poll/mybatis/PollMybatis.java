package event.poll.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import event.poll.model.PollDBBean;

public class PollMybatis{
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
	
	public static List<PollDBBean> listPoll(int eventNum)
	{
		System.out.println("PollMybatis_listPoll() ����");
		SqlSession session = sqlMapper.openSession();
		List<PollDBBean> list = session.selectList("listPoll", eventNum);
		session.close();
		return list;
	}
	
	public static List<PollDBBean> listPoll()
	{
		System.out.println("PollMybatis_listPoll() ����");
		SqlSession session = sqlMapper.openSession();
		List<PollDBBean> list = session.selectList("listPolll");
		session.close();
		return list;
	}
	
	public static List<PollDBBean> getAllEvent()
	{
		System.out.println("PollMybatis_getAllEvent() ����");
		SqlSession session = sqlMapper.openSession();
		List<PollDBBean> list = session.selectList("getAllEvent");
		session.close();
		return list;
	}
}
