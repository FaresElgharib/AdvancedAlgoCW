package cw;

import java.util.HashSet;
import java.util.Set;

public class Q2 {

	public static boolean sameSet(int[] arr1, int[] arr2) {
	    Set<Integer> set1 = new HashSet<>();
	    Set<Integer> set2 = new HashSet<>();

	    for (int i = 0; i < arr1.length; i++) {
	        set1.add(arr1[i]);
	    }

	    for (int i = 0; i < arr2.length; i++) {
	        set2.add(arr2[i]);
	    }

	    return set1.equals(set2);
	}

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {5, 4, 3, 2, 2};

		if (sameSet(arr1, arr2)) {
		    System.out.println("The arrays contain the same set of numbers.");
		} else {
		    System.out.println("The arrays do not contain the same set of numbers.");
		}
	}
}
