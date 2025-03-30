package Testtest.Testtest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicateNameDataFromArrrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strng= "sapan amit rahul amit romil sapan rohan rahul sarraf chanda amit";
		String[] arraynames = strng.split(" ");
		List<String> name1 = Arrays.asList(arraynames);
		
		List<String> name = new ArrayList<String>(name1);
		
		
		
		 List<String> unique = name.stream().distinct().collect(Collectors.toList());
		 
		// name.stream().distinct().forEach(e);
		
System.out.println(unique);

	int sizeUnq=unique.size();
	int sizename=name.size();
	String value;
	System.out.println("size unique: "+sizeUnq);
	System.out.println("size name: "+sizename);
	
	
	for (int i=0; i<sizeUnq;i++)
	{
		 value = unique.get(i);
		// System.out.println("unique anme is: "+value);
		 
		 for (int j=0; j<sizename;j++)
		 {
			 if(value.equalsIgnoreCase(name.get(j)))
			 {
				 name.remove(j);
				 break;
			 }
		 }
	}
	System.out.println(name);
	
	System.out.println( "duplicate name count :" +name.size() );
	}

}
