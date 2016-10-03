package member.model;

import java.util.HashMap;
import java.util.List;

public interface MemberDAO {
	
	//---- User ---------
	public MemberDBBean getMember(int mnum);//������ ��� ����
	public void insertMember(MemberDBBean dto);//ȸ������
	public void deleteMember(String id);//ȸ������ ����
	public void updateMember(MemberDBBean dto,String id);//ȸ������ ����
	public int idChk(String id);
	public boolean authCHK(HashMap authMap);
	public boolean reAuth(HashMap reAuthMap);
	public void findPassword(String id);
	public void chargeMileage(MemberDBBean dto);
	public void tradeMileage(int mnum, int mileage , int seller);
	public MemberDBBean  getPasswd(String id);
	//---- ������ ---------
	public List<MemberDBBean> listMember(); //��� ȸ������
	public void sanctionsMember(MemberDBBean dto,int mnum);//ȸ�� ����(�����ڿ�)
	public void updateAuth(String id,String auth); //���� Ȯ��
	
}
