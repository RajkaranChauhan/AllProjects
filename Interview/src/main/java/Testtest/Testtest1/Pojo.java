package Testtest.Testtest1;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pojo {
	public static void main(String[] args) {
		
		
	int[] num= {1,4,5,6,6,6,9,9,9} ;
	int size=num.length;
	int count=0;
	int n=9;
	//int mNumber = 0;
	ArrayList<String> miss=new ArrayList<String>();

	for(int i=1;i<=n;i++)
	{
		for(int j=0;j<size;j++)
			
		{
			if(i==num[j])
			{
				count=count+1;
				break;
			}
		}
		if (count==1)
				{
			count=0;
				}
		else {
			//mNumber=i;
			//Integer.toString(i);
			miss.add(Integer.toString(i));
		}
		
	}
	System.out.println(miss);
	
/*	int[] num= {1,4,2,5} ;
	int n=5;
	
	int sum=(n*(n+1))/2;
	System.out.println(sum);
	
	int arrSum=0;
	
	
	for (int i=0; i<num.length;i++)
	{
		arrSum=arrSum+num[i];
	}
	System.out.println("Missing Number: "+(sum-arrSum));
	
	*/
	
		
	
	}
}
