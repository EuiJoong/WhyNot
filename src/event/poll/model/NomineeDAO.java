package event.poll.model;

import java.util.List;

public interface NomineeDAO
{
	//------- ������ --------------------
		public void insertNominee(NomineeDBBean dto); // �ĺ��� ���
		public void deleteNominee(int nomiNum); // �ĺ��� ����
		public void updateNominee(NomineeDBBean dto); // �ĺ��� ����
		public NomineeDBBean getNominee(int nomiNum);
		public List<NomineeDBBean> listNominee();
		public List<NomineeDBBean> getEventNum();
}
