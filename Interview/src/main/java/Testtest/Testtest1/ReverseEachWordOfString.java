package Testtest.Testtest1;


public class ReverseEachWordOfString {
	
	

	public static void main(String[] args) {
		
		
		String a="Welcome to Dubai Habibi";
		String word;
		char c;
		String rev="";
		String[] b = a.split(" ");
		 //System.out.println(b[1]);
		String finalll="";
		for(int i=0;i<b.length;i++)
		{
			 word=b[i];//i=0 Welcome
			 
			 System.out.println(word);
			 
			 for(int j=word.length()-1;j>=0;j--)
			 {
				 //System.out.println(word.charAt(j));
				 
				c= word.charAt(j); //em
				rev=rev+c;  //em
				 
			 }
			
			 finalll= finalll+rev;
			 rev=" ";
		}
		System.out.println(finalll);
		
		
		
		
		
		
		
		
	}

}
