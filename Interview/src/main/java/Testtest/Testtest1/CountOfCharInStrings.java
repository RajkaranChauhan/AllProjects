package Testtest.Testtest1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CountOfCharInStrings {

	public static void main(String[] args) {

//		String text="aaaabbbccd";
//		String text1="";
//		String text2="";
//
//		int count=0;
//		int size= text.length();
//		for (int i=0;i<size;i++)
//		{
//
//			for (int j=i;j<size;j++)
//			{
//				if(	text.charAt(i)==text.charAt(j))
//
//				{
//					count =count+1;
//				}
//			}
//			text1=text1+text.charAt(i);
//			//System.out.println(text1);
//			if (text2.contains(text1))
//			{
//
//
//				//System.out.println("skip");
//			}
//			else
//			{
//				text2=text2+text1;
//
//				//System.out.println(text2);
//				System.out.println(text.charAt(i) +":"+ count);
//
//			}
//
//			count=0;
//			text1="";
//		}
//
		String text="aaaabbbccd";
		char charValue;
		int charCount;

		char maxValue;
		int maxCharCount;
		char[] charText = text.toLowerCase().toCharArray();
		HashMap<Character, Integer> map= new HashMap<Character, Integer>();

		for(char c:charText){
			map.put(c,map.getOrDefault(c,0)+1);
		}
		System.out.println(map);


			Set<Map.Entry<Character, Integer>> map1 = map.entrySet();
			Iterator<Map.Entry<Character, Integer>> iterator = map1.iterator();
			while (iterator.hasNext()) {
				Map.Entry<Character, Integer> next = iterator.next();
				charValue = next.getKey();
				charCount = next.getValue();
				System.out.println(charValue + " : " + charCount);

			}




	}



}
