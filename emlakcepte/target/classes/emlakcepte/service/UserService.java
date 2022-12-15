package emlakcepte.service;

import java.util.List;

import emlakcepte.dao.UserDao;
import emlakcepte.model.User;

public class UserService {

	UserDao userDao = UserDao.getNewInstance();

	
	public void createUser(User user) {
		// UserDao userDao = new UserDao(); tekrar tekrar oluşturmamıza gerek yok
		//System.out.println("ben bir userDao objesiyim:" + userDao.toString());

		if (user.getPassword().length() < 5) {
			//System.out.println("Şifre en az 5 karakterli olmalı");
		}
		userDao.createUser(user);
	}

	public List<User> getAllUser() {
		// UserDao userDao = new UserDao();
		return userDao.findAllUsers();
	}

	public void printAllUser() {

		getAllUser().forEach(user -> System.out.println(user.getName()));

	}

	public void updatePassword(User user, String newPassword) {
		// önce hangi user bul ve passwordü update et.
	}

}
