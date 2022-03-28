package Chapter1;

import java.util.Hashtable;

/**
 * The IntQuest1 program implemented in Java for learning purposes.
 *
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use
 * additional data structures?
 *
 * Hints:#44, #117, #132
 *
 * #44: Try a hash table.
 * #117: Could a bit vector be useful?
 * #132: Can you solve it in O(N log N) time? What might a solution like that look like?
 *
 * @author Evanthios Papadopoulos
 * @since 28-Mar-22
 **/

public class IntQuest1 {

    public static void main(String[] args) {
        String str1 = "asdfghjkl";
        String str2 = "asdasdasd";

        // Check strings using hashtable.
        System.out.println(isUniqueWithHashtable(str1));
        System.out.println(isUniqueWithHashtable(str2));

    }

    /**
     * IsUnique() checks if the string that is given is unique or not, and also if it has zero characters.
     * Implements a simple Hashtable(Character, Integer).
     * @param str the string to be checked
     * @return a statement of the string
     */
    public static String isUniqueWithHashtable(String str) {
        // Check if string has zero characters.
        if (str.length() == 0)
            return "The string has zero characters";

        // Creating a hashtable and iterating through all characters of the string, if a character found again it exits.
        Hashtable<Character, Integer> hashMap = new Hashtable<>();
        for (char c: str.toCharArray()) {
            if (hashMap.containsKey(c)) {
                return "The string:" + str + " in NOT unique";
            } else {
                hashMap.put(c, 1);
            }
        }

        // If the before iteration ends with no exiting, then the string has unique characters.
        return "The string:" + str + " in unique";
    }

}
