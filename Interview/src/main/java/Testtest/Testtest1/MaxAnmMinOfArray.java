package Testtest.Testtest1;

import java.util.Arrays;

public class MaxAnmMinOfArray {

	public static void main(String[] args) {


		int[] a= {1,2,6,4,5};
		int max=a[0];
		
		for(int i=1; i<a.length;i++)
		{
			if(max>a[i])
			{
				
			}
			else
			{
				max=a[i];
			}
		}

		System.out.println(max);
	}

}
