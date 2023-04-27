package cw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1 {

	public static char[] removeDuplicates(char[] input) {
	    Set<Character> set = new HashSet<>();
	    List<Character> result = new ArrayList<>();

	    for (char c : input) {
	        if (!set.contains(c)) {
	            set.add(c);
	            result.add(c);
	        }
	    }

	    char[] output = new char[result.size()];
	    for (int i = 0; i < result.size(); i++) {
	        output[i] = result.get(i);
	    }

	    return output;
	}
	
	public static void main(String[] args) {
		char[] input = {'a', 'b', 'c', 'a', 'd', 'c', 'e'};
		char[] result = removeDuplicates(input);
		System.out.println(Arrays.toString(result)); // prints [a, b, c, d, e]

	}

}
