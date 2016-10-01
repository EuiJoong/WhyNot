package freeboard.model;
import java.util.List;


public interface CommentDAO {

	public List listCommnet(int bnum);
	public void insertComment(CommentDBBean dto);
	public void deleteComment(int cbnum);
	public int cbchk(int cbnum);
}
