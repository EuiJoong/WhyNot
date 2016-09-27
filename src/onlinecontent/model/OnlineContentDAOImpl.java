package onlinecontent.model;

import java.util.List;

import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;
import onlinecontent.mybatis.OnlineContentMybatis;

public class OnlineContentDAOImpl implements OnlineContentDAO {

	@Override
	public VideoDBBean getContent(int ocnum) {
		// TODO Auto-generated method stub
		VideoDBBean dto = new VideoDBBean();
		dto = OnlineContentMybatis.getContent(ocnum);
		return dto;
	}

	@Override
	public List listOnlineContent(int ctnum) {
		// TODO Auto-generated method stub
		List list = OnlineContentMybatis.listOnlineContent(ctnum);
		return list;

	}

	@Override // OnlineContentVideoDBBean c_dto �߰�
	public void insertContent(OnlineContentDBBean oc_dto, PhotoDBBean p_dto, VideoDBBean v_dto) {
		// TODO Auto-generated method stub
		System.out.println("OnlineContentDAOImpl_insertContent() ����");
		// ��� �� dao�� ���̹�Ƽ���� ���鼭 ����Ǵ� �κ���!
		OnlineContentMybatis.insertContent(oc_dto, p_dto, v_dto);
		// �׳� ������ �� �� ��
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

	@Override //��õ ����
	public List recommendContent(int mnum) {
		// TODO Auto-generated method stub
		System.out.println("OnlineContentDAOImpl_recommendContent() ����");
		return OnlineContentMybatis.recommendContent(mnum);
	}
	
	@Override
	public List getDetailWho(int ocnum) {
		// TODO Auto-generated method stub
		System.out.println("OnlineContentDAOImpl_getDetailWho()");
		//OnlineContentDBBean dto=new OnlineContentDBBean();
		List list=OnlineContentMybatis.getDetailWho(ocnum);
		return list;
	}

	@Override
	public List getBestContent() {
		// TODO Auto-generated method stub
		System.out.println("OnlineContentDAOImpl_getBestContent()");
		return OnlineContentMybatis.getBestContent();
	}

	@Override
	public List searchContent(String searchStr) {
		// TODO Auto-generated method stub
		System.out.println("OnlineContentDAOImpl_searchContent()");
		return OnlineContentMybatis.searchContent(searchStr);
	}

}
