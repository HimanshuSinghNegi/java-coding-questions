//Note :- Comparable is inside "javja.lang" package
import java.util.Set;
import java.util.TreeSet;
//TreeSet :- it contains values or objects in sorted order
// you can't store objects which doesn't implement "comparable" interface in Treeset because it uses compareTo() for sorting purpose
//Note :-  you want to add userdefined datatype in Treeset then, that userdefined datatype should implement "Comparable" interface
// And, should override compareTo() and toString()
class Employee implements Comparable{
    int id;
    String name,address;

    Employee(int id, String name, String address){
        this.id=id;
        this.name=name;
        this.address=address;
    }

    //override "compareTo()"
    public int compareTo(Object o){
        Employee emp = (Employee)o;
        if(this.id>emp.id)
        return 1;
        else if(this.id<emp.id)
         return -1;
         else
          return 0;
    }
    //overriding toString()
    public String toString(){
        return id +" "+name+" "+address;
    }
}

public class TreeSetDemo {
    public static void main(String[] args) {
       Employee e1 = new Employee(10, "Himanshu", "Shivrajpur");
       Employee e2 = new Employee(20, "Himanshu1", "Shivrajpur1");
       Employee e3 = new Employee(10, "Himanshu", "Shivrajpur");
       Employee e4 = new Employee(70, "Himanshu2", "Shivrajpur2");
       Set set = new TreeSet();
       set.add(e1);
       set.add(e2);
       set.add(e3);
       set.add(e4);
       System.out.println(set); 
    }
}
