import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LaunchBrowser lb =new LaunchBrowser();
		lb.browserLaunch();
		lb.driver.manage().window().maximize();
		lb.driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//creating a local driver for table
		WebElement table = lb.driver.findElement(By.cssSelector(".table-display"));
		int rowSize=table.findElements(By.tagName("tr")).size();
		System.out.println("Number of Rows in talbe:"+ rowSize);
		
		int columnSize=table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size();
		System.out.println("Number of Columns in talbe:"+ columnSize);
		
		System.out.println(table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).get(0).getText());
		System.out.println(table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).get(1).getText());
		System.out.println(table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).get(2).getText());
		
	}

}
