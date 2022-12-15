package medium.dao;

import java.util.ArrayList;
import java.util.List;

import medium.model.Blog;
import medium.service.BlogService;

public class BlogDao {

	private static List<Blog> publishedBlog = new ArrayList<>();
	private static List<Blog> savedBlog = new ArrayList<>();
	
	  private static BlogDao blogDao =new BlogDao();
		 
		 private BlogDao() {}
		 
		 public  static BlogDao getNewInstance() {
			 
			 return blogDao;
		 }
		

	public void add(Blog blog) {
		publishedBlog.add(blog);
	}
   
	public void save(Blog blog) {
		savedBlog.add(blog);

	}
	public void delete(Blog blog) {

		if (savedBlog.contains(blog)) 
		{

			savedBlog.remove(blog);
		} 
		
		else if (publishedBlog.contains(blog)) {
			publishedBlog.remove(blog);

		}

	}


}
