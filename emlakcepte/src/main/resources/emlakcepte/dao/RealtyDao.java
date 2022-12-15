package emlakcepte.dao;

import java.util.ArrayList;
import java.util.List;

import emlakcepte.model.Realty;

public class RealtyDao {
	private static RealtyDao realtyDao =new RealtyDao();
	
	private RealtyDao()
	{
		
	}
	
	public static RealtyDao getNewInstance()
	{
		return realtyDao;
		
	}


	private static List<Realty> realtyList = new ArrayList<>();

	public void saveRealty(Realty realty) {
		realtyList.add(realty);
		System.out.println(realtyList);
		System.out.println("realtydao kaydetti");
	}

	public List<Realty> findAll() {
		
		return realtyList;
		
	}

}
