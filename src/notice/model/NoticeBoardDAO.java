package notice.model;

import java.util.List;

import event.poll.model.CurrPollDBBean;

public interface NoticeBoardDAO {
///listNoticeEvent
	public List listNoticeEvent();
	public List listNoticeNormal();
	public List listNoticeAll();
	public List listEventNum();
	public void insertNotice(NoticeBoardDBBean ndto);
	public List getNominees(int eventnum);
	public NoticeBoardDBBean detailNotice(int ntnum);
	public void doVoteUpdate(int eventnum, int nominee);
	public void insertCurrPoll(CurrPollDBBean cdto);
	public void deleteNotice(int ntnum);
	public boolean isVote(CurrPollDBBean cdto);
}
