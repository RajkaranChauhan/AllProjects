package TestNGPractice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {
	@Test
	public  void test01()
	
	{
		System.out.println("Class Test2 test01");
	}
	
	@BeforeTest
	public void getURL()
	{
		System.out.println("test2 BeforeTest");
	}
	@AfterTest
	public void browserClose()
	{
		System.out.println("test2 After Test");
	}
	

}
