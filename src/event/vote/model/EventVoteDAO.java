package event.vote.model;

public interface EventVoteDAO {
	
	//------- ������ --------------------
	public void insertVote(); //��ǥ �Խñ� ���
	public void deleteVote(); //��ǥ �Խñ� ����
	public void updateVote(); //��ǥ �Խñ� ����
	public void detailVote();
	
	//------- ����� --------------------
	public void doVote(); //��ǥ 
	
	
}
