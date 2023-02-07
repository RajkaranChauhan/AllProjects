import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*
		LaunchBrowser lb =new LaunchBrowser();
		lb.browserLaunch();
		lb.driver.manage().window().maximize();
		lb.driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
	
	*/	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		///Crating a list of names available in the table first column
	//	List<WebElement> List = lb.driver.findElements(By.xpath("//div[@class=\"tableFixHead\"] //table[@id=\"product\"] //tr/td[1]"));
		List<WebElement> List = driver.findElements(By.xpath("//div[@class=\"tableFixHead\"] //table[@id=\"product\"] //tr/td[1]"));
		//user of stream to filter the name in a list in sort order of J and print all the name wiht J
//		List<String> NameList=List.stream().map(s->s.getText()).collect(Collectors.toList());  /// here webelement is first converted inot string via getText and then collected in list of stign
//		NameList.stream().filter(s-> s.startsWith("J")).sorted().forEach(s-> System.out.println(s));
		//printing the name starting wiht J in sort order and in uppercase
//		NameList.stream().filter(s-> s.startsWith("J")).map(s-> s.toUpperCase()).forEach(s-> System.out.println(s));
		
	//	List<String> NameList2=List.stream().filter(s->s.getText().contains("Joe")).collect(Collectors.toList());
	//	List<String> NameList21=List.stream().map(s->s.getText()).map(s->s.con)
	//	List<String> NameList1=List.stream().map(s->s.getcontains("Joe")).map(s-> getPosition(s)).collect(Collectors.toList());
	//	List<String> NameList1=List.stream().filter(s->s.getText().contains("J")).map(s-> getPosition(s)).collect(Collectors.toList());
		List<String> NameList1=List.stream().filter(s->s.getText().contains("J")).map(s-> getPosition(s)).collect(Collectors.toList());
	//	List<String> NameList1=List.stream().filter(s->s.getText().contains("J")).collect(Collectors.toList());
		
		NameList1.forEach(s-> System.out.println(s));
		System.out.println(NameList1.size());
		
	//	List<WebElement> NameList2=List.stream().map(s->s.getText().contains("Joe")).map(s-> getPosition(s)).collect(Collectors.toList());
		
	//	NameList1.stream().filter(s->s.contains("Joe")).map(s-> getPosition(s)).collect(Collectors.toList());
	}

	private static String getPosition(WebElement s) {
		// TODO Auto-generated method stub
		String Position=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return Position;
	}

}
