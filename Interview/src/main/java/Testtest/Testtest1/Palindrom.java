package Testtest.Testtest1;

public class Palindrom {

	public static void main(String[] args) {

int num=37;
int count=0;

for(int i=1; i<=num;i++)
{
	if(num%i==0)
	{
		count=count+1;
	}
}
if (count==2)
{
	System.out.println("Number is palindorm");	
}
else
{System.out.println("Number is NOT palindorm");	
	}

	}

}
