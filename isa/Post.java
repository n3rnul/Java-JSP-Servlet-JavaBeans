package jp.isa;

public class Post {

	private String postcode;
	private String postname;
	
	public Post(String postcode, String postname) {
		super();
		
		this.postcode = postcode;
		this.postname = postname;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

}
