package userRegistration.core.abstracts;

public interface EmailCheckService {
	public boolean emailCheck(String email);
	public void getVerificationLink(String email);
	

}
