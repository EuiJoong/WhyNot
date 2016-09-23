package member.model;

import java.util.List;

public interface MemberDAO {
	
	//---- User ---------
	public MemberDBBean getMember(String id);//������ ��� ����
	public void insertMember(MemberDBBean dto);//ȸ������
	public void deleteMember(String id);//ȸ������ ����
	public void updateMember(MemberDBBean dto,String id);//ȸ������ ����
	public boolean idChk(String id);
	public void findPassword(String id);
	public void chargeMileage(int mnum, int mileage);
	//---- ������ ---------
	public List<MemberDBBean> listMember(); //��� ȸ������
	public void sanctionsMember(MemberDBBean dto,int mnum);//ȸ�� ����(�����ڿ�)
	public void updateAuth(String id,String auth); //���� Ȯ��
	
}
