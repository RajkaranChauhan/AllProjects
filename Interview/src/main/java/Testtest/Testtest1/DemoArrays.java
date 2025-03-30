package Testtest.Testtest1;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DemoArrays {

	public static void main(String[] args) {
	

		//1 to create array
	/*			int[] array1= {1,2,3,4,5};
				
				System.out.println(Arrays.toString(array1));
				
				System.out.println(array1.length);//5
				System.out.println(array1[3]); //4
				array1[3]=99;
				System.out.println(array1[3]);//99
				//array1[5]=6; //--> you cannot add new  data in this array for next index as it is defiend and closed array
				//here the array lenght is fix 
				//***********************************************
				
				int a[]= new int[4];
				int leg=a.length;
				
				System.out.println("***"+leg);
				a[0]=51;
				a[1]=52;
				a[2]=53;
				a[3]=54;
				System.out.println(Arrays.toString(a));
				System.out.println(a[0]);//51
				System.out.println(a[1]);//52
				System.out.println(a[2]);//53
				System.out.println(a[3]);//54
			//	a[4]=55;   --> Index 5 out of bounds for length 5
			//	System.out.println(a[4]);//51
				
			*/	
			
	/*			String[] array2= {"raj","karan","chauhan"};
				System.out.println(array2[2]);//chauhan
				System.out.println("###"+array2);
				System.out.println("###"+Arrays.toString(array2));
				array2[2]="Laxmi";
				System.out.println(array2[2]);//Laxmi
				
				List<String> array3 = Arrays.asList(array2);
				System.out.println(array3.get(2));//laxmi
				System.out.println(array3);
				//System.out.println(Arrays.toString(array3));
				//array3.add("rajlaxmi");  /// throwing error not allowing to add as in array we have added a wraper of list
			//	System.out.println(array3.size());
			//	System.out.println("-------------------");
			//	System.out.println(array3.size());
				//array3.remove(2);  //not able to remove as fixed array
				
				
				
				
			ArrayList<String> array4=new ArrayList<String>(array3);
			array4.add("rajlaxmi");
			System.out.println(array4.get(3));
			array4.remove(3);
			//System.out.println(array4.get(3)); as laxmi is removed
	*/
		
	/*	String[] name= {"a","b","c"};
		//System.out.println(name[1]);
		//System.out.println(name);
		System.out.println(Arrays.toString(name));
		 List<String> names=Arrays.asList(name);
		 System.out.println(names.get(1));
		 System.out.println(names);
		 ArrayList<String> a=new ArrayList<String>(names);
		 System.out.println(a.get(1));
		 System.out.println(a);
		*/
		
		
		String a[]= new String[4];
		int leg=a.length;
		
		System.out.println("***"+leg);
		a[0]="51";
		a[1]="52";
		a[2]="53";
		a[3]="54";
		
//		System.out.println(a[0]);
//		System.out.println(Arrays.toString(a));
		
		List<String> b=Arrays.asList(a);
//		System.out.println(b.get(0));
//		System.out.println(b);
		
		ArrayList<String> aa=new ArrayList<String>(b);
		 System.out.println(aa.get(1));
		 System.out.println(aa);
		 
		 aa.remove(0);
		 System.out.println(aa);
		
	}
	
}
