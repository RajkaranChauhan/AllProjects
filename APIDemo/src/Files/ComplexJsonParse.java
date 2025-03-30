package Files;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js= new JsonPath(payLoad.CourcePrice());
	//1. Print No of courses returned by API	
		int count =js.getInt("courses.size");
		System.out.println("Print No of courses returned by API: "+count);
		
	//2.Print Purchase Amount	
		
		int purchaseAmount =js.getInt("dashboard.purchaseAmount");
		System.out.println("Print Purchase Amount: "+purchaseAmount);
	
	//3. Print Title of the first course	
		String bookName =js.get("courses[0].title");
		System.out.println("Print Title of the first course: "+bookName);
	
	//4. Print All course titles and their respective Prices
		
		for (int i=0; i<count;i++)
		{
			String courseTitle= js.get("courses["+i+"].title");
			System.out.println("Print All course titles: "+courseTitle);
			int coursePrice= js.getInt("courses["+i+"].price");
			System.out.println("Print All course price: "+coursePrice);
		}
		
	//5. Print no of copies sold by RPA Course
		for (int i=0; i<count;i++)
		{
			String courseTitle= js.get("courses["+i+"].title");
			
			if (courseTitle.equalsIgnoreCase("RPA"))
			{
				System.out.println("The course is : "+courseTitle);
				int coursePrice= js.getInt("courses["+i+"].copies");
				System.out.println("Print no of copies sold by RPA Course: "+coursePrice);
				break;
			}
		
		}
		
//		6. Verify if Sum of all Course prices matches with Purchase Amount	
		int sum=0;
			for(int j=0;j<count;j++){
			int coursePrice=	js.getInt("courses["+j+"].price");
			int courseCopies=	js.getInt("courses["+j+"].copies");
			int amount=coursePrice*courseCopies;
			sum=sum+amount;
			System.out.println(amount);
			}
			
			System.out.println("Sum of all Course prices matches with Purchase Amount: "+sum);
			
			Assert.assertEquals(js.getInt("dashboard.purchaseAmount"), sum);
			System.out.println("Verified the Sum of all Course prices matches with Purchase Amount ");
		
	}

}
