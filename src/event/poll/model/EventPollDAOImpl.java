package event.poll.model;

import java.util.List;

import event.poll.mybatis.EventPollMybatis;
import onlinecontent.mybatis.OnlineContentMybatis;

public class EventPollDAOImpl implements EventPollDAO {

	@Override
	public void insertPoll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePoll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePoll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getPoll() {
		// TODO Auto-generated method stub
		//
		List list = EventPollMybatis.detailPoll();
		return list;
	}

	@Override
	public void doPoll() {
		// TODO Auto-generated method stub
		
	}

}
