package event.poll.model;

import java.util.List;

import event.poll.mybatis.EventMybatis;
import event.poll.mybatis.NomineeMybatis;

public class NomineeDAOImpl implements NomineeDAO
{

	@Override
	public void insertNominee(NomineeDBBean dto) {
		System.out.println("EventDAOImpl_insertNominee() ����");
		NomineeMybatis.insertNominee(dto); 
		System.out.println("����!");
	}

	@Override
	public void deleteNominee(int nomiNum) {
		System.out.println("NomineeDAOImpl_deleteNominee() ����");
		NomineeMybatis.deleteNominee(nomiNum); 
		System.out.println("����!");
	}

	@Override
	public void updateNominee(NomineeDBBean dto) {
		System.out.println("NomineeDAOImpl_updateNominee() ����");
		NomineeMybatis.updateNominee(dto); 
		System.out.println("����!");
	}

	@Override
	public NomineeDBBean getNominee(int nomiNum) {
		System.out.println("NomineeDAOImpl_getNominee() ����");
		NomineeDBBean dto = new NomineeDBBean();
		dto = NomineeMybatis.getNominee(nomiNum);
		System.out.println("NomineeDAOImpl_getNominee() ����!");
		return dto;
	}

	@Override
	public List<NomineeDBBean> listNominee() {
		System.out.println("NomineeMybatis_listNominee() ����");
		List<NomineeDBBean> list = NomineeMybatis.listNominee();
		System.out.println("NomineeMybatis_listNominee() ����");
		return list;
	}
	
	@Override
	public List<NomineeDBBean> getEventNum() {
		System.out.println("NomineeMybatis_getEventNum() ����");
		List<NomineeDBBean> list = NomineeMybatis.getEventNum();
		System.out.println("NomineeMybatis_getEventNum() ����");
		return list;
	}
	
}
