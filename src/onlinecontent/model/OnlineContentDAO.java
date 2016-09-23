package onlinecontent.model;

import java.util.List;

import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;


public interface OnlineContentDAO {
	
	//---- User ---------
	public VideoDBBean getContent(int num); //�ΰ�(�б�) - �󼼺���
	public List listOnlineContent(int ctnum); //�ΰ�(�б�) - ��ü   
	public void insertContent(OnlineContentDBBean oc_dto, PhotoDBBean p_dto, VideoDBBean v_dto); //�ΰ�(�б�) - ���
	public void updateContent(OnlineContentDBBean dto ,int num); //�ΰ�(�б�) - ����
	public List recommendContent(int mnum);
	public List getDetailWho(int ocnum);
	//---- ������ ---------
	public void sanctionsContent(OnlineContentDBBean dto,int num);//�ΰ�(�б�) - ����
	public void deleteContent(int num); //�ΰ�(�б�) - ����
	
}
