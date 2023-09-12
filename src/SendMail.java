import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;

public class SendMail implements Serializable{
	//class maintain sending mails and storing the details of the mails.
	private static final long serialVersionUID = 1L;
	String address;
	String subject;
	String content;
	String todayIs;
	
	static ArrayList<SendMail> toSendMails = new ArrayList<SendMail>();
	//set the today's date to the SendMail objects send in the day. 
    public void setDate() {
    	LocalDate dt = LocalDate.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String dateObj = dt.format(formatter);   
        todayIs = dateObj;
    }
    public SendMail(String address, String subject, String content) {
  
    	this.address = address;
    	this.subject = subject;
    	this.content = content;
    	setDate();
    	SendMail.SendingMail(address,subject,content);
    }
    
    //setting the data in the corresponding object and adding to the arraylist.
    static void sendEmail(String mail, String subject, String content) {
    	toSendMails.add(new SendMail(mail,subject,content));
    }

    //method to send emails to the corresponding mail addresses.
    public static void SendingMail(String mail, String subject, String content) {

        final String username = "nadeeshasomarathna44@gmail.com";
        final String password = "abmqkmuqztkwaolc";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("nadeeshasomarathna44@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mail)
            );
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Mail Sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    //gives details of the mails that is already sent.
    void getDetails() {
    	System.out.println("Address :"+address+"\nSubject :"+subject+"\nContent :"+content);
    }
    
    //gives details about the emails in the use input date.
    static void getGivenDateDetails(String givenDate) {
    	for(SendMail mail: toSendMails) {
    		if((mail.todayIs).equals(givenDate)) {
    			mail.getDetails();
    		}
    	}
    }
    
}
