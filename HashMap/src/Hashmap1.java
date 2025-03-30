import java.util.HashMap;

public class Hashmap1 {

	public static void main(String[] args) {
		
    test();
	}

	public static void test() {
		System.out.println("hello");
		
		String name ="Raj Karan Chauhan Raj Laxmi";
		String []names=name.split(" ");
		System.out.println(names[names.length-1]);
		
		HashMap<String,Integer> map= new HashMap<>();
		
		System.out.println(map.isEmpty());
		
		for(String  i: names) {

				if(!map.containsKey(i)) {
					map.put(i, 1);
				}
				else{
					map.put(i, map.get(i)+1);
				}
			
		}
		
		for(String j: map.keySet()) {
			
			if(map.get(j)>1) {
				System.out.println("Duplicate values is :" + j + " by count " +map.get(j));
			}
		}
	}
	
}
