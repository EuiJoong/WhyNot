package freeboard.model;

import java.util.HashMap;
import java.util.List;

import freeboard.mybatis.FreeBoardMybatis;

public class FreeBoardDAOImpl implements FreeBoardDAO {

	@Override
	public List listfreeBoard(int startPage, int endPage) {
		System.out.println("FreeboardDAOImpl_listfreeBoard() 角青");
		HashMap map = new HashMap();
		map.put("start", startPage);
		map.put("end", endPage);
		return FreeBoardMybatis.listfreeBoard(map);
	}

	@Override
	public int freegetCount() {
		// TODO Auto-generated method stub
		System.out.println("FreeboardDAOImpl_freegetCount() 角青");
		int count =  FreeBoardMybatis.freegetCount();
		System.out.println("11");
		return count;
	}

	@Override
	public void insertfreeBoard(FreeBoardDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("FreeboardDAOImpl_insertfreeBoard() 角青");
		FreeBoardMybatis.insertfreeBoard(dto);
		System.out.println("己傍!");
	}

	@Override
	public void deletefreeBoard(int bnum) {
		// TODO Auto-generated method stub
		System.out.println("FreeboardDAOImpl_deletefreeBoard() 角青");
		FreeBoardMybatis.deletefreeBoard(bnum);
		System.out.println("己傍!");
	}
	@Override
	public void freecount(int bnum) {
		// TODO Auto-generated method stub
		FreeBoardMybatis.freecount(bnum);
	}

	@Override
	public FreeBoardDBBean getfreeBoard(String mode, int bnum) {
		if(mode.equals("content")){
			freecount(bnum);
		}
		return FreeBoardMybatis.getfreeBoard(bnum);
	}
	
	@Override
	public void updatefreeBoard(FreeBoardDBBean dto) {
		// TODO Auto-generated method stub
		FreeBoardMybatis.updatefreeBoard(dto);
	}

	@Override
	public int freechk(int bnum) {
		// TODO Auto-generated method stub
		return FreeBoardMybatis.freechk(bnum);
	}


}
