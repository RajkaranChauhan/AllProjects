package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;
import resources.Utils;
import resources.ENumApiResources;

public class PlaceValidation extends Utils {
	
	///here we are extending the utils class without createing the object of the utils class
	
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	Response response;
	
	
	//RequestSpecification requestGetPlaceSpec;
	static String place_id;  // this is used as static as for the complete class this value will remain constant or else without static, for each scenario the non static will reset to null
	JsonPath js;
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
//		String response=given().queryParam("key","qaclick123")
			requestSpec=given().spec(requestSpecification()) //responseAddPlaceSpec is passed through utils class
			.body(data.addPlacePayLoad(name,language,address)) ;			
	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String APIresource, String method) throws FileNotFoundException {
		
			
		//here passing the name of the resource which we want to fetch form enumApiResource, pass resource will invoke the const of enumapiresources
		ENumApiResources resourceAPI= ENumApiResources.valueOf(APIresource);
		System.out.println(resourceAPI.getResource());
		
		if(method.equalsIgnoreCase("POST"))
		{
		//responseAddPlaceSpec is passed through utils class
		 response = requestSpec.when()
				 
		//.post("/maps/api/place/add/json");
		.post(resourceAPI.getResource()) ;// fethcing the data from enumAPIresource
		 System.out.println("post response: "+response);
		 
			
		}
		else if(method.equalsIgnoreCase("GET"))
		{
			response = requestSpec.when()
					//	.post("/maps/api/place/get/json");
						.get(resourceAPI.getResource()) ;
			System.out.println("get response: "+response);
		}
		
		
	/*	.then()
		//.assertThat().statusCode(200)
		.spec(responseSpecification()) //responseAddPlaceSpec is passed through utils class
		.extract().response();
	
	*/
		 }

	@Then("The API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(long expectedStatusCode) {
		long actualStatusCode=response.getStatusCode();
		assertEquals(expectedStatusCode, actualStatusCode);     ////import static org.junit.Assert.*;
		System.out.println(expectedStatusCode +": "+actualStatusCode);
	}

	@Then("{string} in the respose body is {string}")
	public void in_the_respose_body_is(String key, String Expectedvalue) {
	//	String responseAddPlaceString= responseAddPlace.toString();
		
		//js=new JsonPath(responseAddPlaceString);
		
		//String actualValue=js.get(Expectedkey);
		String actualValue=getJsonPath(response,key);
		 System.out.println("actualValue post response: "+actualValue);
		assertEquals(actualValue,Expectedvalue);
		System.out.println(Expectedvalue +": "+actualValue);
		
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String APIResource) throws IOException {
		
		place_id=getJsonPath(response,"place_id");
		System.out.println("the place id is:"+place_id);
		requestSpec=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(APIResource,"GET");
		System.out.println("the expected name is :"+expectedName);
		
		System.out.println("get response1: "+response);
			
		String actualName=getJsonPath(response,"name");
		assertEquals(actualName,expectedName);
		System.out.println("name matched");
		
	}

	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		requestSpec= given().spec(requestSpecification()).body(data.deleteplacePayLoad(place_id));
	}


}
