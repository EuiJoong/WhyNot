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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEvent(EventDBBean dto) {
		System.out.println("EventDAOImpl_updateEvent() 角青");
		EventMybatis.updateEvent(dto); 
		System.out.println("己傍!");
	}

	@Override
	public EventDBBean getEvent(int ctnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EventDBBean> listEvent() {
		System.out.println("EventDAOImpl_listCategory() 角青");
		List<EventDBBean> list = EventMybatis.listEvent(); 
		return list;
	}

	
}
