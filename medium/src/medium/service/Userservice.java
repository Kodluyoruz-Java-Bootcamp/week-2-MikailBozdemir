package medium.service;

import medium.dao.UserDao;
import medium.model.Blog;
import medium.model.User;

public class Userservice {
	 UserDao userDao=UserDao.getNewInstance();
	 
	 
	 private static Userservice userService =new Userservice();
	 
	 private Userservice() {}
	 
	 public  static Userservice getNewInstance() {
		 
		 return userService;
	 }
	 
	
		public void follow(User user) {
			userDao.follow(user);
		}

		public void followBlog(Blog blog) {
			userDao.followBlogByTag(blog);

		}

		public void saveUser(User user) {
			userDao.createUser(user);
		}
		public void getAllUser()
		{
			
			userDao.getUser();
		}
}
