import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

//Note :- Here we are using Comparator to sort userdefined data , which removes the limitations of comparable interface
// Here we can sort objects by differnt parameters at the same time
//Note :- Comparator is used so that we can write our "complex code for sorting" in seprate file and "Business logic" in separate file
//for flexibilty of the code 

class Employee {
    int age;
    String name,address;
    Employee(int age , String name, String address){
        this.age= age;
        this.name=name;
        this.address=address;
    }

    //method to show details
    void show(){
        System.out.println(age +" "+ name+" "+address);
    }
}


public class TreeSetDemoWithComparatorDemo {
    public static void main(String[] args) {
      
    Employee e1 = new Employee(10, "Himanshu", "Shivrajpur");
    Employee e2 = new Employee(20, "Mohit", "Kishanpur");
    Employee e3 = new Employee(10, "Rahul", "Up");
    Employee e4 = new Employee(70, "Surya", "Greater Noida");   

    //First we will make comparator object on which basis we want to sort data
    Comparator nameComp= new NameCompare();
    Comparator ageComp = new AgeCompare();
    Comparator addressComp = new AddressCompare();
    
    // Now create TreeSet
      Set set = new TreeSet(ageComp);
       set.add(e1);
       set.add(e2);
       set.add(e3);
       set.add(e4);  

       //here using iterator to show elemets
       Iterator i = set.iterator();
       while(i.hasNext()){
        Employee emp =(Employee)i.next();
        emp.show();
       }
    }
}
