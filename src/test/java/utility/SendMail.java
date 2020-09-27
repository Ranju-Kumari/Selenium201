package utility;

import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendMail {
	
	public SendMail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void mailTrigering() {
			SendMail sm=new SendMail();
			Properties prop=new Properties();
			EmailAttachment attachment = new EmailAttachment();
			
			attachment.setPath(ExtentReport.path);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("my extent report");
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("ranju@gmail.com","0987654321"));
			email.setStartTLSEnabled(true);
			try {
				email.setFrom("ranju@gmail.com");
			} catch (EmailException e) {
				e.printStackTrace();
			}
			email.setSubject("TestMail");
			try {
				email.setMsg("This is a test mail ... :-)");
			} catch (EmailException e) {
				e.printStackTrace();
			}
			try {
				email.addTo("ranju.k@mindtree.com");
			} catch (EmailException e) {
				e.printStackTrace();
			}
			try {
				email.attach(attachment);
			} catch (EmailException e) {
				e.printStackTrace();
			}
			try {
				email.send();
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}
	}
