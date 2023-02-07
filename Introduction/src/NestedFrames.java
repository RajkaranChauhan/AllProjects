import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class NestedFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LaunchBrowser lb =new LaunchBrowser();
		lb.browserLaunch();
		lb.driver.manage().window().maximize();
		lb.driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		//the original page has 2 frame
	System.out.println(lb.driver.findElements(By.tagName("frame")).size());		
	
	// xpath of top frame //frame[@name='frame-top']
	
	lb.driver.switchTo().frame(lb.driver.findElement( By.xpath("//frame[@name='frame-top']")));
	//the child1 top frame has 3 frames
	System.out.println(lb.driver.findElements(By.tagName("frame")).size());	
///  middle frame xpath     //frame[@name='frame-middle']
	
	lb.driver.switchTo().frame(lb.driver.findElement(By.xpath("//frame[@name='frame-middle']")));
	
	System.out.println(lb.driver.findElement(By.xpath("//div[@id=\"content\"]")).getText());	
	
	//coming out of the child1 frame now the user is on the original page having 2 frames
	lb.driver.switchTo().defaultContent();	
	System.out.println(lb.driver.findElements(By.tagName("frame")).size());	
	
	
	}
	

}
