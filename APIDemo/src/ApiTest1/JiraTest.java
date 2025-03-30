package ApiTest1;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;
public class JiraTest {

	public static void main(String[] args) {


		RestAssured.baseURI="http://localhost:8080";
		
		//This is use to add session for each post run
		SessionFilter session = new SessionFilter();
		
	//	1. Creating seasion 
		
		String response= given()
		.log().all()
	////This is use to add session for each post run
		.filter(session)
		.header("Content-Type","application/json")
		.body("{ \"username\": \"raj.gamebegins\", \"password\": \"Learning1#\" }")
		.when().post("/rest/auth/1/session")
		.then().log().all()
		.extract().response().asString();
		
		System.out.println(response);
		
		
/*		//2. creating a issue as bug
		String createIssue= given().log().all()
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"fields\":{\r\n"
				+ "        \"project\": \r\n"
				+ "        {\r\n"
				+ "            \"key\":\"RSA\"\r\n"
				+ "        },\r\n"
				+ "         \"summary\": \"Debit Card defect 1\",\r\n"
				+ "         \"description\": \"First bug : 1\",\r\n"
				+ "            \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "}")
		//This is use to add session for each post run
		.filter(session)
		.when()
		.post("/rest/api/2/issue")
		.then().log().all()
		.extract().response().asString();
		
		
		System.out.println("Issue created and the response body is: "+createIssue);
		
*/
		//3.Add Comment
		String comment= "Hi handsome";
		
		String addCommentResponse=
		given().log().all()
		//This is use to add session for each post run
		.filter(session)
		.pathParam("key", "10007")
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"body\": \""+comment+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}")
		
		.when()
		.post("/rest/api/2/issue/{key}/comment")
		.then().log().all()
		.assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js=new JsonPath(addCommentResponse);
		String CommetnId= js.getString("id");
		
		//.extract().response().asString();
		
		//System.out.println("Comment added in Issue : "+addComment);
		
		//4. Add Attachment
		given().log().all()
		//This is use to add session for each post run
		.filter(session)
		.pathParam("key1", "10007")
		.header("X-Atlassian-Token","no-check")
		.header("Content-Type","multipart/form-data")
		.multiPart("file",new File("jira.txt"))
		.when()
		.post("/rest/api/2/issue/{key1}/attachments")
		.then()
		.assertThat().statusCode(200);
		
		
		//5. get Issue
		String getIssue=given().log().all()
		//This is use to add session for each post run
		.filter(session)
		//Using both path and query parameters
		.pathParam("key1", "10007")
		.queryParam("fields", "comment")
		.when()
		.get("/rest/api/2/issue/{key1}")
		.then().log().all()
		.extract().response().asString();
		
		System.out.println("Get Issue details : "+getIssue);
		
		JsonPath js1=new JsonPath(getIssue);
		int commentCount=js1.getInt("fields.comment.comments.size()");
		
		for (int i=0;i<commentCount;i++)
		{
			System.out.println(js1.getInt("fields.comment.comments["+i+"].id"));
			
			String commentIdIssue=js1.get("fields.comment.comments["+i+"].id").toString();
			if(commentIdIssue.equalsIgnoreCase(CommetnId))
			{
			String msg=	js1.get("fields.comment.comments["+i+"].body").toString();
			System.out.println(msg);
			
			Assert.assertEquals(msg, comment);
			}
			
			
			
		}
		
	}

}
