package freeboard.model;

import java.util.HashMap;
import java.util.List;

import category.mybatis.CategoryMybatis;
import freeboard.mybatis.CommentMybatis;

public class CommentDAOImpl implements CommentDAO {

	@Override
	public List listCommnet(int bnum) {
		// TODO Auto-generated method stub

		System.out.println("CommentDAOImpl_listComment() 角青");
		return CommentMybatis.listComment(bnum);

	}

	@Override
	public void insertComment(CommentDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("CommentDAOImpl_insertComment() 角青");
		
		CommentMybatis.insertComment(dto);
		System.out.println("己傍!");

		
	}


	@Override
	public void deleteComment(int cbnum) {
		// TODO Auto-generated method stub
		System.out.println("CommentDAOImpl_deleteComment() 角青");
		CommentMybatis.deleteComment(cbnum);
		System.out.println("己傍!");
	}

	@Override
	public int cbchk(int cbnum) {
		// TODO Auto-generated method stub
		return 0;
	}



}