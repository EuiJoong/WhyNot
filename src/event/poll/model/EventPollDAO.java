package event.poll.model;

public interface EventPollDAO {
	
	//------- ������ --------------------
	public void insertPoll(); //��ǥ �Խñ� ���
	public void deletePoll(); //��ǥ �Խñ� ����
	public void updatePoll(); //��ǥ �Խñ� ����
	public void getPoll(); //��ǥ �󼼺���
	
	//------- ����� --------------------
	public void doPoll(); //��ǥ 
	
	
}
