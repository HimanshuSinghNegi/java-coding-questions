import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SortMap {
    
    public static void takeInputIntoMap(Map<String,Integer> map){
         System.out.println("Enter key(String) for map");
         Scanner scanner = new Scanner(System.in);
         String key = scanner.nextLine();
         System.out.println("Enter Value(Integer) :-");
         Integer value = scanner.nextInt();
         map.put(key,value);
    }

    public static void addMapIntoList(Map<String,Integer> map,List<Map<String,Integer>> mapList){
       mapList.add(map);
    }

    public static void sortMaps(List<Map<String,Integer>> mapList){
        // List<Map<String,Integer>> sortedList = new ArrayList<>(); 
        // using Bubble sort
        for(int iterate=0;iterate<mapList.size()-1;iterate++){
            for(int j=0;j<mapList.size()-iterate-1;j++){
                int prev=0;
                int forw=0;
            
                for(Map.Entry<String,Integer> entry : mapList.get(j).entrySet()){
                prev=entry.getKey().charAt(0);
                }
                for(Map.Entry<String,Integer> entry : mapList.get(j+1).entrySet()){
                forw=entry.getKey().charAt(0);
                }

                Map<String,Integer> map1 = mapList.get(j);
                Map<String,Integer> map2 = mapList.get(j+1);
            
            if(prev>forw){
                mapList.set(j, map2);
                mapList.set(j+1,map1);
            }

        }
    }
}

public static void printMapList(List<Map<String,Integer>> map){
    System.out.println(map);
}
    
    public static void main(String[] args) {
        List<Map<String,Integer>> mapList = new ArrayList<>();
        Map<String,Integer> map1= new HashMap<>();
        takeInputIntoMap(map1);  
        addMapIntoList(map1, mapList);
        Map<String,Integer> map2= new HashMap<>();
        takeInputIntoMap(map2);  
        addMapIntoList(map2, mapList);
        Map<String,Integer> map3= new HashMap<>();
        takeInputIntoMap(map3);  
        addMapIntoList(map3, mapList);

        System.out.println("Before Sorting :-");
        printMapList(mapList);
        
        //sortMaps
        sortMaps(mapList);
        
        System.out.println("After sorting :-");
        printMapList(mapList);
    }
    
}
