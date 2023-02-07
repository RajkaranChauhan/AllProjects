import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	System.setProperty("webdriver.chrome.driver", "D:/Dev/chromedriver_win32/chromedriver.exe");
	WebDriver driver= new ChromeDriver();
		driver.get("https://www.youtube.com");
		System.out.println(driver.getTitle());
		System.out.println (driver.getCurrentUrl());
		driver.close();
		*/
/*		---1
		ArrayList <String> a = new ArrayList <String>();
		
		a.add("Raj");
		a.add("karan");
		a.add("chauhan");
		a.add("ramPur");
		a.remove(3);
		//int b=a.size();
		
		for (int i=0; i< a.size(); i++)
		{
			System.out.println(a.get(i));
			//System.out.println(b);
		}
		
	//System.out.println(a.get(2));
		//*/
		
/*		ArrayList <String> aa= new ArrayList <String>();
		aa.add("mohan");
		aa.add("lal");
		aa.add("chauhan");
		
		for (int j=0; j< aa.size(); j++)
		{
			System.out.println(aa.get(j));
		}
		
	*/
		//---2
		///both a and b will point to save string "Raj Karan Chauhan" as for them once space is allocated. the string is stored in one place
		String a = "Raj karan Chauhan";
		String b = "Raj karan Chauhan";
		
		
		//both c and d will have there own space allocation for the object c and d and having the same string value  "Mohan Chauhan"
		String c=new String("Mohan Chauhan");
		String d=new String("Mohan Chauhan");
		String e=new String ("Sumati Chauhan");
	
	String[] split =c.split(" ");
	
	for (int i=0;i<split.length;i++)
		{
		System.out.println(i);
	System.out.println(split[i]);
		}
	
	for (int i=0; i<c.length();i++)
	{
	System.out.println(c.charAt(i) );
	}
		
		
			
			
		
	}

	

}
