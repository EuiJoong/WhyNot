package event.poll.model;

import java.util.List;

public interface PollDAO
{
	public List<PollDBBean> listPoll();
	public List<PollDBBean> listPoll(int eventNum);
	public List<PollDBBean> getAllEvent();
}
