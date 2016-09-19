package onlinecontent.model;

import java.util.List;

import attachfile.model.VideoDBBean;


public interface OnlineContentDAO {
	
	//---- User ---------
	public OnlineContentDBBean getContent(int num); //�ΰ�(�б�) - �󼼺���
	public List<OnlineContentDBBean> listOnlineContent(); //�ΰ�(�б�) - ��ü   
	public void insertContent(VideoDBBean v_dto,int num); //�ΰ�(�б�) - ���
	public void updateContent(OnlineContentDBBean dto ,int num); //�ΰ�(�б�) - ����
	
	//---- ������ ---------
	public void sanctionsContent(OnlineContentDBBean dto,int num);//�ΰ�(�б�) - ����
	public void deleteContent(int num); //�ΰ�(�б�) - ����
	
}
