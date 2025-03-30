package Testtest.Testtest1;

public class getterSetter {
	
private		String name;
private 	int quantiyt;
	
	public void setName(String name) 
	{
		this.name=name;
	}
	
	public String  getName() 
	{
		return name;
	}
	
	public void setQuantity(int quantiyt) 
	{
		this.quantiyt=quantiyt;
	}
	
	public int  getQuantiyt() 
	{
		if (quantiyt<1)
		{
			this.quantiyt=1;
		}
		
		return quantiyt;
	}
	
	
	
	//
	//some code to set the values in getter setter from them to run the program

}
