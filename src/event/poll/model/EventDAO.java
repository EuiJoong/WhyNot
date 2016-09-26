package event.poll.model;

import java.util.List;

public interface EventDAO {

	//------- 관리자 --------------------
	public void insertEvent(EventDBBean dto); // 이벤트 생성
	public void deleteEvent(int eventNum); // 이벤트 삭제
	public void updateEvent(EventDBBean dto); // 이벤트 수정
	public EventDBBean getEvent(int eventNum);
	public List<EventDBBean> listEvent();
}
