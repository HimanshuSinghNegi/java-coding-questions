import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
//here we will sort userdefined data with help of lambda expression
//As we know we cannot sort userdefined data with "Collections.sort()" directly for that we have to take help of Lambda
//we can also use comparable and Comparator but that is lengthy method.
class Employee{
    int age;
    String name;
    float sal;
    Employee(int age, String name, float sal){
        this.age=age;
        this.name=name;
        this.sal=sal;
    }

    public String toString(){
        return age +" "+name +" "+ sal;
    }
}

public class LambdaWithCollectionDemo {
  public static void main(String[] args) {
    List<Employee> arr = new ArrayList<>();

    Employee e1 = new Employee(21, "Ram", 34.2f);
    Employee e2 = new Employee(25, "Shyam", 37.2f);
    Employee e3 = new Employee(22, "Karan", 35.2f);
    Employee e4 = new Employee(26, "Abhi", 36.2f);
    arr.add(e1);
    arr.add(e2);
    arr.add(e3);
    arr.add(e4);
    // Collections.sort(arr); :- this id give error , beacuse it cannot sort userdefined data
    System.out.println(arr);

    //here we will sort data with the help of lambda 
    Collections.sort(arr,(a,b)->{
        if(a.age>b.age)
           return 1;
        else if(a.age<b.age)
            return -1;
        else 
           return 0;
    });
  //now print
  System.out.println("Sorted according age :- "+arr);  

  //sorting according name
  Collections.sort(arr,(a,b)->{
    return a.name.compareTo(b.name);
});
  System.out.println("Sorting acc. name:- "+ arr);

 //sorting according sal
 Collections.sort(arr,(a,b)->{
    if(a.sal>b.sal)
    return 1;
 else if(a.sal<b.sal)
     return -1;
 else 
    return 0;

  });
  System.out.println("Sorting acc. sal:- "+ arr);



  //now if we want to filter data from  collection . here will use "Stream Api " which is very important.
  // for example : - we want to data of employee who have age greater than 21
  Stream<Employee> filter_data = arr.stream().filter(a->a.age>21); //here used lambda function
  //printing data
  System.out.println("Filtering according age greater than 21");
  filter_data.forEach(a->{
    System.out.println(a.age+" "+a.name+" "+a.sal);
  });

  //printing data
  System.out.println("Filtering according sal whose sal is greater than 35");
  Stream<Employee> filter_data1 = arr.stream().filter(a->a.sal>35); //here used lambda function
  filter_data1.forEach(a->{
    System.out.println(a.age+" "+a.name+" "+a.sal);
  });

}    

}
