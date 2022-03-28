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
        System.out.println("--- Using a HashTable ---");
        System.out.println(isUniqueWithHashtable(str1));
        System.out.println(isUniqueWithHashtable(str2));

        // Check strings using bit vector.
        System.out.println("--- Using a Bit Vector ---");
        System.out.println(isUniqueWithBitVector(str1));
        System.out.println(isUniqueWithBitVector(str2));

        // Check strings using bit vector.
        System.out.println("--- Using no Data Structure ---");
        System.out.println(isUniqueWithNoDS(str1));
        System.out.println(isUniqueWithNoDS(str2));
    }

    /**
     * IsUniqueWithHashtable() checks if the string that is given is unique or not, and also if it has zero characters.
     * Implements a simple Hashtable(Character, Integer).
     * @param str the string to be checked
     * @return a statement of the string
     */
    public static String isUniqueWithHashtable(String str) {
        // Check if string has zero characters.
        if (str.length() == 0)
            return "The string has zero characters";

        // Check if string has more than 128 characters, because we can't form a string with more than 128 unique characters.
        if (str.length() > 128)
            return "The string:" + str + " is NOT unique.";

        // Creating a hashtable and iterating through all characters of the string, if a character found again it exits.
        Hashtable<Character, Integer> hashMap = new Hashtable<>();
        for (char c: str.toCharArray()) {
            if (hashMap.containsKey(c)) {
                return "The string:" + str + " is NOT unique";
            } else {
                hashMap.put(c, 1);
            }
        }

        // If the before iteration ends with no exiting, then the string has unique characters.
        return "The string:" + str + " is unique";
    }

    /**
     * Solution provided by the book.
     * IsUniqueWithBitVector() checks if the string that is given is unique or not, and also if it has zero characters.
     * A method that finds duplicates in a string by using the low level bit logic.
     * Checker will become an array of 32 bits.
     * Checks if the results of logical AND will be greater than zero thus there gas already a bit set as true,
     * telling us that the character with index bit + 'a' already exists.
     * Checker |= (1 << val), sets the vit at position val + 'a', to true, meaning that this bit exists, for feature if lookups.
     * @param str the string to be checked
     * @return a statement of the string
     */
    public static String isUniqueWithBitVector(String str) {
        // Check if string has zero characters.
        if (str.length() == 0)
            return "The string has zero characters";

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return "The string:" + str + " is NOT unique.";
            }
            checker |= (1 << val);
        }

        return "The string:" + str + " is unique.";
    }

    /**
     * isUniqueWithNoDS() checks if the string that is given is unique or not, and also if it has zero characters.
     * A method that uses no addition data structure, by using a boolean array.
     * @param str the string to be checked
     * @return a statement of the string
     */
    public static String isUniqueWithNoDS(String str) {
        // Check if string has zero characters.
        if (str.length() == 0)
            return "The string has zero characters";

        // Check if string has more than 128 characters, because we can't form a string with more than 128 unique characters.
        if (str.length() > 128)
            return "The string:" + str + " is NOT unique.";

        // Creating a boolean array (with all false), for every character we make it true, if we rediscover it then we have a duplicate.
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int tempVal = str.charAt(i);
            if (charSet[tempVal]) {
                return "The string:" + str + " is NOT unique.";
            }
            charSet[tempVal] = true;
        }

        return "The string:" + str + " is unique.";
    }

}
