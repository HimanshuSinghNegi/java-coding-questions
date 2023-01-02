import java.util.Iterator;
import java.util.Map;

import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
//Note :- Concurrent collection is extended version of traditional collection. Because it is synchronized and fast.
public class ConcurrentHashMapDemo {
    
    public static void main(String[] args) {
        Map<Integer,String> map = new ConcurrentHashMap<>();
        map.put(1,"Himanshu");
        map.put(2,"Mohit");
        map.put(3,"kalu");

        Set entrySet = map.entrySet();
        Iterator i = entrySet.iterator();
        while(i.hasNext()){
            Map.Entry m  =(Map.Entry)i.next();
            map.put(4,"karan"); // here we are added values which is possible beacuse we are using ConcurrentHasMap otherwise it will sho
            // ConcurrentModifcationException
            System.out.println(m.getKey()+":"+m.getValue());
        }
        
    }
}
