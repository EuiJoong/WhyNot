package event.vote.model;

public interface EventVoteDAO {
	
	//------- 관리자 --------------------
	public void insertVote(); //투표 게시글 등록
	public void deleteVote(); //투표 게시글 삭제
	public void updateVote(); //투표 게시글 수정
	public void detailVote();
	
	//------- 사용자 --------------------
	public void doVote(); //투표 
	
	
}
