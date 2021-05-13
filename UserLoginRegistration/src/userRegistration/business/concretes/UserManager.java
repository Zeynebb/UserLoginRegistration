package userRegistration.business.concretes;

import userRegistration.business.abstracts.UserService;
import userRegistration.core.abstracts.EmailCheckService;
import userRegistration.core.abstracts.EmailSendService;
import userRegistration.core.abstracts.LoginService;
import userRegistration.dataAccess.abstracts.UserDao;
import userRegistration.entities.concretes.User;

public class UserManager implements UserService {
	private EmailCheckService emailCheckService;
	private LoginService loginService;
	private UserDao userDao;
	private EmailSendService emailSendService;

	public UserManager(LoginService loginService, UserDao userDao, EmailCheckService emailCheckService,
			EmailSendService emailSendService) {
		this.loginService = loginService;
		this.userDao = userDao;
		this.emailCheckService = emailCheckService;
		this.emailSendService = emailSendService;
	}

	@Override
	public void login(User user) {
		if (emailCheckService.emailCheck(user.getEmail()) && emailIsItUsed(user.getEmail())!=true && user.getPassword()!=null) {
			this.loginService.loginToSystem(user);
		} else {
			System.out.println(user.getFirstName()+" "+user.getLastName()+" isimli kullanýcýnýn giriþi baþarýsýz!");
		}
	}

	@Override
	public void register(User user) {
		if (emailCheckService.emailCheck(user.getEmail()) && user.getFirstName().length() >= 2
				&& user.getLastName().length() >= 2 && user.getPassword().length() >= 6
				&& emailIsItUsed(user.getEmail())) {
			this.loginService.registerToSystem(user);
			this.userDao.add(user);
			this.userDao.addEmail(user);
			this.emailSendService.emailSend(user.getEmail());
		} else {
			System.out.println(user.getFirstName()+" "+user.getLastName()+" isimli kullanýcýnýn kaydý baþarýsýz!");
		}
	}

	@Override
	public boolean emailIsItUsed(String email) {
		boolean result = false;
		if (userDao.getEmail().contains(email)) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

}
