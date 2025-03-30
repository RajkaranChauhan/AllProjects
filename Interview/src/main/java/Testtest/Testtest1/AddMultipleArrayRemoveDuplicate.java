package Testtest.Testtest1;

import java.util.*;

public class AddMultipleArrayRemoveDuplicate {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {4, 5, 3};
		int[] arr3 = {5, 6, 7};

		//	List<int[]> arr01 = Arrays.asList(arr1);
		//	ArrayList<Integer> ar=new ArrayList<Integer>(arr01);

		/// ///Using HASHSET
		System.out.println("Using HASHSET");
		HashSet<Integer> se = new HashSet<Integer>();

		for (int x : arr1) {
			se.add(x);
		}
		System.out.println(se);
		for (int x : arr2) {
			se.add(x);
		}
		System.out.println(se);
		for (int x : arr3) {
			se.add(x);
		}
		System.out.println(se);


	}
}