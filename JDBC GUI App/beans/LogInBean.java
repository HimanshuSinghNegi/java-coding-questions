package beans;
//bean class is used to store data into object
public class LogInBean {
   private String name,password;
   public LogInBean(String name, String password){
	 this.name=name;
	 this.password=password;
   }
   
   public String getName() {
	   return name;
   }
   public String getPassword() {
	   return password;
   }
   public void setName(String name) {
	   this.name=name;
   }
   public void setPassword(String password) {
	   this.password=password;
   }
}
