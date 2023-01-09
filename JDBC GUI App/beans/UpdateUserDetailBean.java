package beans;

public class UpdateUserDetailBean {
  private int id;
  private String name,pass;
  public  UpdateUserDetailBean(int id, String name,String pass) {
	  this.id=id;
	  this.name=name;
	  this.pass=pass;
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
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
  
  
}
