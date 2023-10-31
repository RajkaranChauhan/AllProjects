package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	public static RequestSpecification givenSpec; // so that givenSpec is same through out the execution video.111
	
	

	public RequestSpecification requestSpecification() throws IOException {
		
		if (givenSpec ==null)
		{
	//	RestAssured.baseURI = "https://rahulshettyacademy.com";
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt")); ///here the file is not created in advance the file will be created in run time
		
		// logeer info in global lebel so that user do not need to log everywhere
		givenSpec = new RequestSpecBuilder().setBaseUri(getdataProperties("baseUrl"))
		.addQueryParam("key", "qaclick123")
		.addFilter(RequestLoggingFilter.logRequestTo(log))  ///in order to add logging in separate file and removing .log().all() syntxt
		.addFilter(ResponseLoggingFilter.logResponseTo(log)) // similar for request logging we also need to define the response for response logging 
		.setContentType(ContentType.JSON).build();
		
		return givenSpec;
		}
		return  givenSpec;
	}
	
	
	public ResponseSpecification responseSpecification() throws FileNotFoundException {
		
		ResponseSpecification responseSpec=new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
		
		return responseSpec;
	}
	
	
	//here the method needs to define static as we are calling the below method without creating constructor 
	public static String getdataProperties(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Dev\\Selenium\\APIFrameWork\\src\\test\\resource\\resources\\data.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	public String getJsonPath(Response response, String key)
	{
		String resp=response.asString();
		JsonPath js= new JsonPath(resp);
		return js.get(key).toString();
	}
}
