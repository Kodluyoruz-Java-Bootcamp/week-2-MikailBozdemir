package medium.model;

public class Blog {
	private int id;
	private String title;
	private String context;
	private String tag;

	public Blog(int id, String title, String context, String tag) {
		super();
		this.id = id;
		this.title = title;
		this.context = context;
		this.tag = tag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
