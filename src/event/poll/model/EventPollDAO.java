package event.poll.model;

import java.util.List;

public interface EventPollDAO {
	
	//------- ������ --------------------
	public void insertPoll(); //��ǥ �Խñ� ���
	public void deletePoll(); //��ǥ �Խñ� ����
	public void updatePoll(); //��ǥ �Խñ� ����
	public List getPoll(); //��ǥ �󼼺���
	
	//------- ����� --------------------
	public void doPoll(); //��ǥ 
	
	
}
