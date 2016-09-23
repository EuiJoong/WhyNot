package payment.model;

import java.util.List;

import payment.mybatis.PaymentMybatis;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public void purchaseOnline(OnlinePaymentDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("PaymentDAOImpl_purchaseOnline()");
		PaymentMybatis.purchaseOnline(dto);
	}
	
	@Override
	public OnlinePaymentDBBean chkPurchaseOnline(int mnum, int ocnum) {
		// TODO Auto-generated method stub
		System.out.println("PaymentDAOImpl_chkPurchaseOnline()");
		OnlinePaymentDBBean dto = PaymentMybatis.chkPurchaseOnline(mnum, ocnum);
		return dto;
	}
	

	@Override
	public void purchaseOffline(int mnum, OfflinePaymentDBBean offline_dto) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void purchaseMileage(MileagePaymentDBBean mileage_dto) {
		System.out.println("PaymentDAOImpl_purchaseMileage() 실행");
		PaymentMybatis.purchaseMileage(mileage_dto);
		System.out.println("성공!");
		
	}

	@Override
	public void exchangeMileage(MileagePaymentDBBean mileage_dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OfflinePaymentDBBean chkPurchaseOffline(int mnum,OfflinePaymentDBBean offline_dto) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<MileagePaymentDBBean> listPurchaseMileage(MileagePaymentDBBean mileage_dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MileagePaymentDBBean> listExchangeMileage(MileagePaymentDBBean mileage_dto) {
		// TODO Auto-generated method stub
		return null;
	}


}
