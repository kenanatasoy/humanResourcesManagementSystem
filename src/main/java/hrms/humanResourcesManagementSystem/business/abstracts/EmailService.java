package hrms.humanResourcesManagementSystem.business.abstracts;

public interface EmailService {
	void sendSimpleMessage(String from, String to, String subject, String text);
	void sendSimpleMessage(String to, String subject, String text);
}
