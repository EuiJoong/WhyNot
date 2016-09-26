package event.poll.model;

import java.util.List;

public interface EventDAO {

	//------- ������ --------------------
	public void insertEvent(EventDBBean dto); // �̺�Ʈ ����
	public void deleteEvent(int eventNum); // �̺�Ʈ ����
	public void updateEvent(EventDBBean dto); // �̺�Ʈ ����
	public EventDBBean getEvent(int eventNum);
	public List<EventDBBean> listEvent();
}
