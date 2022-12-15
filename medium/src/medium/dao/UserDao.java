package medium.dao;

import java.util.ArrayList;
import java.util.List;

import medium.model.Blog;
import medium.model.User;

public class UserDao {
	
	private List <User> userList=new ArrayList<>();
	private List<User> followingUserList=new ArrayList<>();
	private List<Blog> followingBlogList=new ArrayList<>();
	
	  private static UserDao userDao =new UserDao();
		 
		 private UserDao() {}
		 
		 public  static UserDao getNewInstance() {
			 
			 return userDao;
		 }
	
	public void createUser( User user)
	{
		if(!userList.contains(user))
		{
			userList.add(user);
			
		}
		
	}
	public void followBlogByTag(Blog blog )
	{
		if(!followingBlogList.contains(blog))
		{
			followingBlogList.add(blog);
			
		}
	}
	
	public void follow(User user) {
		
		if (!followingUserList.contains(user))
		{
			
			followingUserList.add(user);
		}
	}

	public void getUser() {
		userList.stream().forEach(User->System.out.println(User.getName()));
		
	}

}
