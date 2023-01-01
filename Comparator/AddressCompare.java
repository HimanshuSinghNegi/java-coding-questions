import java.util.Comparator;

public class AddressCompare implements Comparator{
     //override compare() of "comparator" method
     public int compare(Object o1, Object o2){
        Employee e1 = (Employee)o1;
        Employee e2 = (Employee)o2;

        //here using String class overriden CompareTo() methos
        return e1.address.compareTo(e2.address);
}
}