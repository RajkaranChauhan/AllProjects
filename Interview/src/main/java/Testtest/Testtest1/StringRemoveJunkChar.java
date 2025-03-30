package Testtest.Testtest1;

public class StringRemoveJunkChar {

	public static void main(String[] args) {
		String s="$^^$%^ raj ^&** Karan&9";
		s=s.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s);

	}

}
