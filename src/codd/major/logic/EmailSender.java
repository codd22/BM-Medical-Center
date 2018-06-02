package codd.major.logic;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender
{
	//----------------
	public static boolean sendmail(String from,String password,String sub1,String message,String[] to)
    {
        String host="smtp.gmail.com";
        Properties pro=System.getProperties();
        pro.put("mail.smtp.starttls.enable","true");
        pro.put("mail.smtp.host",host);
        pro.put("mail.smtp.user",from);
        pro.put("mail.smtp.password",password);
        pro.put("mail.smtp.port",587);
        pro.put("mail.smtp.auth","true");
        Session session=Session.getDefaultInstance(pro,null);
        MimeMessage mimeMessage=new MimeMessage(session);
        try
        {
            mimeMessage.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress=new InternetAddress[to.length];
            for(int i=0;i<to.length;i++)
            {
                toAddress[i]=new InternetAddress(to[i]);
            }
            for(int i=0;i<toAddress.length;i++)
            {
            mimeMessage.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            mimeMessage.setSubject(sub1);
            mimeMessage.setText(message);
            Transport transport=session.getTransport("smtp");
            transport.connect(host,from,password);
            transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
            transport.close();
            return true;
        }catch(MessagingException me)
        {
         System.out.println("error1"+me.getMessage());
         return false;
        }
    }
	//----------------
}
