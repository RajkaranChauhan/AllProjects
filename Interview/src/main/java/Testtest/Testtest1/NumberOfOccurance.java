package Testtest.Testtest1;

public class NumberOfOccurance {
	public static void main(String[] args) {
	//Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
			//Input: nums = [8,1,2,2,3]
			//Output: [4,0,1,1,3]
			
			int[] numbs= {8,1,2,2,3};
			int count=0;
			
			int size=numbs.length;
			
			for (int i=0; i<size;i++)
			{
				for (int j=0;j<size;j++)
				{
					//System.out.println(numbs[i]);
					//System.out.println(numbs[j]);
					if (numbs[i]>numbs[j])
					{
						count =count +1;
						//System.out.println("**"+count);
					}
					else {
						
					}
				}
				
				System.out.println(count);
				count=0;
			}
}

}
