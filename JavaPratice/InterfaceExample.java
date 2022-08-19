interface Base{
    void show();
    //non-abstract method inside the inteface
    default void display(){
         System.out.println("display method of Base interface ");
    }
}
class Child implements Base{
   //here the method should be public because inside interface all data members and method are public by default  
    public void show(){
      System.out.println("show method overrloded ");
    }
}
public class InterfaceExample {
  public static void main(String[] args) {
    //dynamic binding
    Base b = new Child();
    b.display();
    b.show();

  }    
}
