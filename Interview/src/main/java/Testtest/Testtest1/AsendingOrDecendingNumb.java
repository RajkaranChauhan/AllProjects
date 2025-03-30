package Testtest.Testtest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsendingOrDecendingNumb {

	public static void main(String[] args) {
		

			String[]  a= {"-7" ,"-1", "3" , "0","2","5", "2"};
			//Arrays.toString(a);
			
			List<String> b = Arrays.asList(a);
			ArrayList<String> c=new ArrayList<String>(b);
			
			//System.out.println(b.get(0));
			

			int size=c.size();
	String dump;

			for (int i=0;i<size;i++)
			{
				for (int j=i+1; j<size;j++)
				{
					if ((Integer.parseInt(c.get(i))<Integer.parseInt(c.get(j))))
					{
						
					}
					else
					{
						dump=c.get(j);
						c.remove(j);
						c.add(i,dump);
						
				}
				
			}

			System.out.println(c);
		}

	/*	int[] a= {-7,-1,3,0,2,5,2};

		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	*/
		}

	}


