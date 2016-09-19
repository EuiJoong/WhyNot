package onlinecontent.model;

import java.util.List;

import attachfile.model.VideoDBBean;
import onlinecontent.mybatis.OnlineContentMybatis;

public class OnlineContentDAOImpl implements OnlineContentDAO {

	@Override
	public OnlineContentDBBean getContent(int num) {
		// TODO Auto-generated method stub
		OnlineContentDBBean dto=new OnlineContentDBBean();
		dto=OnlineContentMybatis.getContent(num);
		return dto;
	}

	@Override
	public List<OnlineContentDBBean> listOnlineContent() {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override //OnlineContentVideoDBBean c_dto 추가
	public void insertContent(VideoDBBean v_dto, int num) { 
		// TODO Auto-generated method stub
//OnlineContentDBBean
		System.out.println(v_dto.getFiledir()+", "+num); //c_dto 추가해야함
		OnlineContentMybatis.insertContent(v_dto,num);//사실 이 dao는 마이바티스를 쓰면서 없어도 되는 부분임! 
		//그냥 수업떄 쓴 것 뿐
	}

	@Override
	public void updateContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sanctionsContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContent(int num) {
		// TODO Auto-generated method stub
		
	}


}
