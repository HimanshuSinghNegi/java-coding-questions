import java.util.*;

class Emp{
    int id;
    String name,address;
    Emp(int id, String name, String address){
        this.id=id;
        this.name=name;
        this.address=address;
    }
    public String toString(){
        return id +" "+name+" "+address;
    }

}
public class TreeMapDemo {

    public static void main(String[] args) {
    Map<Integer,Emp> map = new TreeMap<>();
    Emp e1 = new Emp(1, "Himanshu","shivrajpur");
    Emp e2 = new Emp(2,"Mohit","Kishanpur");
    Emp e3 = new Emp(3,"Nitesh","Shibunagar");
    Emp e4 = new Emp(3,"Nitesh","Shibunaar");
    map.put(1,e3);
    map.put(2,e2);
    map.put(3,e1);
    map.put(3,e4);
    System.out.println(map);

    Set s1 = map.entrySet();
    Iterator s2= s1.iterator();
    while(s2.hasNext()){
        System.out.println(s2.next());
        
    }


    }
    
}
