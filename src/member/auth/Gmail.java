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
            session.setDebug(true); // 메일을 전송할 때 상세한 상황을 콘솔에 출력한다.
            MimeMessage msg = new MimeMessage(session);
 
            msg.setSubject("[와이낫] 링크를 클릭해 회원가입을 완료해주세요!");
            Address fromAddr = new InternetAddress("master1whytnot@gmail.com"); // 보내는사람 EMAIL
            msg.setFrom(fromAddr);
            Address toAddr = new InternetAddress(id);    // 받는사람 EMAIL DB에서 해당 이메일 주소 불러옴
            msg.addRecipient(Message.RecipientType.TO, toAddr);
            msg.setContent(
            		"새로운 배움에 목마른 당신! 반갑습니다!\n\n"+
            		"계정 활성화를 위해 아래의 링크를 클릭해 주시면 가입이 완료됩니다!\n\n"+
            		"http://localhost:8080/WhyNot/authOk.member?auth="+tokenKey+"&id="+id,
            		"text/plain;charset=KSC5601"); //메일 전송될 내용
            Transport.send(msg);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private static class senderAccount extends javax.mail.Authenticator {
 
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("master1whynot", "ktiuwrcnqokqhdsk"); // @gmail.com 제외한 계정 ID, PASS
 
        }
    }
}