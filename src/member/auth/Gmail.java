package member.auth;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class Gmail {
    
    public static void sendMail(String id, String tokenKey){
        Properties properties = new Properties();
        properties.put("mail.smtp.user", "master1whytnot@gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.debug", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        
        try {
            Authenticator auth = new senderAccount();
            Session session = Session.getInstance(properties, auth);
            session.setDebug(true); // ������ ������ �� ���� ��Ȳ�� �ֿܼ� ����Ѵ�.
            MimeMessage msg = new MimeMessage(session);
 
            msg.setSubject("[���̳�] ��ũ�� Ŭ���� ȸ�������� �Ϸ����ּ���!");
            Address fromAddr = new InternetAddress("master1whytnot@gmail.com"); // �����»�� EMAIL
            msg.setFrom(fromAddr);
            Address toAddr = new InternetAddress(id);    // �޴»�� EMAIL DB���� �ش� �̸��� �ּ� �ҷ���
            msg.addRecipient(Message.RecipientType.TO, toAddr);
            msg.setContent(
            		"���ο� ��� �񸶸� ���! �ݰ����ϴ�!\n\n"+
            		"���� Ȱ��ȭ�� ���� �Ʒ��� ��ũ�� Ŭ���� �ֽø� ������ �Ϸ�˴ϴ�!\n\n"+
            		"http://localhost:8080/WhyNot/authOk.member?auth="+tokenKey+"&id="+id,
            		"text/plain;charset=KSC5601"); //���� ���۵� ����
            Transport.send(msg);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private static class senderAccount extends javax.mail.Authenticator {
 
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("master1whynot", "ktiuwrcnqokqhdsk"); // @gmail.com ������ ���� ID, PASS
 
        }
    }
}