package cw;

import java.util.HashSet;
import java.util.Set;

public class Q2 {

	public static boolean sameSet(int[] arr1, int[] arr2) {
	    // Create 2 HashSets to store the unique elements
	    Set<Integer> set1 = new HashSet<>();
	    Set<Integer> set2 = new HashSet<>();

	    // Adding the elements from the arrays to the sets
	    for (int i = 0; i < arr1.length; i++) {
	        set1.add(arr1[i]);
	    }

	    for (int i = 0; i < arr2.length; i++) {
	        set2.add(arr2[i]);
	    }

	   // Checking if the sets are equal
	    return set1.equals(set2);
	}

	public static void main(String[] args) {
		// Running the code
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {5, 4, 3, 2, 2};

		if (sameSet(arr1, arr2)) {
		    System.out.println("The arrays contain the same set of numbers.");
		} else {
		    System.out.println("The arrays do not contain the same set of numbers.");
		}
	}
}
