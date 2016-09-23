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
			// Reader = ��ġ ���� 
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			//1.SqlMapConfig.xml 
			// ������ ���� ���� ������
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// ���̹�Ƽ���� �ٲ�鼭 ����Ÿ������ ó���� ���ְ� ��
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	
	//�¶��� ���� (�ΰ�)
	public static void purchaseOnline(OnlinePaymentDBBean dto){
		System.out.println("PaymentMybatis_purchaseOnline() ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("purchaseOnline", dto);
		session.commit(); // insert�� �ݵ�� commit()�� ����� �����Ͱ� ������
		session.close();
	}
	
	//�¶��� ���� ��� Ȯ�� �޼ҵ� (�������� �ִ��� ������ )
	public static OnlinePaymentDBBean chkPurchaseOnline(int mnum, int ocnum){
		System.out.println("PaymentMybatis_chkPurchaseOnline() ����");
		
		HashMap<String, Object> data = new HashMap<>();
		data.put("mnum", mnum);
		data.put("ocnum", ocnum);
		
		SqlSession session = sqlMapper.openSession();
		OnlinePaymentDBBean dto = session.selectOne("chkPurchaseOnline",data);
		return dto;
	}
	
	
	//�������� ���� (�Ŀ�)
	public static void purchaseOffline(OnlinePaymentDBBean dto){
		System.out.println("PaymentMybatis_purchaseOffline() ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("purchaseOffline", dto);
		session.commit(); // insert�� �ݵ�� commit()�� ����� �����Ͱ� ������
		session.close();
	} 
	

	//���ϸ��� ���� (����)
	public static void purchaseMileage(MileagePaymentDBBean dto){
		System.out.println("PaymentMybatis_purchaseMileage() ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("purchaseMileage", dto);
		session.commit(); // insert�� �ݵ�� commit()�� ����� �����Ͱ� ������
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

