

  import java.util.*;
  import javax.mail.*;
  import javax.mail.internet.*;
  import javax.activation.*;

  public class SendEmail {

     public static void main(String [] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "abcd@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "web@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
           // Create a default MimeMessage object.
           MimeMessage message = new MimeMessage(session);

           // Set From: header field of the header.
           message.setFrom(new InternetAddress(from));

           // Set To: header field of the header.
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

           // Set Subject: header field
           message.setSubject("This is the Subject Line!");

           // Now set the actual message
           message.setText("This is actual message");

           // Send message
           Transport.send(message);
           System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
           mex.printStackTrace();
        }
}
  }



=======
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Test {
	public static void main(String args []) {
		DBcon.loadBasicEmployees();
		//System.out.println("Loaded BASIC EMPLOYEES");
		Date birthDate = new Date();
		Department dep = new Department("Sales");
		System.out.println("Created DEPARTMENT");
		Employee emp = new BasicEmployee("vasilis", "Xifaras", "6942796775", "alcabilone@gmail.com", birthDate, 1);
		System.out.println("Created BASIC EMPLOYEE");
	}
 } 
