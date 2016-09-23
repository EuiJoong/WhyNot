package payment.model;

import java.util.List;

public interface PaymentDAO {
	
	public void purchaseOnline(OnlinePaymentDBBean dto);//강좌 구매
	public OnlinePaymentDBBean chkPurchaseOnline(int mnum, int ocnum);//강좌 구매내역 
	
	public void purchaseOffline(int mnum,OfflinePaymentDBBean offline_dto);//후원 
	public OfflinePaymentDBBean chkPurchaseOffline(int mnum,OfflinePaymentDBBean offline_dto);//후원 구매내역
	
	public void purchaseMileage(MileagePaymentDBBean mileage_dto);//마일리지 충전
	public List<MileagePaymentDBBean> listPurchaseMileage(MileagePaymentDBBean mileage_dto); //마일리지 충전 내역
	
	public void exchangeMileage(MileagePaymentDBBean mileage_dto);//마일리지 환전
	public List<MileagePaymentDBBean> listExchangeMileage(MileagePaymentDBBean mileage_dto);//마일리지 환전 내역
	
}
