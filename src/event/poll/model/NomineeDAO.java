package event.poll.model;

import java.util.List;

public interface NomineeDAO
{
	//------- 관리자 --------------------
		public void insertNominee(NomineeDBBean dto); // 후보자 등록
		public void deleteNominee(int nomiNum); // 후보자 삭제
		public void updateNominee(NomineeDBBean dto); // 후보자 수정
		public NomineeDBBean getNominee(int nomiNum);
		public List<NomineeDBBean> listNominee();
		public List<NomineeDBBean> getEventNum();
}
