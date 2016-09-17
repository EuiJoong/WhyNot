package onlinecontent.model;

import java.util.List;

import member.model.MemberDBBean;


public interface OnlineContentDAO {
	
	//---- User ---------
	public OnlineContentDBBean getContent(int num); //인강(학교) - 상세보기
	public List<OnlineContentDBBean> listOnlineContent(); //인강(학교) - 전체   
	public void insertContent(OnlineContentDBBean dto ,int num); //인강(학교) - 등록
	public void updateContent(OnlineContentDBBean dto ,int num); //인강(학교) - 수정
	
	//---- 관리자 ---------
	public void sanctionsContent(OnlineContentDBBean dto,int num);//인강(학교) - 제재
	public void deleteContent(OnlineContentDBBean dto ,int num); //인강(학교) - 삭제
	
}
