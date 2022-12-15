package medium.service;

import medium.dao.MediumUserDao;
import medium.model.Blog;
import medium.model.MediumUser;

public class MediumUserservice {
	 MediumUserDao userDao=MediumUserDao.getNewInstance();
	 
	 
	 private static MediumUserservice userService =new MediumUserservice();
	 
	 private MediumUserservice() {}
	 
	 public  static MediumUserservice getNewInstance() {
		 
		 return userService;
	 }
	 
	
		public void follow(MediumUser user) {
			userDao.follow(user);
		}

		public void followBlog(Blog blog) {
			userDao.followBlogByTag(blog);

		}

		public void saveUser(MediumUser user) {
			userDao.createUser(user);
		}
		public void getAllUser()
		{
			
			userDao.getUser();
		}
}
