package userRegistration;

import userRegistration.business.abstracts.UserService;
import userRegistration.business.concretes.UserManager;
import userRegistration.core.abstracts.EmailCheckService;
import userRegistration.core.abstracts.EmailSendService;
import userRegistration.core.abstracts.LoginService;
import userRegistration.core.concretes.EmailCheckManager;
import userRegistration.core.concretes.EmailSendManagerAdapter;
import userRegistration.core.concretes.GoogleManagerAdapter;
import userRegistration.dataAccess.abstracts.UserDao;
import userRegistration.dataAccess.concretes.AbcUserDao;
import userRegistration.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User zeyneb = new User("Zeyneb Eda", "YILMAZ", "123456", "zey@hotmail.com");
		User zeyneb2 = new User("abc", "def", "123456", "zey@hotmail.com");		
		User engin = new User("Engin", "Demiroð", "123456", "engin@gmail.com");
		User eda = new User("Eda", "YILMAZ", "123456", "eda@hotmail.com");
		UserDao userDao = new AbcUserDao();

		EmailSendService emailSendService=new EmailSendManagerAdapter();
		EmailCheckService emailCheckService=new EmailCheckManager();
		LoginService googleService = new GoogleManagerAdapter();
		UserService userService = new UserManager(googleService, userDao, emailCheckService, emailSendService);
		userService.register(zeyneb);
		userService.register(engin);
		userService.register(zeyneb2);
		emailCheckService.getVerificationLink(zeyneb.getEmail());
		emailCheckService.getVerificationLink(engin.getEmail());
		
		userService.login(zeyneb);
		userService.login(engin);
		userService.login(eda);
		

	}

}
