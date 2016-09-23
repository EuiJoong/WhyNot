package payment.model;

import java.util.List;

public interface PaymentDAO {
	
	public void purchaseOnline(OnlinePaymentDBBean dto);//���� ����
	public OnlinePaymentDBBean chkPurchaseOnline(int mnum, int ocnum);//���� ���ų��� 
	
	public void purchaseOffline(int mnum,OfflinePaymentDBBean offline_dto);//�Ŀ� 
	public OfflinePaymentDBBean chkPurchaseOffline(int mnum,OfflinePaymentDBBean offline_dto);//�Ŀ� ���ų���
	
	public void purchaseMileage(MileagePaymentDBBean mileage_dto);//���ϸ��� ����
	public List<MileagePaymentDBBean> listPurchaseMileage(MileagePaymentDBBean mileage_dto); //���ϸ��� ���� ����
	
	public void exchangeMileage(MileagePaymentDBBean mileage_dto);//���ϸ��� ȯ��
	public List<MileagePaymentDBBean> listExchangeMileage(MileagePaymentDBBean mileage_dto);//���ϸ��� ȯ�� ����
	
}
