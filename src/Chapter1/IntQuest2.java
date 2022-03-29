package Chapter1;

import java.util.*;

/**
 * The IntQuest2 program implemented in Java for learning purposes.
 *
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 *
 * Hints:#1, #84, #122, #131
 *
 * #1: Describe what it means for two strings to be permutations of each other. Now look at that definition you provided.
 * Can you check the string against that definition?
 * #84: There is one solution that is O(N log N) time. Another solution uses some space, but is O(N) time.
 * #122: Could a hash table be useful?
 * #131: Two strings that are permutations should have the same characters, but in different orders. Can you make the
 * orders the same?
 *
 * @author Evanthios Papadopoulos
 * @since 29-Mar-22
 **/

public class IntQuest2 {

    public static void main(String[] args) {
        String str1 = "asdfghjkl";
        String str2 = "fghjklasd";

        System.out.println(checkPermutationWithHashTable(str1, str2));
    }

    /**
     * CheckPermutationWithHashTable() takes two strings and the method checks if these two strings are permutation of
     * each other. We check for difference in lengths or zero characters on either of the strings. Then with the use of
     * hash table with check the permutation.
     * @param str1 first string
     * @param str2 second string
     * @return a string with the appropriate information.
     */
    public static String checkPermutationWithHashTable(String str1, String str2) {
        // Check if string has the same number of characters and if one of them has zero characters to exit.
        if (str1.length() != str2.length() || str1.length() == 0)
            return "The string are NOT permutations to each other. Zero characters or different lengths detected.";

        // Check if the string are exactly the same.
        if (str1.equals(str2))
            return "The strings are permutations to each other.";

        // Refactoring to lower case the two strings to compare them.
        str1 = str1.toLowerCase(Locale.ROOT);
        str2 = str2.toLowerCase(Locale.ROOT);

        // Adding the first string's characters to a hash table.
        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        for (char c : str1.toCharArray())
            if (hashtable.containsKey(c)){
                int numberOfTimes = hashtable.get(c);
                hashtable.put(c, numberOfTimes + 1);
            }else{
                hashtable.put(c, 1);
            }

        // Decrement the characters of the second string from the hash table that contains the characters of the first string.
        // If there are no more characters of the same character on the hash table then we remove the character.
        for (char c : str2.toCharArray())
            if (hashtable.containsKey(c)){
                int numberOfTime = hashtable.get(c);
                if (numberOfTime == 1)
                    hashtable.remove(c);
                else
                    hashtable.put(c, numberOfTime - 1);
            }

        // If the hash table is empty then we have a permutation.
        if (hashtable.isEmpty())
            return "The strings are permutations of each other.";
        else
            return "The strings are NOT permutations of each other.";
    }

}
