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
			// Reader = 위치 지정
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			// 1.SqlMapConfig.xml
			// 들어오는 값을 지정 시켜줌
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// 마이바티스로 바뀌면서 세션타입으로 처리를 해주게 됌
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
	public static List listNoticeEvent() {//이벤트 공지 출력
		// TODO Auto-generated method stub
		System.out.println("NoticeBoardMybatis_listNoticeEvent() 실행");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listNoticeEvent");
		session.close();
		return list;
	}
	//listNoticeNormal
	
	public static List listNoticeNormal() {//이벤트 공지 출력
		// TODO Auto-generated method stub
		System.out.println("NoticeBoardMybatis_listNoticeNormal() 실행");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listNoticeNormal");
		session.close();
		return list;
	}
	
	public static List listNoticeAll()//공지 전체 출력
	{
		System.out.println("NoticeBoardMybatis_listNoticeNormal() 실행");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listNoticeAll");
		session.close();
		return list;
	}
	
	public static List<NomineeDBBean> getEventNum()
	{
		System.out.println("NoticeMybatis_getEventNum() 실행");
		SqlSession session = sqlMapper.openSession();
		List<NomineeDBBean> list = session.selectList("getEventNum1");
		session.close();
		System.out.println("NoticeBoardMybatis_getEventNum() 성공");
		return list;
	}
	
	public static void insertNotice(NoticeBoardDBBean ndto)
	{
		System.out.println("NoticeMybatis_insertNotice() 실행");
		SqlSession session = sqlMapper.openSession();
		System.out.println("들어갈 내용 : "+ndto.getContent());
		session.insert("insertNotice",ndto);
		session.commit();
		session.close();
		System.out.println("공지 등록 성공");
	}
	//selectNomineeOfEventnum
	public static List selectNomineeOfEventnum(int eventnum)
	{
		System.out.println("NoticeMybatis_selectNomineeOfEventnum() 실행");
		SqlSession session = sqlMapper.openSession();
		System.out.println("들어갈 내용 : "+eventnum);
		List list=session.selectList("selectNomineeOfEventnum",eventnum);
		session.commit();
		session.close();
		System.out.println("투표 후보자들 select 성공!");
		
		return list;
	}
	
	//selectNotice
	public static NoticeBoardDBBean selectNotice(int ntnum)
	{
		System.out.println("NoticeMybatis_selectNotice() 실행");
		SqlSession session = sqlMapper.openSession();
		System.out.println("들어갈 내용 : "+ntnum);
		NoticeBoardDBBean ndto=session.selectOne("selectNotice",ntnum);
		session.commit();
		session.close();
		System.out.println("공지 상세정보 가져오기 성공!");
		
		return ndto;
	}
	//updateVoteScore
	public static void updateVoteScore(int eventnum, int nominee)
	{
		System.out.println("NoticeMybatis_updateVoteScore() 실행");
		SqlSession session = sqlMapper.openSession();
		System.out.println("들어갈 내용 : "+eventnum+" , "+nominee);
		NomineeDBBean ndto=new NomineeDBBean();
		ndto.setEventNum(eventnum);
		ndto.setNomiNum(nominee);
		
		session.update("updateVoteScore",ndto);
		session.commit();
		session.close();
		System.out.println("투표 성공");

	}
	//insertCurrPoll
	public static void insertCurrPoll(CurrPollDBBean cdto)
	{
		System.out.println("NoticeMybatis_insertCurrPoll() 실행");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertCurrPoll",cdto);
		session.commit();
		session.close();
		System.out.println("currpoll에 로그 등록!");
	}
	
	//isVote
	
	public static boolean isVote(CurrPollDBBean cdto)
	{
		System.out.println("NoticeMybatis_isVote() 실행");
		SqlSession session=sqlMapper.openSession();
		List list=session.selectList("isVote", cdto);
		boolean result=false;
		if(list.size()>0 )//투표 이미 했다는 거니까
			result=true;
		
		return result;
	}
	
	
	
}
