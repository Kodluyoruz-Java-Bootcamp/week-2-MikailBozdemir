package medium.model;

import java.util.List;

public class MediumUser {
	private int id;
	private String name;
	private String email;
	private List<MediumUser> followed;
	private List<Blog> blog;

	public MediumUser(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<MediumUser> getFollowed() {
		return followed;
	}

	public void setFollowed(List<MediumUser> followed) {
		this.followed = followed;
	}

	public List<Blog> getBlog() {
		return blog;
	}

	public void setBlog(List<Blog> blog) {
		this.blog = blog;
	}

}
