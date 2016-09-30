package event.poll.model;

import java.util.List;

import event.poll.mybatis.PollMybatis;

public class PollDAOImpl implements PollDAO {

	@Override
	public List<PollDBBean> listPoll() {
		System.out.println("PollDAOImpl_listPoll() 실행");
		List<PollDBBean> list = PollMybatis.listPoll(); 
		return list;
	}
	
	@Override
	public List<PollDBBean> listPoll(int eventNum) {
		System.out.println("PollDAOImpl_listPoll() 실행");
		List<PollDBBean> list = PollMybatis.listPoll(eventNum); 
		return list;
	}
	
	@Override
	public List<PollDBBean> getAllEvent() {
		System.out.println("PollDAOImpl_getAllEvent() 실행");
		List<PollDBBean> list = PollMybatis.getAllEvent(); 
		return list;
	}

}
