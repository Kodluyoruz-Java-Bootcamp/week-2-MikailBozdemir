package emlakcepte.model;

import java.time.LocalDateTime;

public class Realty {

	private Long no;
	private String title;
	private LocalDateTime publishedDate;
	private User user;
	private RealtyType status;
	private Type type;
	private String province=" ";
	private String district ="";
	private Durum durum;

	
	private static Realty realty = new Realty();

	private Realty() {
	}

	public static Realty getInstance() {
		return new Realty();
	}
	
	
	public Durum getDurum() {
		return durum;
	}

	public void setDurum(Durum durum) {
		this.durum = durum;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public  void Realty(Long no, String title, LocalDateTime publishedDate, User user, RealtyType status,String district,Type type, String province,Durum durum) {
		
		this.no = no;
		this.title = title;
		this.publishedDate = publishedDate;
		this.user = user;
		this.status = status;
		this.district=district;
		this.type=type;
		this.province=province;
		this.durum=durum;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDateTime publishedDate) {
		this.publishedDate = publishedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RealtyType getStatus() {
		return status;
	}

	public void setStatus(RealtyType status) {
		this.status = status;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Realty [no=" + no + ", title=" + title + ", publishedDate=" + publishedDate + ", user=" + user
				+ ", status=" + getStatus() + ", province=" + province +   " ,district ="+getDistrict() +" ,type  ="+getType()+ " durumu"+ getDurum() +"]" ;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
