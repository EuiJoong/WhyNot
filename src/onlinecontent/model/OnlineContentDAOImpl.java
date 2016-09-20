package onlinecontent.model;

import java.util.List;

import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;
import onlinecontent.mybatis.OnlineContentMybatis;

public class OnlineContentDAOImpl implements OnlineContentDAO {

	@Override
	public OnlineContentDBBean getContent(int num) {
		// TODO Auto-generated method stub
		OnlineContentDBBean dto = new OnlineContentDBBean();
		dto = OnlineContentMybatis.getContent(num);
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
		// OnlineContentDBBean
		OnlineContentMybatis.insertContent(oc_dto, p_dto, v_dto);// ��� �� dao��
																	// ���̹�Ƽ����
																	// ���鼭 ���
																	// �Ǵ� �κ���!
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

}
