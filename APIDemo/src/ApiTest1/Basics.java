package ApiTest1;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.payLoad;

public class Basics {
	
	public static void main(String[]args)
	{
		
		///Add a place and validate the details  ---> Update place with new address --> Get place to validate if the new address is present in response 
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String responseAddAddressjson =given().log().all()
		.queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
	/*	.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "")
		*/
		.body(payLoad.AddPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all()
		.assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println("The response of the AddPlace" + responseAddAddressjson);
		
		JsonPath js= new JsonPath(responseAddAddressjson);
		String placeId=js.getString("place_id");
		System.out.println("The placeId in the AddPlace response is : "+placeId);
		
		//Update Place
		given().log().all()
		.queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+ placeId +"\",\r\n"
				+ "\"address\":\"70 winter walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().log().all()
		.assertThat().statusCode(200).body("msg",equalTo("Address successfully updated") );
		
		//Get Place
		String responseGetAddressJson=
				given().log().all()
		.queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		//no need to add header as we are not sending any body
		//.header("Content-Type","application/json")
		.when().get("maps/api/place/get/json")
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().asString();
		
		System.out.println("Get Address response" + responseGetAddressJson);
		JsonPath js1= new JsonPath(responseGetAddressJson);
		String address=js1.getString("address");
		System.out.println("The address in the GetPlace response is : "+address);
		
		
	}

	

}
