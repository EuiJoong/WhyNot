package offlinecontent.model;

import java.util.List;
import java.util.Map;

import attachfile.model.PhotoDBBean;
import offlinecontent.mybatis.OfflineContentMybatis;

public class OfflineContentDAOImpl implements OfflineContentDAO{

	@Override
	public OfflineContentDBBean getContent(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listOfflineContent(int ctnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listClassRoom() {
		// TODO Auto-generated method stub
		System.out.println("OfflineContentDAOImpl-listClassRoom 실행");
		List list = OfflineContentMybatis.listClassRoom();
		return list;
	}
	
	@Override
	public boolean insertContent(OfflineContentDBBean offDTO, ClassRoomDBBean crDTO, ReserveDateDBBean rdateDTO, PhotoDBBean ptDTO) {
		// TODO Auto-generated method stub
		boolean res = OfflineContentMybatis.insertContent(offDTO, crDTO, rdateDTO, ptDTO);
		return res;
	}

	@Override
	public void updateContent(OfflineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List recommendContent(int mnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sanctionsContent(OfflineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContent(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List listSearchClassRoom(Map paramMap) {
		// TODO Auto-generated method stub
		System.out.println("OfflineContentDAOImpl-listSearchClassRoom 실행");
		List list = OfflineContentMybatis.listSearchClassRoom(paramMap);
//		for(int i=0; i<list.size(); i++) {
//			System.out.println("OfflineContentDAOImpl-listSearchClassRoom : "+list.get(i).toString());
//		}
		return list;
	}

}
