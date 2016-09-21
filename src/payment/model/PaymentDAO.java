package payment.model;

public interface PaymentDAO {
	
	public void purchaseOnline(OnlinePaymentDBBean dto);//강좌 구매
	
	//필요없을듯???? PaymentMybatis.class에 메소드 있음...  일단 냅둬봄
	public OnlinePaymentDBBean chkPurchaseOnline(int mnum, int ocnum); 
	public void purchaseOffline(OfflinePaymentDBBean offline_dto);//후원 
	public void purchaseMileage(MileagePaymentDBBean mileage_dto);//마일리지 충전
	public void exchangeMileage(MileagePaymentDBBean mileage_dto);//마일리지 환전
	
}
