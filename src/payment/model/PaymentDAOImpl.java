package payment.model;

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
	public void purchaseOffline(OfflinePaymentDBBean offline_dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void purchaseMileage(MileagePaymentDBBean mileage_dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exchangeMileage(MileagePaymentDBBean mileage_dto) {
		// TODO Auto-generated method stub
		
	}


}
