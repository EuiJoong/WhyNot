package freeboard.model;

import java.util.HashMap;
import java.util.List;

import category.mybatis.CategoryMybatis;
import freeboard.mybatis.CommentMybatis;

public class CommentDAOImpl implements CommentDAO {

	@Override
	public List listCommnet(int bnum) {
		// TODO Auto-generated method stub

		System.out.println("CommentDAOImpl_listComment() ����");
		return CommentMybatis.listComment(bnum);

	}

	@Override
	public void insertComment(CommentDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("CommentDAOImpl_insertComment() ����");
		
		CommentMybatis.insertComment(dto);
		System.out.println("����!");

		
	}


	@Override
	public void deleteComment(int cbnum) {
		// TODO Auto-generated method stub
		System.out.println("CommentDAOImpl_deleteComment() ����");
		CommentMybatis.deleteComment(cbnum);
		System.out.println("����!");
	}

	@Override
	public int cbchk(int cbnum) {
		// TODO Auto-generated method stub
		return 0;
	}



}