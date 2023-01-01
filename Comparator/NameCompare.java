import java.util.Comparator;

//Note :- Comparator is inside the java.util package

public class NameCompare implements Comparator{

    //override compare() of "comparator" method
    public int compare(Object o1, Object o2){
          Employee e1 = (Employee)o1;
          Employee e2 = (Employee)o2;

          //here using String class overriden CompareTo() methos
          return e1.name.compareTo(e2.name);
    }
    
}
