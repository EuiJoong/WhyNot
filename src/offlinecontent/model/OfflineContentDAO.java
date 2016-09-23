package offlinecontent.model;

import java.util.List;

import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;
import onlinecontent.model.OnlineContentDBBean;

public interface OfflineContentDAO {
	//---- User ---------
	public OfflineContentDBBean getContent(int num); //�Ŀ� - �󼼺���
	public List listOfflineContent(int ctnum); //�Ŀ� - ��ü   
	public void insertContent(OfflineContentDBBean oc_dto, PhotoDBBean p_dto); //�Ŀ� - ���
	public void updateContent(OfflineContentDBBean dto ,int num); //�Ŀ� - ����
	public List recommendContent(int mnum);
	
	//---- ������ ---------
	public void sanctionsContent(OfflineContentDBBean dto,int num);//�Ŀ� - ����
	public void deleteContent(int num); //�ΰ�(�б�) - ����
}
