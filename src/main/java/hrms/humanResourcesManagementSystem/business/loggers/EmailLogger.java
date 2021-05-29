package hrms.humanResourcesManagementSystem.business.loggers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import hrms.humanResourcesManagementSystem.business.abstracts.EmailService;

@Component("EmailSender")
public class EmailLogger implements EmailService{

	@Autowired
	private JavaMailSender emailSender;

	@Override
	public void sendSimpleMessage(String from, String to, String subject, String text) {

		
//		TODO: Java'da fonksiyon parametrelerine nasıl default değerler verilebileceği araştırılacak, henüz araştırılmadı.

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);

	}
	
	@Override
	public void sendSimpleMessage(String to, String subject, String text) {

		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);

	}
	
	
}