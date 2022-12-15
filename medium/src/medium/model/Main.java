package medium.model;

import medium.service.Userservice;

public class Main {

	public static void main(String[] args) {
		
		Userservice userService =Userservice.getNewInstance();
      
		User user1=new User(1, "mikail", "mikailbozdemir@gmail.com");
		User user2=new User(2, "ali.soz", "sozali@gmail.com");
		User user3=new User(3, "güneyakın", "güney17@gmail.com");
		User user4=new User(4, "selimateş", "selimateş@gmail.com");
		userService.saveUser(user1);
		userService.saveUser(user2);
		userService.saveUser(user3);
		userService.saveUser(user4);
		
		userService.getAllUser();
		
		
		Blog blog1=new Blog(1, "javada değişkenler", "javada değişkenler temel olarak ...", "#java");
		Blog blog2=new Blog(2, "Divan edebiyatı", "17.yüzyılın sonlarında ...", "#java");
		Blog blog3=new Blog(3, "javada değişkenler", "javada değişkenler temel olarak ...", "#java");
		Blog blog4=new Blog(4, "java", "javada ", "#java");
		
		
		
		
		
		

	}

}
