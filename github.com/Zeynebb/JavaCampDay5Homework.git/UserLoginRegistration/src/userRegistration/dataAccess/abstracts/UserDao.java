package userRegistration.dataAccess.abstracts;

import java.util.List;

import userRegistration.entities.concretes.User;

public interface UserDao {
	public void add(User user);
	public void delete(User user);
	public void update(User user);
	
	public void addEmail(User user);
	public List<String> getEmail();
	
	

}
