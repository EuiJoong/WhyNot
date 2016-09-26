package event.poll.model;

import java.util.List;

import category.mybatis.CategoryMybatis;
import event.poll.mybatis.EventMybatis;


public class EventDAOImpl implements EventDAO {

	@Override
	public void insertEvent(EventDBBean dto) {
		System.out.println("EventDAOImpl_insertEvent() ����");
		EventMybatis.insertEvent(dto); 
		System.out.println("����!");
	}

	@Override
	public void deleteEvent(int eventNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEvent(EventDBBean dto) {
		System.out.println("EventDAOImpl_updateEvent() ����");
		EventMybatis.updateEvent(dto); 
		System.out.println("����!");
	}

	@Override
	public EventDBBean getEvent(int ctnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EventDBBean> listEvent() {
		System.out.println("EventDAOImpl_listCategory() ����");
		List<EventDBBean> list = EventMybatis.listEvent(); 
		return list;
	}

	
}
