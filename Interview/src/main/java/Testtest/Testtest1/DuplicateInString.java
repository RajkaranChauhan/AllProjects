package Testtest.Testtest1;


import static org.testng.Assert.*;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;

//import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateInString {

	public static void main(String[] args) {
		
//"sapan amit rahul amit romil sapan rohan rahul sarraf chanda"
        
//       String[] name={"sapan", "amit","rahul" ,"amit" ,"romil" ,"sapan" ,"rohan" ,"rahul","sarraf","chanda"};
//        String nam="";
//
//
//		String strng= "sapan amit rahul amit romil sapan rohan rahul sarraf chanda raj raj raj";
//		String[] arrayNames = strng.split(" ");
//
//
//	//	int i=arrayNames.length;
//		//String a=arrayNames[0];
//		//System.out.println(a);
//		List<String> names = Arrays.asList(arrayNames);
//
//		Set<String> duplicate = new HashSet<String>();
//		Set<String> unique = new HashSet<String>();
//		int size=names.size();
//		int count1 =0;
//
//		for (int i=0;i<size;i++)
//		{
//			for (int j=i; j<size;j++)
//			{
//				if(names.get(i).equalsIgnoreCase(names.get(j)))
//				{
//					count1=count1+1;
//					if (count1>1)
//					{duplicate.add(names.get(i));
//					count1=0;
//						break;
//					}
//
//				}
//
//			}
//			if( count1==1)
//			{
//				unique.add(names.get(i));
//				count1=0;
//			}
//		}
//
//
////		System.out.println(duplicate);
//System.out.println(unique);
//



		//SECOND METHOD
		String string= "sapan amit rahul amit romil sapan rohan rahul sarraf chanda raj raj raj";
		String[] arrayNamess = string.split(" ");
		List<String> list = Arrays.asList(arrayNamess);
		System.out.println(list);

		//using stream()
		System.out.println("using stream");
		List<String> collect = list.stream().filter(ele -> (Collections.frequency(list, ele)) > 1).distinct().collect(Collectors.toList());
		System.out.println("Duplicate : "+collect);
		List<String> collect1= list.stream().filter(ele -> (Collections.frequency(list, ele)) <2).distinct().collect(Collectors.toList());
		System.out.println("Unique : "+collect1);

		//using Hashmap
		List<String> dup=new ArrayList<>();
		List<String> uniq=new ArrayList<>();
		System.out.println("using Hashmap");
		HashMap<String, Integer> map=new HashMap<>();
		for(String ele: list)
		{
			if(map.containsKey(ele)){
				map.put(ele,map.get(ele)+1);
			}
			else {
				map.put(ele,1);
			}
		}
		System.out.println(map);

		for( String ele:map.keySet()){
			if(map.get(ele)>1){
				dup.add(ele);
			}
			else {
				uniq.add(ele);
			}
		}
		System.out.println("Duplicate :"+dup);
		System.out.println("Unique :"+uniq);

		//using for loop
		System.out.println("USING FOR LOOP");
		System.out.println(list);
//		HashSet<String> d=new HashSet<>();
//		HashSet<String> u=new HashSet<>();
		List<String> d=new ArrayList<>();
		List<String> u=new ArrayList<>();
		int count =0;

		for (int i=0;i<list.size();i++){
			for(int j=0;j<list.size();j++){
				if(list.get(i).equalsIgnoreCase(list.get(j))){
					count =count+1;
					if(count>1){
						if(!d.contains(list.get(i))){
							d.add(list.get(i));

						}
						count =0;
						break;

					}
				}

			}
			if(count==1){
				u.add(list.get(i));
				count =0;
			}

		}
		System.out.println("unique:"+u);
		System.out.println("duplicate: "+d);
	}
	}