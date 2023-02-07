import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class LoginPagePractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		LaunchBrowser lb = new LaunchBrowser();

		lb.browserLaunch();
		lb.driver.manage().window().maximize();

		lb.driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println("page loaded");

		lb.driver.findElement(By.xpath("//Input[@id='username']")).sendKeys("rahulshettyacademy");
		///// rahulshettyacademy
		lb.driver.findElement(By.xpath("//Input[@id='password']")).sendKeys("learning");
		// learning
		lb.driver.findElement(By.xpath("(//input[@id=\"usertype\"])[2]")).click();


		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(lb.driver, 5);

		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@id=\"okayBtn\"]")));

		lb.driver.findElement(By.xpath("//button[@id=\"okayBtn\"]")).click();

		System.out.println("DD");


		WebElement staticdropdown = lb.driver.findElement(By.xpath("//select[@class=\"form-control\"]"));

		Select dropdown = new Select(staticdropdown);
		dropdown.selectByVisibleText("Consultant");

		lb.driver.findElement(By.xpath("//input[@id=\"terms\"]")).click();

		lb.driver.findElement(By.xpath("//input[@id=\"signInBtn\"]")).click();
		WebDriverWait w1 = new WebDriverWait(lb.driver, 5);
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"nav-link btn btn-primary\"]")));
		System.out.println("next page");

		WebDriverWait w2 = new WebDriverWait(lb.driver, 5);
		w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"nav-link btn btn-primary\"]")));
		System.out.println("next page");

		String[] ItemsNeeded = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
		List ItemsNeededList = Arrays.asList(ItemsNeeded);

		List<WebElement> product = lb.driver.findElements(By.xpath("//h4[@class=\"card-title\"]"));   //// product name

		for (int i = 0; i < product.size(); i++) {
			String SingleProduct = product.get(i).getText();

			if (ItemsNeededList.contains(SingleProduct)) {
				System.out.println(i);
				System.out.println(SingleProduct);
				lb.driver.findElements(By.xpath("//button[@class=\"btn btn-info\"] ")).get(i).click();   //// add button
				// break;
			}

			System.out.println(SingleProduct);
		}

		lb.driver.findElement(By.xpath("//a[@class=\"nav-link btn btn-primary\"]")).click();

	}

}
