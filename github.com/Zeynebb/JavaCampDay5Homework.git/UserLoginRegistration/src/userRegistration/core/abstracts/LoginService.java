package userRegistration.core.abstracts;

import userRegistration.entities.concretes.User;

public interface LoginService {
	public void loginToSystem(User user);
	
	public void registerToSystem(User user);

}
