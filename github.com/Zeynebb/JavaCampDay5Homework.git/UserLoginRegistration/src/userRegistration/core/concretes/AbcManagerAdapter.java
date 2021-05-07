package userRegistration.core.concretes;

import userRegistration.abcService.AbcLoginManager;
import userRegistration.abcService.AbcRegisterManager;
import userRegistration.core.abstracts.LoginService;
import userRegistration.entities.concretes.User;

public class AbcManagerAdapter implements LoginService {
	private AbcLoginManager abcLoginManager;
	private AbcRegisterManager abcRegisterManager;

	@Override
	public void registerToSystem(User user) {
		abcRegisterManager = new AbcRegisterManager();
		abcRegisterManager.register(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail());
	}

	@Override
	public void loginToSystem(User user) {
		abcLoginManager = new AbcLoginManager();
		this.abcLoginManager.login(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail());
	}

}
