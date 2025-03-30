package End2EndEcomerceAPI;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import End2EndEcomercePOJO.LoginDetails;
import End2EndEcomercePOJO.LoginResponse;
import End2EndEcomercePOJO.OrderDetails;
import End2EndEcomercePOJO.Orders;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class SpecBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//1. Login ###########################################
		RequestSpecification givenLoginSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		LoginDetails login =new LoginDetails();
		login.setUserEmail("raj.gamebegins@gmail.com");
		login.setUserPassword("Learning1#");
		
		RequestSpecification requestLoginSpec = given().log().all()
		.spec(givenLoginSpec).body(login);
		
		LoginResponse loginResponse = requestLoginSpec.when()
		.post("/api/ecom/auth/login")
		.then().extract().response().as(LoginResponse.class);
		
		System.out.println("get the token:"+ loginResponse.getToken());
		String token=loginResponse.getToken();
		System.out.println("get the user id:"+ loginResponse.getUserId());
		String userId=loginResponse.getUserId();
		
		//	2. Add Product #####################################################
		RequestSpecification givenAddProductSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).build();
		
		RequestSpecification requestAddProductSpec = given().log().all()
		.spec(givenAddProductSpec)
		.param("productName", "shoe")
		.param("productAddedBy", userId)
		.param("productCategory", "fashion")
		.param("productSubCategory", "shoes")
		.param("productPrice", "11500")
		.param("productDescription", "Adidas Originals")
		.param("productFor", "men")
		//Adding attachment using rest assured
		//.param("", null)
		.multiPart("productImage", new File("D:\\Dev\\buterfly22.jpg"));
		
		String responseAddProduct=requestAddProductSpec.when().log().all()
		.post("/api/ecom/product/add-product")
		.then().log().all().extract().response().asString();
		
		JsonPath js=new JsonPath(responseAddProduct);
		String productId=js.get("productId");
		System.out.println("The product id is : "+productId);
		
		//3. Create Orders#######################################################
		
		
	RequestSpecification givenCreateOrderSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).setContentType(ContentType.JSON).build();
		
		OrderDetails orderdetails=new OrderDetails();
		orderdetails.setCountry("India");
		orderdetails.setProductOrderedId(productId);
		
		///////////now create a list of the Orderdetails and add all the data that we have added (Set) above.
		List<OrderDetails> orderDetailsList=new ArrayList<OrderDetails>();
		orderDetailsList.add(orderdetails);
		
		Orders orders=new Orders();
		orders.setOrders(orderDetailsList);
		
		RequestSpecification requestCreateOrderSpec = given().log().all()
		.spec(givenCreateOrderSpec).body(orders);
		
		String responseCreateOrder=requestCreateOrderSpec.when().log().all()
		.post("/api/ecom/order/create-order")
		.then().log().all().extract().response().asString();
		
		System.out.println("Response of created order: "+responseCreateOrder);
	
			
		//4. Delete Product#######################################################
		//Sending path Parameters---  {productId} -- we know how to send query parameters now time for path parameters
		//https://rahulshettyacademy.com/api/ecom/product/delete-product/650085907244490f95ad7b4c
		//https://rahulshettyacademy.com/api/ecom/product/delete-product/{{productId}}
		
		RequestSpecification givenDeleteProduct = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).addHeader("Authorization", token).build();
	
		RequestSpecification requestDeleteProduct= given().spec(givenDeleteProduct).pathParam("ProdId", productId);
		
		String responseDeleteProduct=requestDeleteProduct.when().delete("/api/ecom/product/delete-product/{ProdId}")
		.then().log().all().extract().response().asString();
		
		
		JsonPath js1=new JsonPath(responseDeleteProduct);
		js1.getString("message");
		
		System.out.println(js1.getString("message"));
		
	}

}
