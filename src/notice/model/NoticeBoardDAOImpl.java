package notice.model;

import java.util.List;

import event.poll.model.CurrPollDBBean;
import notice.mybatis.NoticeBoardMybatis;

public class NoticeBoardDAOImpl implements NoticeBoardDAO{

	@Override
	public List listNoticeEvent() {
		// TODO Auto-generated method stub
		List list=NoticeBoardMybatis.listNoticeEvent();
		return list;
	}

	@Override
	public List listNoticeNormal() {
		// TODO Auto-generated method stub
		List list=NoticeBoardMybatis.listNoticeNormal();
		return list;
	}

	@Override
	public List listNoticeAll() {
		// TODO Auto-generated method stub
		List list=NoticeBoardMybatis.listNoticeAll();
		return list;
	}

	@Override
	public List listEventNum() {
		// TODO Auto-generated method stub
		List list=NoticeBoardMybatis.getEventNum();
		return list;
	}

	@Override
	public void insertNotice(NoticeBoardDBBean ndto) {
		// TODO Auto-generated method stub
		NoticeBoardMybatis.insertNotice(ndto);
		
	}

	@Override
	public List getNominees(int eventnum) {
		// TODO Auto-generated method stub
		//이벤트 별 후보자목록 출력
		List list=NoticeBoardMybatis.selectNomineeOfEventnum(eventnum);
		return list;
	}

	@Override
	public NoticeBoardDBBean detailNotice(int ntnum) {
		// TODO Auto-generated method stub
		NoticeBoardDBBean ndto=NoticeBoardMybatis.selectNotice(ntnum);
		return ndto;
	}

	@Override
	public void doVoteUpdate(int eventnum, int nominee) {
		// TODO Auto-generated method stub
		NoticeBoardMybatis.updateVoteScore(eventnum,nominee);
		
	}

	@Override
	public void insertCurrPoll(CurrPollDBBean cdto) {
		// TODO Auto-generated method stub
		NoticeBoardMybatis.insertCurrPoll(cdto);
	}

	@Override
	public void deleteNotice(int ntnum) {
		// TODO Auto-generated method stub
		NoticeBoardMybatis.deleteNotice(ntnum);
		
		
	}
	
	
	
	

}
