package Testtest.Testtest1;

public class TwoArrayCompareEqualOrNot {
	public static void main(String[] args) {
		
		int[] a= {1,2,3,4,5};
		int[] b= {1,2,3,4,5};
		int count=0;
		
		if (a.length==b.length)
		{
			System.out.println("Array lenght equal");
			
			for (int i=0; i<a.length;i++)
			{
				if(a[i]!=b[i])
				{
					count=count+1;
					break;
				}
			}
			
			if(count >0)
			{
				System.out.println("Array NOT equal");
			}
			else
			{
				System.out.println("Array Is equal");
			}
			
		}
		else
		{
			System.out.println("Array NOT equal");
		}
		
	}

}
