package offlinecontent.model;

import java.util.List;

import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;
import onlinecontent.model.OnlineContentDBBean;

public interface OfflineContentDAO {
	//---- User ---------
	public OfflineContentDBBean getContent(int num); //후원 - 상세보기
	public List listOfflineContent(int ctnum); //후원 - 전체   
	public void insertContent(OfflineContentDBBean oc_dto, PhotoDBBean p_dto); //후원 - 등록
	public void updateContent(OfflineContentDBBean dto ,int num); //후원 - 수정
	public List recommendContent(int mnum);
	
	//---- 관리자 ---------
	public void sanctionsContent(OfflineContentDBBean dto,int num);//후원 - 제재
	public void deleteContent(int num); //인강(학교) - 삭제
}
