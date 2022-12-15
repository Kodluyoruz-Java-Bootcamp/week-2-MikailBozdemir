package emlakcepte.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {

	private String name;
	private String mail;
	private String password;
	private UserType type;
	private List<Realty> favoriteRealtyList;
	private List<Message> messages;
	private LocalDateTime createDate;
	  List<Realty> realtyList =new ArrayList<>() ;
	
   

	/********************************************** Singleton Pattern*******************************/
		
		  private static User user = new User();
		  
		  private User() {
		  
		  }
		  
		  public static User getUserInstance() 
		  { 
			  
			  return new User();
		  }
		  
	
		 
	/************************************************************************************************/
	public  void User(String name, String mail, String password, UserType type) {
		
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.type = type;
	
	}
   
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public List<Realty> getRealtyList() {
		return realtyList;
	}

	public void setRealtyList(Realty realty) {
		this.realtyList.add(realty);
	}

	public List<Realty> getFavoriteRealtyList() {
		return favoriteRealtyList;
	}

	public void setFavoriteRealtyList(List<Realty> favoriteRealtyList) {
		this.favoriteRealtyList = favoriteRealtyList;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", mail=" + mail + ", password=" + password + ", type=" + type + "createDate="
				+ createDate + "]";
	}

}
