import java.util.HashMap;

public class OccuranceOfCharacter {
	public static void main(String[] args) {
		
	    test();
		}

		public static void test() {
			String str="strangerthings";
			String[] name=str.split("");
			
			System.out.println(name[0]);
			
			HashMap<String,Integer> map=new HashMap<>();
			for(String  i: name) {
				//System.out.println(i);
				if(!map.containsKey(i)) {
					map.put(i, 1);
				}
				else {
					map.put(i, map.get(i)+1);
				}
			}
			
			for(String j:map.keySet()) {
				System.out.println("The occurance of the character " + j + " in the string is : "+ map.get(j));
			}
		}
}
