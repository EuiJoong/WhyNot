package notice.mybatis;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import event.poll.model.CurrPollDBBean;
import event.poll.model.NomineeDBBean;
import notice.model.NoticeBoardDBBean;

public class NoticeBoardMybatis {
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
		} catch (Exception e) {
			// Fail fast.
			e.printStackTrace();
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

	public static void deleteNotice(int ntnum)
	{
		SqlSession session=sqlMapper.openSession();
		session.delete("deleteNotice", ntnum);
		session.commit();
		session.close();
		
	}
	public static List listNoticeEvent() {//�̺�Ʈ ���� ���
		// TODO Auto-generated method stub
		System.out.println("NoticeBoardMybatis_listNoticeEvent() ����");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listNoticeEvent");
		session.close();
		return list;
	}
	//listNoticeNormal
	
	public static List listNoticeNormal() {//�̺�Ʈ ���� ���
		// TODO Auto-generated method stub
		System.out.println("NoticeBoardMybatis_listNoticeNormal() ����");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listNoticeNormal");
		session.close();
		return list;
	}
	
	public static List listNoticeAll()//���� ��ü ���
	{
		System.out.println("NoticeBoardMybatis_listNoticeNormal() ����");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listNoticeAll");
		session.close();
		return list;
	}
	
	public static List<NomineeDBBean> getEventNum()
	{
		System.out.println("NomineeMybatis_getEventNum() ����");
		SqlSession session = sqlMapper.openSession();
		List<NomineeDBBean> list = session.selectList("getEventNum");
		session.close();
		System.out.println("NoticeBoardMybatis_getEventNum() ����");
		return list;
	}
	
	public static void insertNotice(NoticeBoardDBBean ndto)
	{
		System.out.println("NomineeMybatis_insertNotice() ����");
		SqlSession session = sqlMapper.openSession();
		System.out.println("�� ���� : "+ndto.getContent());
		session.insert("insertNotice",ndto);
		session.commit();
		session.close();
		System.out.println("���� ��� ����");
	}
	//selectNomineeOfEventnum
	public static List selectNomineeOfEventnum(int eventnum)
	{
		System.out.println("NomineeMybatis_selectNomineeOfEventnum() ����");
		SqlSession session = sqlMapper.openSession();
		System.out.println("�� ���� : "+eventnum);
		List list=session.selectList("selectNomineeOfEventnum",eventnum);
		session.commit();
		session.close();
		System.out.println("��ǥ �ĺ��ڵ� select ����!");
		
		return list;
	}
	
	//selectNotice
	public static NoticeBoardDBBean selectNotice(int ntnum)
	{
		System.out.println("NomineeMybatis_selectNotice() ����");
		SqlSession session = sqlMapper.openSession();
		System.out.println("�� ���� : "+ntnum);
		NoticeBoardDBBean ndto=session.selectOne("selectNotice",ntnum);
		session.commit();
		session.close();
		System.out.println("���� ������ �������� ����!");
		
		return ndto;
	}
	//updateVoteScore
	public static void updateVoteScore(int eventnum, int nominee)
	{
		System.out.println("NomineeMybatis_updateVoteScore() ����");
		SqlSession session = sqlMapper.openSession();
		System.out.println("�� ���� : "+eventnum+" , "+nominee);
		NomineeDBBean ndto=new NomineeDBBean();
		ndto.setEventNum(eventnum);
		ndto.setNomiNum(nominee);
		
		session.update("updateVoteScore",ndto);
		session.commit();
		session.close();
		System.out.println("��ǥ ����");

	}
	//insertCurrPoll
	public static void insertCurrPoll(CurrPollDBBean cdto)
	{
		System.out.println("NomineeMybatis_insertCurrPoll() ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertCurrPoll",cdto);
		session.commit();
		session.close();
		System.out.println("currpoll�� �α� ���!");
	}
	
}
