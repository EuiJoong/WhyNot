package event.poll.model;

import java.util.List;

import category.mybatis.CategoryMybatis;
import event.poll.mybatis.EventMybatis;


public class EventDAOImpl implements EventDAO {

	@Override
	public void insertEvent(EventDBBean dto) {
		System.out.println("EventDAOImpl_insertEvent() 角青");
		EventMybatis.insertEvent(dto); 
		System.out.println("己傍!");
	}

	@Override
	public void deleteEvent(int eventNum) {
		System.out.println("EventDAOImpl_deleteEvent() 角青");
		EventMybatis.deleteEvent(eventNum); 
		System.out.println("己傍!");
	}

	@Override
	public void updateEvent(EventDBBean dto) {
		System.out.println("EventDAOImpl_updateEvent() 角青");
		EventMybatis.updateEvent(dto); 
		System.out.println("己傍!");
	}

	@Override
	public EventDBBean getEvent(int eventNum) {
		System.out.println("EventDAOImpl_getEvent() 角青");
		EventDBBean dto = new EventDBBean();
		dto = EventMybatis.getEvent(eventNum);
		System.out.println("EventDAOImpl_getEvent() 己傍!");
		return dto;
	}

	@Override
	public List<EventDBBean> listEvent() {
		System.out.println("EventDAOImpl_listCategory() 角青");
		List<EventDBBean> list = EventMybatis.listEvent(); 
		return list;
	}

	
}
