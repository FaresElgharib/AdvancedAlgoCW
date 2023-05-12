package cw;

import java.util.*;

public class Q6SpellChecker {
    private Set<String> lexicon;

    public Q6SpellChecker(Set<String> lexicon) {
        this.lexicon = lexicon;
    }

    public List<String> check(String s) {
        List<String> results = new ArrayList<>();
         // Checks if the input string is in the lexicon
        if (lexicon.contains(s)) {
            results.add(s);
        } else {
            // Creating the corrections
            results.addAll(transpose(s));
            results.addAll(insert(s));
            results.addAll(delete(s));
            results.addAll(replace(s));
        }
        return results;
    }
    // Tranpose creates the corrections by swapping adjancet letters
    private List<String> transpose(String s) {
        List<String> results = new ArrayList<>();
        // Looping through the string and swapping the letters
        for (int i = 0; i < s.length() - 1; i++) {
            char[] chars = s.toCharArray();
            char temp = chars[i];
            chars[i] = chars[i+1];
            chars[i+1] = temp;
            String candidate = new String(chars);
            // Checks if the correction is in the lexicon
            if (lexicon.contains(candidate)) {
                results.add(candidate);
            }
        }
        return results;
    }
    // Insert creates the corrections by adding new letters
    private List<String> insert(String s) {
        List<String> results = new ArrayList<>();
        // Looping through the string and adding letters
        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String candidate = s.substring(0, i) + c + s.substring(i);
                // Checks if the correction is in the lexicon
                if (lexicon.contains(candidate)) {
                    results.add(candidate);
                }
            }
        }
        return results;
    }
    // Delete creates the corrections by deleting letters
    private List<String> delete(String s) {
        List<String> results = new ArrayList<>();
        // Looping through the string and deleting each letter
        for (int i = 0; i < s.length(); i++) {
            String candidate = s.substring(0, i) + s.substring(i+1);
            // Checks if the correction is in the lexicon
            if (lexicon.contains(candidate)) {
                results.add(candidate);
            }
        }
        return results;
    }
    // Replace creates the corrections by replacing letters
    private List<String> replace(String s) {
        List<String> results = new ArrayList<>();
        // Looping through the string and replacing the letters
        for (int i = 0; i < s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String candidate = s.substring(0, i) + c + s.substring(i+1);
                // Checks if the correction is in the lexicon
                if (lexicon.contains(candidate)) {
                    results.add(candidate);
                }
            }
        }
        return results;
    }
    
    public static void main(String[] args) {
        // Lexicon
        Set<String> lexicon = new HashSet<>(Arrays.asList("cat", "dog", "bird", "fish", "rabbit"));
    
        // Creating an object of the Spell Checker class
        Q6SpellChecker spellChecker = new Q6SpellChecker(lexicon);
        
        // Running the code
        String input1 = "dog";
        System.out.println("Checking \"" + input1 + "\": " + spellChecker.check(input1));

        String input2 = "dtog";
        System.out.println("Checking \"" + input2 + "\": " + spellChecker.check(input2));

        String input3 = "catz";
        System.out.println("Checking \"" + input3 + "\": " + spellChecker.check(input3));
        
        String input4 = "qat";
        System.out.println("Checking \"" + input4 + "\": " + spellChecker.check(input4));
    }

}
