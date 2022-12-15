package emlakcepte.dao;

import java.util.ArrayList;
import java.util.List;

import emlakcepte.model.User;

public class UserDao {

	private static List<User> userList = new ArrayList<>();
	
	
	private static UserDao userDao =new UserDao();


	public static UserDao getNewInstance(){
		return  userDao;
	}
	
	private UserDao()
	{
		
	}


	public void createUser(User user) {
		userList.add(user);
		System.out.println("user oluştu");
	}

	public List<User> findAllUsers() {
		return userList;
	}

}
