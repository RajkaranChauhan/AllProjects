package TestNGPractice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 {
	@Test
	public void test03()
	{
		System.out.println("Class Test3 test3");
	}
	@Test(groups = {"smoke"})
	public void test01()
	{
		System.out.println("Class Test3 test1");
	}@Test
	public void test02()
	{
		System.out.println("Class Test3 test2");
	}@Test(groups = {"smoke"})
	public void test04()
	{
		System.out.println("Class Test3 test4");
	}
	@Test
	public void Demo01()
	{
		System.out.println("Class Test3 Demo1");
	}
	
	
	@BeforeTest
	public void getURL()
	{
		System.out.println("test3 BeforeTest");
	}
	@AfterTest
	public void browserClose()
	{
		System.out.println("test3 After Test");
	}
	

}
