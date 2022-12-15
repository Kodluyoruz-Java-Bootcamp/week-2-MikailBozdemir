package emlakcepte.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.dao.RealtyDao;
import emlakcepte.model.Durum;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyType;
import emlakcepte.model.Type;
import emlakcepte.model.User;
import emlakcepte.model.UserType;

@Service
public class RealtyService {

	private RealtyDao realtyDao = RealtyDao.getNewInstance();
	
	private static RealtyService realtyService = new RealtyService();

	private RealtyService() {

	}

	public static RealtyService getInstance() {
		return realtyService;
	}
	
	

	@Autowired // injection
	private UserService userService;
	
	 


	public void createRealty(Realty realty) {

		 //userService.printAllUser();
		/***************  Bireysel Kulanıcılar Sadece Konut türünden ve 3 ilan verebilir**********************/
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType()) && Type.KONUT.equals(realty.getType())) 
		{

			
			if(realty.getUser().getRealtyList().size()<3)
			{
		       realty.getUser().setRealtyList(realty);
               realty.getUser().getRealtyList().forEach(realtyList -> System.out.println(realtyList+"sahibi "+ realty.getUser().getName()));
		   	   realtyDao.saveRealty(realty);	
			}
				
			
			
		} 
		/****************************************************************************************/
		
		else if (!UserType.INDIVIDUAL.equals(realty.getUser().getType())) {
			realtyDao.saveRealty(realty);
			 realty.getUser().setRealtyList(realty);
			System.out.println("createRealty :: " + realty.getTitle());
			System.out.println("bireysel olmayan kullanıcılar ile ilgili bir kural yok");

		}

		// System.out.println("Bireysel kullanıclar en fazla 5 ilan girebilir.");

	}

	public List<Realty> getAll() {
		return realtyDao.findAll();
	}

	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}

	public void getAllByProvince(String province) {
		getAll().stream().filter(realty -> realty.getProvince().equals(province))
		.forEach(realty -> System.out.println(realty));

	}
	public void getByFilter(String province1,String province2,String province3,Durum durum)
	{
		getAll().stream().filter(realty -> realty.getProvince().equals(province1)||realty.getProvince().equals(province2)||realty.getProvince().equals(province3))
		.filter(realty -> realty.getDurum().equals(durum))
		.forEach(realty -> System.out.println(realty));
		
	}

	public void getAllByDistricte(String district) {
		getAll().stream().filter(realty -> realty.getDistrict().equals(district))
				.forEach(realty -> System.out.println(realty));

	}

	public List<Realty> getAllByUserName(User user) {
		return getAll().stream().filter(realty -> realty.getUser().getMail().equals(user.getMail())).toList();
	}

	public List<Realty> getActiveRealtyByUserName(User user) {

		return getAll().stream().filter(realty -> realty.getUser().getName().equals(user.getName()))
				.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus())).toList();

	}

}
