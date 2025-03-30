package ApiTest1;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.GetCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.*;

import org.openqa.selenium.chrome.ChromeDriver;

public class OAuth_Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//1. Authorization Code
/*		
		System.setProperty("webdriver.chrome.driver", "D:\\Dev\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		///Auth URL for user and credentials
		driver.get("https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&service=lso&o2v=2&flowName=GeneralOAuthFlow");
		driver.findElement(By.xpath("//div[@data-email='raj.gamebegins@gmail.com']")).click();
		//driver.findElement(By.cssSelector("input for email")).sendKeys("username");
		//driver.findElement(By.cssSelector("input for email")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		//driver.findElement(By.cssSelector("input for password")).sendKeys("password");
		//driver.findElement(By.cssSelector("input for email")).sendKeys(Keys.ENTER);
		//Thread.sleep(3000);
		String url= driver.getCurrentUrl();
	*/
		//the below url is obtained by hitting the Auth UR above and geting the url after login manually
		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0Adeu5BU9Uh5EJKk0DCmrOhlVNVaCmKpv-HP7Gc3WX7dYsnnwu2ZEnfX0p2hbo086cNC_fw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=1&prompt=none";
		String partialcode= url.split("code=")[1];
		String code= partialcode.split("&scope")[0];
		System.out.println(code);
		// code =     4%2F0AfgeXvtry5zNhkhzNCYblMpz5KTcmnr_80lsr7EYJDfaWshf8M3wj9sLtIHHP9GseD6SuQ
		
		//2. Receiving access token
		String accessTokenResponse= given()
		.urlEncodingEnabled(false)   //// to make sure it is not replacing symbold to char for the code string above
		.queryParam("code", code)
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js=new JsonPath(accessTokenResponse);
		String accessToken=js.getString("access_token");
/////////////////////////////////////////////////POJO/////////////////////////////////////////////	
/////////////////////////////////////////////////POJO/////////////////////////////////////////////	
/////////////////////////////////////////////////POJO/////////////////////////////////////////////	
/////////////////////////////////////////////////POJO/////////////////////////////////////////////	
		//3.  Providing access token
		//String responce =given().log().all()
		System.out.println("*****************");
		 GetCourse gc = given().log().all()
				
				//.log().all()
		.queryParam("access_token", accessToken)
		//what is type of response is expected. This can be avoided if header has "Contemt-Type"= "application/json"
		.expect().defaultParser(Parser.JSON)
		.when()
		.get("/getCourse.php")
		//.then().extract().response().asString();
		.then().extract().response().as(GetCourse.class);
		System.out.println("*****************");
	//	System.out.println(responce);
		
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		
		
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		
		int count=gc.getCourses().getApi().size();
		for (int i=0;i<count;i++) {
			if(gc.getCourses().getApi().get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
				System.out.println("Price of SoapUI Webservices testing: "+gc.getCourses().getApi().get(i).getPrice());
			}
		}
		
		int count1=gc.getCourses().getWebAutomation().size();
		for (int i=0;i<count1;i++) {
			System.out.println("The cource title of automation are:" + gc.getCourses().getWebAutomation().get(i).getCourseTitle());
			
		}
		
		
	}

}


//https://rahulshettyacademy.com/getCourse.php?