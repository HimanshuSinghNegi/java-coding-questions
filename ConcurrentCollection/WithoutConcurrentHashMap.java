import java.util.Iterator;
import java.util.Map;

import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;
//Note :- Concurrent collection is extended version of traditional collection. Because it is synchronized and fast.
public class WithoutConcurrentHashMap {
    
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Himanshu");
        map.put(2,"Mohit");
        map.put(3,"kalu");

        Set entrySet = map.entrySet();
        Iterator i = entrySet.iterator();
        while(i.hasNext()){
            Map.Entry m  =(Map.Entry)i.next();
            map.put(4,"karan"); // here it will throw ConcurrentModificationException because HashMap is Unsynchronized so,
            //here we are adding values, so we can't do this 
            System.out.println(m.getKey()+":"+m.getValue());
        }
        
    }
}
