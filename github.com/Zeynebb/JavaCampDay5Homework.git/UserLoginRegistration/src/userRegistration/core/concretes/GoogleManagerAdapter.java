package userRegistration.core.concretes;

import userRegistration.core.abstracts.LoginService;
import userRegistration.entities.concretes.User;
import userRegistration.googleService.GoogleLoginManager;
import userRegistration.googleService.GoogleRegisterManager;

public class GoogleManagerAdapter implements LoginService {

	private GoogleLoginManager googleLoginManager;
	private GoogleRegisterManager googleRegisterManager;

	@Override
	public void registerToSystem(User user) {
		googleRegisterManager = new GoogleRegisterManager();
		googleRegisterManager.register(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail());

	}

	@Override
	public void loginToSystem(User user) {
		googleLoginManager = new GoogleLoginManager();
		this.googleLoginManager.login(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail());
	}

}
