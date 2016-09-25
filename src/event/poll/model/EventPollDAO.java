package event.poll.model;

public interface EventPollDAO {
	
	//------- 관리자 --------------------
	public void insertPoll(); //투표 게시글 등록
	public void deletePoll(); //투표 게시글 삭제
	public void updatePoll(); //투표 게시글 수정
	public void getPoll(); //투표 상세보기
	
	//------- 사용자 --------------------
	public void doPoll(); //투표 
	
	
}
