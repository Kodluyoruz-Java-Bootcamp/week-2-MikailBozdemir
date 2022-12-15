package emlakcepte;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import emlakcepte.dao.UserDao;
import emlakcepte.model.Durum;
import emlakcepte.model.Message;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyType;
import emlakcepte.model.Type;
import emlakcepte.model.User;
import emlakcepte.model.UserType;
import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;
import medium.model.Blog;
import medium.model.MediumUser;
import medium.service.MediumUserservice;

public class Main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

		/********************************************** Singleton Pattern*******************************/
		/**********Tüm yeni objeler singelton  ve factory patterne göre üretildi***********************************/
		
		User userPelin = User.getUserInstance();
		userPelin.User("pelin", "pelin@gmail.com", "1245", UserType.INDIVIDUAL);
		
		User userSami = User.getUserInstance();
		userSami.User("Sami", "sami@gmail.com", "123", UserType.INDIVIDUAL);
       
        User userBozGayrimenkul =User.getUserInstance();
        userBozGayrimenkul.User("BozGayrimenkul", "bozemlak@gmail.com", "533687", UserType.CORPARETE);
        
        /***************************************************************************************************/
		
		UserService userService = applicationContext.getBean(UserService.class);

		userService.createUser(userPelin);
		userService.createUser(userSami);
		userService.createUser(userBozGayrimenkul);

		userService.printAllUser();

		System.out.println("-----");

		// userList.add(user);
		// userList.add(userPelin);

		// userList.forEach(usr -> System.out.println(usr.getName()));

		RealtyService realtyService = RealtyService.getInstance();

		Realty realty1 = Realty.getInstance();
		realty1.Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık  apartman", LocalDateTime.now(), userBozGayrimenkul,RealtyType.ACTIVE, "kadıköy",Type.KONUT,    "İstanbul",Durum.SATILIK);
		
	
		Realty realty2 = Realty.getInstance();
		realty2.Realty(125L, "AKSARAY' de 1200 M2 kiralık daire", LocalDateTime.now(), userBozGayrimenkul, RealtyType.ACTIVE,
				"kadıköy", Type.APARTMAN, "Malatya",Durum.KIRALIK);

		Realty realty3 = Realty.getInstance();
		realty3.Realty(125L, "KADIKÖY ' de 1200 M2 Satılık müstakil ev", LocalDateTime.now(), userSami,
				RealtyType.ACTIVE, "kadıköy", Type.KONUT, "İstanbul",Durum.SATILIK);

		Realty realty4 = Realty.getInstance();
		realty4.Realty(126L, "new york ' de 1200 M2 forsale dublex ", LocalDateTime.now(), userPelin, RealtyType.ACTIVE,
				"beverhills", Type.KONUT, "İstanbul",Durum.KIRALIK);

		Realty realty5 = Realty.getInstance();
		realty5.Realty(125L, "FATİHDE ' de 1200 M2 Kiralık VİLLA", LocalDateTime.now(), userPelin, RealtyType.ACTIVE,
				"kadıköy", Type.İŞMERKEZİ, "İstanbul",Durum.KIRALIK);

		Realty realty6 = Realty.getInstance();
		realty6.Realty(125L, "çankaya' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userSami, RealtyType.ACTIVE,
				"kadıköy", Type.KONUT, "Ankara",Durum.SATILIK);

		Realty realty7 = Realty.getInstance();
		realty7.Realty(125L, "Satılık VİLLA", LocalDateTime.now(), userSami, RealtyType.ACTIVE,
				"alsancak", Type.KONUT, "İzmir",Durum.SATILIK);

		Realty realty8 = Realty.getInstance();
		realty8.Realty(130L, "kiralık VİLLA", LocalDateTime.now(), userSami, RealtyType.ACTIVE,
				"göztepe", Type.KONUT, "İstanbul",Durum.KIRALIK);

		Realty realty9 = Realty.getInstance();
		realty9.Realty(131L, "akmurat' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userPelin, RealtyType.ACTIVE,
				"kadıköy", Type.KONUT, "İstanbul",Durum.SATILIK);

		Realty realty10 = Realty.getInstance();
		realty10.Realty(132L, "akmurat' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userBozGayrimenkul, RealtyType.ACTIVE,
				"esenler", Type.KONUT, "İstanbul",Durum.SATILIK);

		Realty realty11 = Realty.getInstance();
		realty11.Realty(133L, "akmurat' de 1200 M2 kiralık VİLLA", LocalDateTime.now(), userPelin, RealtyType.ACTIVE,
				"çankaya", Type.KONUT, "ankara",Durum.KIRALIK);
		
		
/**********************************  Bireysel Kulanıcılar Sadece Konut türünden ilan verebilir*******************************************************/
	    realtyService.createRealty(realty1);
		realtyService.createRealty(realty2);	
		realtyService.createRealty(realty3);	
		realtyService.createRealty(realty4);
		realtyService.createRealty(realty5);
		realtyService.createRealty(realty6);
		realtyService.createRealty(realty7);
		realtyService.createRealty(realty8);
		realtyService.createRealty(realty9);
		realtyService.createRealty(realty10);
		realtyService.createRealty(realty11);

	
		
		/**************************filtreli arama****************************************************/
		System.out.println("filtreli arama");
	    realtyService.getByFilter("Ankara", "İstanbul", "İzmir", Durum.SATILIK)	;
  
		
		//userSami.setRealtyList(List.of(realty, realty9));

		List<Realty> fovarilerim = new ArrayList<>();
		//fovarilerim.add(favori1);
		userSami.setFavoriteRealtyList(fovarilerim);
		

		/*************************** sistemdeki bütün ilanlar********************************/

		//System.out.println("Bütün ilanlar");

		//realtyService.printAll(realtyService.getAll());

		/********** İstanbuldaki ilanların bulunması****************************/

	 /*   System.out.println("İstanbul'daki ilanlar");

		realtyService.getAllByProvince("İstanbul");*/

		/*************************************** Bir kullanıcının bütün ilanlarını listele****************/
		//realtyService.printAll(realtyService.getAllByUserName(userPelin));

		//realtyService.printAll(realtyService.getActiveRealtyByUserName(userSami));

		/*
		 * userList.forEach(usr -> {
		 * 
		 * usr.getFavoriteRealtyList().forEach(favoriRealty ->
		 * System.out.println(favoriRealty.getTitle()) );
		 * 
		 * });
		 */
		
		
		/****************** İlçe Bazlı Arama   İl Bazlı Arama Zaten Mevcuttu  ***********************/
		System.out.println("kadıköydeki  ilanlar");
		realtyService.getAllByDistricte("kadıköy");
		
		System.out.println("İstanbul'daki ilanlar");
		realtyService.getAllByProvince("İstanbul");
		/*********************************************************************************************/
		System.out.println("tüm ilanlar");
		  realtyService.getAll().stream().forEach(realtyList-> System.out.println(realtyList));
		
		
		System.out.println("pelinin ilanları");
		userPelin.getRealtyList().forEach(realtyList -> System.out.println(realtyList));
		System.out.println("saminin ilanları");
		userSami.getRealtyList().forEach(realtyList -> System.out.println(realtyList));
		
		/****************************************************************************/

		Message message = new Message("acil dönüş", "ilan ile ilgili bilgilendirme verebilir misiniz?", userPelin,
				userSami);

		userSami.setMessages(List.of(message));
		userPelin.setMessages(List.of(message));

		userSami.getMessages();
		/*********************************** MEDİUM*******************************/
		
		
		MediumUserservice userService1 =MediumUserservice.getNewInstance();
      
		MediumUser user1=new MediumUser(1, "mikail", "mikailbozdemir@gmail.com");
		MediumUser user2=new MediumUser(2, "ali.soz", "sozali@gmail.com");
		MediumUser user3=new MediumUser(3, "güneyakın", "güney17@gmail.com");
		MediumUser user4=new MediumUser(4, "selimateş", "selimateş@gmail.com");
		userService1.saveUser(user1);
		userService1.saveUser(user2);
		userService1.saveUser(user3);
		userService1.saveUser(user4);
		
		userService1.getAllUser();
		
		
		Blog blog1=new Blog(1, "javada değişkenler", "javada değişkenler temel olarak ...", "#java");
		Blog blog2=new Blog(2, "Divan edebiyatı", "17.yüzyılın sonlarında ...", "#java");
		Blog blog3=new Blog(3, "javada değişkenler", "javada değişkenler temel olarak ...", "#java");
		Blog blog4=new Blog(4, "java", "javada ", "#java");
		
		
		
		/*********************************** MEDİUM*******************************/
	}

	

	
	
	
	
	

}
