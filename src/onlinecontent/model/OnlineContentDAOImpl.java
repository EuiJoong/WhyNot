package onlinecontent.model;

import java.util.List;

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

	@Override
	public void insertContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
//OnlineContentDBBean
		System.out.println(dto.getFiledir()+", "+num);
		OnlineContentMybatis.insertContent(dto,num);//사실 이 dao는 마이바티스를 쓰면서 없어도 되는 부분임! 
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
	public void deleteContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}


}
