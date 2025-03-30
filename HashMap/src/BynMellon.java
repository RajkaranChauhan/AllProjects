
import java.io.*;
	import java.util.*;
	//import javafx.util.Pair;
public class BynMellon {
	/*
	You are running a classroom and suspect that some of your students are passing around the answer to a multiple-choice question disguised as a random note.

	Your task is to write a function that, given a list of words and a note, finds and returns the word in the list that is scrambled inside the note, if any exists. If none exist, it returns the result "-" as a string. There will be at most one matching word. The letters don't need to be in order or next to each other. The letters cannot be reused.

	Example:  
	words = ["baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"]
	note1 = "ctay"
	find(words, note1) => "cat"   (the letters do not have to be in order)  
	  
	note2 = "bcanihjsrrrferet"
	find(words, note2) => "cat"   (the letters do not have to be together)  
	  
	note3 = "tbaykkjlga"
	find(words, note3) => "-"     (the letters cannot be reused)  
	  
	note4 = "bbbblkkjbaby"
	find(words, note4) => "baby"    
	  
	note5 = "dad"
	find(words, note5) => "-"    
	  
	note6 = "breadmaking"
	find(words, note6) => "bird"    

	note7 = "dadaa"
	find(words, note7) => "dada"    

	All Test Cases:
	find(words, note1) -> "cat"
	find(words, note2) -> "cat"
	find(words, note3) -> "-"
	find(words, note4) -> "baby"
	find(words, note5) -> "-"
	find(words, note6) -> "bird"
	find(words, note7) -> "dada"
	  
	Complexity analysis variables:  
	  
	W = number of words in `words`  
	S = maximal length of each word or of the note  
	*/

	

	
	  public static void main(String[] argv) {    
	    String[] words = {"baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"};
	  //  String[] words = {"baby",  "cat"};
	    String note1 = "ctay";
	    String note2 = "bcanihjsrrrferet";
	    String note3 = "tbaykkjlga";
	    String note4 = "bbbblkkjbaby";
	    String note5 = "dad";
	    String note6 = "breadmaking";
	    String note7 = "dadaa";
	    
	    solution(words, note3);
	    
	    
	  }
	  public static void  solution(String[] words,String note1)
	    {
		  HashMap<String,Integer> mapWords=new HashMap<>();
		  HashMap<String,Integer> mapNote=new HashMap<>();
		  String[] note=note1.split("");
		  int count =0;
		  
		  for(String x:note) {
			  if(!mapNote.containsKey(x)) {
				  mapNote.put(x, 1);
			  }
			  else {
				  mapNote.put(x, mapNote.get(x)+1);
			  }
			  
		  }
		//  System.out.println("Note is : "+ note1);
		//  System.out.println(mapNote);
		 // System.out.println("*/*/*"+ mapNote.size());
		  
		  
		  
		  for(String i: words) {
			  
			  String[] wordsSplit=i.split("");
			  
			 for(String j:wordsSplit) {
			  
			  if(!mapWords.containsKey(j)) {
				  mapWords.put(j, 1);
			  }
			  else {
				  mapWords.put(j, mapWords.get(j)+1);
			  }
			  
			 }
		//	 System.out.println(i);
		//	 System.out.println(mapWords);
			 
			 
			 for(String y: mapWords.keySet()) {
			 
				// System.out.println("***"+ y);
				 
				 if(mapNote.containsKey(y)) {
					// System.out.println(true);
					//System.out.println(mapNote.get(y));
					//System.out.println(mapWords.get(y));
					if(mapNote.get(y)>=mapWords.get(y)) {
						//System.out.println(y +" MapNote "+ mapNote.get(y) );
						//System.out.println(y +" MapWords "+ mapWords.get(y) );
						count=count+1; 
					}
				 }
				 else {
					// System.out.println(false);
					 count=0;
					 break;
				 }
				 
			 }
			// System.out.println(count + " value of count");
			// System.out.println((mapWords.size()) + " value of lenght  " +i);
			 if (count ==(mapWords.size())) {
				 System.out.println("Note is : "+ note1 + " and is matching with word " +i);
				// System.out.println(count + " value of count");
				 count=0;
				 
				 
				 }
				 else {
					 System.out.println("Note is : "+ note1 + " and is NOTTTT matching with word "+i);
					 count=0;
				 }
			 
			 
			 mapWords.clear();
		  }
		  
	    }

	}
	  


