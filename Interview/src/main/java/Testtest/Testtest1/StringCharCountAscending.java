package Testtest.Testtest1;

import java.lang.reflect.Array;
import java.util.*;

public class StringCharCountAscending {
    public static void main(String [] args){

        String names = "jare Raj karan Chauhan";
        HashMap<String, Integer> mapArrange=new HashMap<>();
        HashMap<String, Integer> map = convertToHashMap(names);
        System.out.println(map);


//        int size = map.size();
//        System.out.println(size);
//         for (int i =0; i<size;i++){
//             HashMap<String, Integer> returnMap = findMinCount(map);
//             System.out.println("***"+returnMap);
//             mapArrange.putAll(returnMap);
//             System.out.println("-------"+mapArrange);
//             System.out.println(map);
//             System.out.println(returnMap.keySet());
//             map.remove(returnMap.keySet());
//             System.out.println(map);
//         }



    }
    public static HashMap<String, Integer> convertToHashMap(String names){
        HashMap<String, Integer> map=new HashMap<>();
        String[] name = names.toLowerCase().split(" ");
        for(String name1: name){
            System.out.println(name1);
            int length = name1.length();
            map.put(name1,length);
        }
        //System.out.println(map);
        return map;
    }
    public static HashMap<String, Integer> findMinCount(HashMap<String, Integer> map){
        HashMap<String, Integer> newMap=new HashMap<>();
        String  key;
        int valueCount;
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String , Integer>> it=entries.iterator();
        Map.Entry<String , Integer> ite=it.next();
        System.out.println(ite.getKey());
        System.out.println(ite.getValue());
        key= ite.getKey();
        valueCount= ite.getValue();
        while(it.hasNext()){
            Map.Entry<String , Integer> i=it.next();
            if(valueCount>i.getValue()){
                valueCount=i.getValue();
                key=i.getKey();
            }


        }
        System.out.println("-->"+key+":"+valueCount);
        newMap.put(key,valueCount);

        return newMap;
    }

}
