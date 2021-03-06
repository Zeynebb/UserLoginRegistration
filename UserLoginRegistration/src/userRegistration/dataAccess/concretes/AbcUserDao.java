package userRegistration.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import userRegistration.dataAccess.abstracts.UserDao;
import userRegistration.entities.concretes.User;

public class AbcUserDao implements UserDao {
	private List<String> users=new ArrayList<String>();

	@Override
	public void add(User user) {
		System.out
				.println(user.getFirstName() + " " + user.getLastName() + " isimli kullanıcı veritabanına kaydedildi.");
	}

	@Override
	public void delete(User user) {
		System.out
				.println(user.getFirstName() + " " + user.getLastName() + " isimli kullanıcı veritabanından silindi.");
	}

	@Override
	public void update(User user) {
		System.out
				.println(user.getFirstName() + " " + user.getLastName() + " isimli kullanıcının bilgileri güncellendi.");
	}

	@Override
	public void addEmail(User user) {
		users.add(user.getEmail());
	}

	@Override
	public List<String> getEmail() {
		return users;
		
	}

}
