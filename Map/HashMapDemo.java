import java.util.*;
class IdNo{
    int id;
    IdNo(int id){
        this.id=id;
    }
    public String toString(){
        return String.valueOf(id);
    }
  //note :- to remove duplicacy of data
    //override hashcode method
    public int hashCode(){
      return id*10;
    }
    //override equals() method
    public boolean equals(Object o){
        IdNo id = (IdNo)o;
        if(this.id==id.id)
           return true;
        else
         return false;
    }
}
class Employee{
    int age;
    String name;
    Employee(int age, String name){
        this.age=age;
        this.name=name;
    }
  public String toString()
  {
    return age +" "+name;
  }
    
}
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<IdNo,Employee> map = new HashMap<>();
        IdNo id1 =new IdNo(1);
        map.put(id1,new Employee(20, "Himanshu"));
        map.put(new IdNo(2),new Employee(21, "Nitesh"));
        map.put(new IdNo(3),new Employee(22, "Karan"));
        map.put(new IdNo(3),new Employee(22, "Karan"));
        //some methods of HashMap
        System.out.println(map.get(id1));
        
        //now how get all the keyset
        Set s = map.keySet();
        System.out.println("keys: "+s);
        // Iterator i = s.iterator();
        // while(i.hasNext())
        // {
        //     System.out.println(i.next());
        // }
       
        //now how to get all the values
        Collection c = map.values();
        System.out.println("Values: "+c);

        //using entryset
        Set s1 = map.entrySet();
        Iterator itr = s1.iterator();
        System.out.println("Entryset");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }


    }
}
