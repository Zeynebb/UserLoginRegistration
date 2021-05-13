package userRegistration.business.abstracts;

import userRegistration.entities.concretes.User;

public interface UserService {
	
	public void login(User user);
	public void register(User user);
	public boolean emailIsItUsed(String email);
}
