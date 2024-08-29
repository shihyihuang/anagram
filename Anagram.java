
import java.util.*;

/** Given a list of words from an English dictionary and a word, 
 * return a set of words in the dictionary that are anagrams of the word. 
 * An anagram of a word is formed by rearranging the letters of the original word. 
 * For example, east is an anagram of seat. */

/**
 * Time complexity:
 * Loop through each character in the target String to create a map: O(t1)
 * Loop through each String in the input list and create a map O(t2*t3)
 * Total time complexity: O(t1 + t2*t3)
 */

/**
 * Space complexity:
 * result: the number of found anagrams, O(s1)
 * targetMap: unique chars in the target string, O(s2)
 * testMap: the number of unique chars in the iterated string * the number of
 * strings in testList, O(s3*s4)
 * Total space complexity: O(s1 + s2 + s3*s4)
 */

public class Anagram {

    private static Set<String> anagram(String[] testList, String target) {

        HashSet<String> result = new HashSet<>();
        Map<Character, Integer> targetMap = new HashMap<>();

        // Turn target into a map with character and corresponding count
        for (char c : target.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Loop through each String within the test list
        for (String s : testList) {

            // Turn string into a map with character and corresponding count
            Map<Character, Integer> testMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                testMap.put(c, testMap.getOrDefault(c, 0) + 1);
            }

            // Compare the maps
            if (targetMap.equals(testMap)) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] testList = { "east", "aste", "freelancer", "aaaste", "teas" };
        String target = "seat";
        System.out.println(anagram(testList, target));
    }
}
