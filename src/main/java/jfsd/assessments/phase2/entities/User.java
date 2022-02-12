package jfsd.assessments.phase2.entities;

public class User {
	private String uname;
	private String fname;
	private String email;
	private String password;

	User() {

	}

	public User(String uname, String fname, String email, String password) {
		this.uname = uname;
		this.fname = fname;
		this.email = email;
		this.password = password;
	}
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validatePassword(String password) {
		return this.password.equals(password);
	}

	@Override
	public String toString() {
		return "User [uname=" + uname + ", fname=" + fname + ", email=" + email + "]";
	}
}
