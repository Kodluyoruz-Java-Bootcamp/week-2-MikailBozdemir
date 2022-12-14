package medium.dao;

import java.util.ArrayList;
import java.util.List;

import medium.model.Blog;
import medium.model.MediumUser;

public class MediumUserDao {
	
	private List <MediumUser> userList=new ArrayList<>();
	private List<MediumUser> followingUserList=new ArrayList<>();
	private List<Blog> followingBlogList=new ArrayList<>();
	
	  private static MediumUserDao userDao =new MediumUserDao();
		 
		 private MediumUserDao() {}
		 
		 public  static MediumUserDao getNewInstance() {
			 
			 return userDao;
		 }
	
	public void createUser( MediumUser user)
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
	
	public void follow(MediumUser user) {
		
		if (!followingUserList.contains(user))
		{
			
			followingUserList.add(user);
		}
	}

	public void getUser() {
		userList.stream().forEach(User->System.out.println(User.getName()));
		
	}

}
