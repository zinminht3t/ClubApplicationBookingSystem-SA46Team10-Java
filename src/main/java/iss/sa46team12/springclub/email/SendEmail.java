package iss.sa46team12.springclub.email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SendEmail {
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String from, String to, String subject, String msg) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
	}

	public static void sendEmail(String from, String to, String subject, String msg) {

		ApplicationContext context = new ClassPathXmlApplicationContext("mail/mailer.xml");

		SendEmail mm = (SendEmail) context.getBean("SendEmail");
		mm.sendMail(from, to, subject, msg);
	}

}
