
public class Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Method a= new Method();
		Method2 b=new Method2();
		a.myMethod();
		
		String returnM=a.myMethod1();
		
		System.out.println(returnM);
		
		b.myMethod2();
		
		
		////// user can call this method without the object creation directly by method name
		Method2();
		

	}

	public void myMethod()
	{
		System.out.println("Method called");
	}
	
	public String myMethod1()
	{
		System.out.println("Method1 called");
		return "return type of method1";
	}
	
	//creating a method which will be indipendent of object, for that the method should be static. static methods will be linked to class not to the object
	
	public static void Method2()
	{
		System.out.println("This is static method");
	}
	
}
