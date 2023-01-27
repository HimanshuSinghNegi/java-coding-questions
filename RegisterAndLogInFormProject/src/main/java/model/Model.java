package model;

public class Model {
    private String name;
    private String email;
    private String pass;
    private String pNo;
    private String address;
    private String [] remMe;
    
	public Model(String name, String email, String pass, String pNo, String address, String[] remMe) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.pNo = pNo;
		this.address = address;
		this.remMe = remMe;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getRemMe() {
		return remMe;
	}

	public void setRemMe(String[] remMe) {
		this.remMe = remMe;
	}
	
	
    
    
}
