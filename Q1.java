package cw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1 {

	public static char[] removeDuplicates(char[] input) {
	    // Creating a HashSet to store the unique chars
	    Set<Character> set = new HashSet<>();
	    // Creating an array to storre the unique chars
	    List<Character> result = new ArrayList<>();

	    // Looping through the chars in the input array
	    for (char c : input) {
		// Checking if the char is already in the set
	        if (!set.contains(c)) {
	            set.add(c);
	            result.add(c);
	        }
	    }

	    // Creating a new char array with the right size
	    char[] output = new char[result.size()];
	    // Adding the chars from the result list to the array
	    for (int i = 0; i < result.size(); i++) {
	        output[i] = result.get(i);
	    }

	    return output;
	}
	
	public static void main(String[] args) {
		// Running the code
		char[] input = {'a', 'b', 'c', 'a', 'd', 'c', 'e'};
		char[] result = removeDuplicates(input);
		System.out.println(Arrays.toString(result));

	}

}
