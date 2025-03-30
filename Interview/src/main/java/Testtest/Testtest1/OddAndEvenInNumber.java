package Testtest.Testtest1;

public class OddAndEvenInNumber {

	public static void main(String[] args) {
		int number=1456781;
		int num=0;
		int even=0;
		int odd=0;
		
		
	while (number>0)
	{
		num=number%10;
		
		if(num%2==0)
		{
			even=even+1;
		}
		else
		{
			odd=odd+1;
		}
		number=number/10;
	}
	System.out.println( even +"**"+odd);
	}

}
