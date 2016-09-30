package offlinecontent.model;

import java.util.List;
import java.util.Map;

import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;
import onlinecontent.model.OnlineContentDBBean;

public interface OfflineContentDAO {
	//---- User ---------
	public OfflineContentDBBean getContent(int num); //�Ŀ� - �󼼺���
	public List listOfflineContent(int ctnum); //�Ŀ� - ��ü  
	public List listClassRoom();
	public List listSearchClassRoom(Map paramMap);
	public boolean insertContent(OfflineContentDBBean offDTO, ClassRoomDBBean crDTO, ReserveDateDBBean rdateDTO, PhotoDBBean ptDTO); //�Ŀ� - ���
	public void updateContent(OfflineContentDBBean dto ,int num); //�Ŀ� - ����
	public List recommendContent(int mnum);
	
	//---- ������ ---------
	public void sanctionsContent(OfflineContentDBBean dto,int num);//�Ŀ� - ����
	public void deleteContent(int num); //�ΰ�(�б�) - ����
}
