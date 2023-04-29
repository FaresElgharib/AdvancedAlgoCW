package cw;

import java.util.*;

public class Q6SpellChecker {
    private Set<String> lexicon;

    public Q6SpellChecker(Set<String> lexicon) {
        this.lexicon = lexicon;
    }

    public List<String> check(String s) {
        List<String> results = new ArrayList<>();
        if (lexicon.contains(s)) {
            results.add(s);
        } else {
            results.addAll(transpose(s));
            results.addAll(insert(s));
            results.addAll(delete(s));
            results.addAll(replace(s));
        }
        return results;
    }

    private List<String> transpose(String s) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char[] chars = s.toCharArray();
            char temp = chars[i];
            chars[i] = chars[i+1];
            chars[i+1] = temp;
            String candidate = new String(chars);
            if (lexicon.contains(candidate)) {
                results.add(candidate);
            }
        }
        return results;
    }

    private List<String> insert(String s) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String candidate = s.substring(0, i) + c + s.substring(i);
                if (lexicon.contains(candidate)) {
                    results.add(candidate);
                }
            }
        }
        return results;
    }

    private List<String> delete(String s) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String candidate = s.substring(0, i) + s.substring(i+1);
            if (lexicon.contains(candidate)) {
                results.add(candidate);
            }
        }
        return results;
    }

    private List<String> replace(String s) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String candidate = s.substring(0, i) + c + s.substring(i+1);
                if (lexicon.contains(candidate)) {
                    results.add(candidate);
                }
            }
        }
        return results;
    }
    
    public static void main(String[] args) {
        Set<String> lexicon = new HashSet<>(Arrays.asList("cat", "dog", "bird", "fish", "rabbit"));

        Q6SpellChecker spellChecker = new Q6SpellChecker(lexicon);

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
