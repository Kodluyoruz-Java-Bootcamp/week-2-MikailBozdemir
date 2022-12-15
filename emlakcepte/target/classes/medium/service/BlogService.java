package medium.service;

import medium.dao.BlogDao;
import medium.model.Blog;

public class BlogService {
	
   BlogDao blogDao=BlogDao.getNewInstance();
   private static BlogService blogService =new BlogService();
	 
	 private BlogService() {}
	 
	 public  static BlogService getNewInstance() {
		 
		 return blogService;
	 }
	
   public void publishBlog( Blog blog)
   {
       blogDao.add(blog);
   }
   
   public void saveBlog( Blog blog)
   {
       blogDao.save(blog);
   }
   public void delete(Blog blog )
   {
	   blogDao.add(blog);
	   
   }
}
