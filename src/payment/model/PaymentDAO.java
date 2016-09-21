package payment.model;

public interface PaymentDAO {
	
	public void purchaseOnline(OnlinePaymentDBBean dto);//���� ����
	
	//�ʿ������???? PaymentMybatis.class�� �޼ҵ� ����...  �ϴ� ���ֺ�
	public OnlinePaymentDBBean chkPurchaseOnline(int mnum, int ocnum); 
	public void purchaseOffline(OfflinePaymentDBBean offline_dto);//�Ŀ� 
	public void purchaseMileage(MileagePaymentDBBean mileage_dto);//���ϸ��� ����
	public void exchangeMileage(MileagePaymentDBBean mileage_dto);//���ϸ��� ȯ��
	
}
