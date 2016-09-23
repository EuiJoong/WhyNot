package payment.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import payment.model.MileagePaymentDBBean;
import payment.model.OfflinePaymentDBBean;
import payment.model.OnlinePaymentDBBean;

public class PaymentMybatis {
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = 위치 지정 
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			//1.SqlMapConfig.xml 
			// 들어오는 값을 지정 시켜줌
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// 마이바티스로 바뀌면서 세션타입으로 처리를 해주게 됌
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	
	//온라인 구매 (인강)
	public static void purchaseOnline(OnlinePaymentDBBean dto){
		System.out.println("PaymentMybatis_purchaseOnline() 실행");
		SqlSession session = sqlMapper.openSession();
		session.insert("purchaseOnline", dto);
		session.commit(); // insert는 반드시 commit()를 해줘야 데이터가 쓰여짐
		session.close();
	}
	
	//온라인 구매 기록 확인 메소드 (결제한적 있는지 없는지 )
	public static OnlinePaymentDBBean chkPurchaseOnline(int mnum, int ocnum){
		System.out.println("PaymentMybatis_chkPurchaseOnline() 실행");
		
		HashMap<String, Object> data = new HashMap<>();
		data.put("mnum", mnum);
		data.put("ocnum", ocnum);
		
		SqlSession session = sqlMapper.openSession();
		OnlinePaymentDBBean dto = session.selectOne("chkPurchaseOnline",data);
		return dto;
	}
	
	
	//오프라인 구매 (후원)
	public static void purchaseOffline(OnlinePaymentDBBean dto){
		System.out.println("PaymentMybatis_purchaseOffline() 실행");
		SqlSession session = sqlMapper.openSession();
		session.insert("purchaseOffline", dto);
		session.commit(); // insert는 반드시 commit()를 해줘야 데이터가 쓰여짐
		session.close();
	} 
	

	//마일리지 구매 (충전)
	public static void purchaseMileage(MileagePaymentDBBean dto){
		System.out.println("PaymentMybatis_purchaseMileage() 실행");
		SqlSession session = sqlMapper.openSession();
		session.insert("purchaseMileage", dto);
		session.commit(); // insert는 반드시 commit()를 해줘야 데이터가 쓰여짐
		session.close();
	} 
	
	public static void exchangeMileage(MileagePaymentDBBean mileage_dto) {
		// TODO Auto-generated method stub
		
	}

	public static void chkPurchaseOffline(OfflinePaymentDBBean offline_dto) {
		// TODO Auto-generated method stub
		
	}

	public static void listPurchaseMileage(MileagePaymentDBBean mileage_dto) {
		// TODO Auto-generated method stub
		
	}

	public static void listExchangeMileage(MileagePaymentDBBean mileage_dto) {
		// TODO Auto-generated method stub
		
	}
}

