package userRegistration.core.concretes;

import userRegistration.core.abstracts.EmailSendService;
import userRegistration.emailService.EmailSendManager;

public class EmailSendManagerAdapter implements EmailSendService{
	private EmailSendManager emailSendManager;

	@Override
	public void emailSend(String email) {
		emailSendManager =new EmailSendManager();
		emailSendManager.emailSending(email);
	}
	

}
