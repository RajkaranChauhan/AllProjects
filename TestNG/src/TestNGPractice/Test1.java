package TestNGPractice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	
	@BeforeTest
	public void getURL()
	{
		System.out.println("test1 BeforeTest");
	}

	
	@Test
	public  void test01()
	
	{
		System.out.println("Test1 test01");
	}
	@Test(groups = {"smoke"})
	public  void test02()
	
	{
		System.out.println("test1 test02");
	}
	
	
	@AfterTest
	public void browserClose()
	{
		System.out.println("test1 After Test");
	}
	
}
