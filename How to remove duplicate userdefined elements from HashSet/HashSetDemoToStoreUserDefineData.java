import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

//program to remove userdefined  datatype form HashSet, for that you have to override 3 methods of Object class
//1. hashCode()
//2. equals()
//3. toString()



class Employee{
    int id;
    String name,address;
    public Employee(int id, String name,String address){
        this.id=id;
        this.name=name;
        this.address=address;
    }
    //now show()
    void show(){
        System.out.println(id+" "+name+" "+address);
    }
    //overriding hashCode method
    public int hashCode(){
        return id*10;
    }
    //overriding equals method
    public boolean equals(Object o){
        Employee emp = (Employee)o;
        if(emp.id==this.id)
          return true;
        else 
           return false;
        
    }
    //overriding toString()
    public String toString(){
        return id +" "+name+" "+address;
    }

}
class HashSetDemoToStoreUserDefineData{
 public static void main(String[] args) {
     Set<Employee> set = new HashSet<>();
     
     Employee e1 = new Employee(100, "Surya", "GKP");
     Employee e2 = new Employee(200, "Himanshu", "Kot");
     Employee e3 = new Employee(100, "Surya", "GKP");
     set.add(e1);
     set.add(e2);
     set.add(e3);

     //now printing hashSet
     Iterator i = set.iterator();

     while(i.hasNext()){
        Employee emp = (Employee)i.next();
        emp.show();
     }

     //directly print set
     System.out.println(set);
 }
}