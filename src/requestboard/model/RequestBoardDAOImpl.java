package requestboard.model;

import java.util.HashMap;
import java.util.List;

import requestboard.mybatis.RequestBoardMybatis;

public class RequestBoardDAOImpl implements RequestBoardDAO {

	@Override
	public List listBoard(int startPage, int endPage) {
		System.out.println("PushboardDAOImpl_listBoard() 角青");
		HashMap map = new HashMap();
		map.put("start", startPage);
		map.put("end", endPage);
		return RequestBoardMybatis.listBoard(map);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		System.out.println("PushboardDAOImpl_getCount() 角青");
		int count =  RequestBoardMybatis.getCount();
		System.out.println("11");
		return count;
	}

	@Override
	public void insertBoard(RequestBoardDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("PushboardDAOImpl_insertBoard() 角青");
		RequestBoardMybatis.insertBoard(dto);
		System.out.println("己傍!");
	}

	@Override
	public void deleteBoard(int bnum) {
		// TODO Auto-generated method stub
		System.out.println("PushboardDAOImpl_deleteBoard() 角青");
		RequestBoardMybatis.deleteBoard(bnum);
		System.out.println("己傍!");
	}
	@Override
	public void count(int bnum) {
		// TODO Auto-generated method stub
		RequestBoardMybatis.count(bnum);
	}

	@Override
	public RequestBoardDBBean getBoard(String mode, int bnum) {
		if(mode.equals("content")){
			count(bnum);
		}
		return RequestBoardMybatis.getBoard(bnum);
	}
	
	@Override
	public void updateBoard(RequestBoardDBBean dto) {
		// TODO Auto-generated method stub
		RequestBoardMybatis.updateBoard(dto);
	}

	@Override
	public int chk(int bnum) {
		// TODO Auto-generated method stub
		return RequestBoardMybatis.chk(bnum);
	}

	@Override
	public void push(int bnum) {
		// TODO Auto-generated method stub
		RequestBoardMybatis.push(bnum);
	}

}
