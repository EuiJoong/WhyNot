package onlinecontent.model;

import java.util.List;

import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;


public interface OnlineContentDAO {
	
	//---- User ---------
	public VideoDBBean getContent(int num); //인강(학교) - 상세보기
	public List listOnlineContent(int ctnum); //인강(학교) - 전체   
	public void insertContent(OnlineContentDBBean oc_dto, PhotoDBBean p_dto, VideoDBBean v_dto); //인강(학교) - 등록
	public void updateContent(OnlineContentDBBean dto ,int num); //인강(학교) - 수정
	public List recommendContent(int mnum);
	public List getDetailWho(int ocnum);
	//---- 관리자 ---------
	public void sanctionsContent(OnlineContentDBBean dto,int num);//인강(학교) - 제재
	public void deleteContent(int num); //인강(학교) - 삭제
	
}
