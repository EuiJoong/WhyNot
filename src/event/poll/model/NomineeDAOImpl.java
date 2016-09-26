package event.poll.model;

import java.util.List;

import event.poll.mybatis.EventMybatis;
import event.poll.mybatis.NomineeMybatis;

public class NomineeDAOImpl implements NomineeDAO
{

	@Override
	public void insertNominee(NomineeDBBean dto) {
		System.out.println("EventDAOImpl_insertNominee() 角青");
		NomineeMybatis.insertNominee(dto); 
		System.out.println("己傍!");
	}

	@Override
	public void deleteNominee(int nomiNum) {
		System.out.println("NomineeDAOImpl_deleteNominee() 角青");
		NomineeMybatis.deleteNominee(nomiNum); 
		System.out.println("己傍!");
	}

	@Override
	public void updateNominee(NomineeDBBean dto) {
		System.out.println("NomineeDAOImpl_updateNominee() 角青");
		NomineeMybatis.updateNominee(dto); 
		System.out.println("己傍!");
	}

	@Override
	public NomineeDBBean getNominee(int nomiNum) {
		System.out.println("NomineeDAOImpl_getNominee() 角青");
		NomineeDBBean dto = new NomineeDBBean();
		dto = NomineeMybatis.getNominee(nomiNum);
		System.out.println("NomineeDAOImpl_getNominee() 己傍!");
		return dto;
	}

	@Override
	public List<NomineeDBBean> listNominee() {
		System.out.println("NomineeMybatis_listNominee() 角青");
		List<NomineeDBBean> list = NomineeMybatis.listNominee();
		System.out.println("NomineeMybatis_listNominee() 己傍");
		return list;
	}
	
	@Override
	public List<NomineeDBBean> getEventNum() {
		System.out.println("NomineeMybatis_getEventNum() 角青");
		List<NomineeDBBean> list = NomineeMybatis.getEventNum();
		System.out.println("NomineeMybatis_getEventNum() 己傍");
		return list;
	}
	
}
