import java.util.Comparator;

public class AgeCompare implements Comparator {
     //override compare() of "comparator" method
     public int compare(Object o1, Object o2){
        Employee e1 = (Employee)o1;
        Employee e2 = (Employee)o2;

        //logic to compare ages of the employees
        if(e1.age>e2.age)
        return 1;
        else if(e1.age<e2.age)
        return -1;
        else
        return 0;
}}
