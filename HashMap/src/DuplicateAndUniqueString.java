import java.util.HashMap;

public class DuplicateAndUniqueString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string= "sapan amit rahul amit romil sapan rohan rahul sarraf chanda raj  laxmi laxmi laxmi laxmi";
		String[] names=string.split(" ");
		//System.out.println(names[0]);
		HashMap<String, Integer> map=new HashMap<>();
		
		for(String i:names) {
			//System.out.println(i);
			if(!map.containsKey(i)) {
				map.put(i, 1);
			}
			else {
				map.put(i, map.get(i)+1);
			}
		}
		System.out.println(map);
	
		for(String j:map.keySet()) {
			if(map.get(j)>1) {
				System.out.println("duplicate: "+j +" and count is: "+map.get(j));
			}
			else {
			System.out.println("unique: "+j);
			}
		}

	}

}
