package Chapter1;

import java.util.Objects;

/**
 * The IntQuest3 program implemented in Java for learning purposes.
 *
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
 * space at the end to hold the addition characters, and that you are given the "true" length of the string. (Note: If
 * implementing in Java, please use a character array so that you can perform this operation in place.)
 * EXAMPLE:
 * input:   "Mr John Smith    ", 13
 * Output:  "Mr%20John%20Smith"
 *
 * Hints: #53, #118
 *
 * #53: It's often easiest to modify strings by going from the end of the string got the beginning.
 * #118: You might find you need to know the number of spaces. Can you just count them?
 *
 * @author Evanthios Papadopoulos
 * @since 29-Mar-22
 **/

public class IntQuest3 {

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        String str1 = "Mr John Smith";
        String str2 = " Mr John      ";

        System.out.println(urlify(str));
        System.out.println(urlify(str1));
        System.out.println(urlify(str2));
    }

    /**
     * Urlify() takes a string, we first check for zero characters and then we count the characters that are not spaces.
     * We create a new string with the help of the StringBuilder and create a new string with the reformed data.
     * @param str string to reform
     * @return a string with the appropriate information.
     */
    public static String urlify(String str){
        // Check for zero string's characters.
        if (str.length() == 0)
            return "The string has zero characters.";

        // Counter for the number of characters that are not spaces.
        int charCounter = 0;
        for (char c : str.toCharArray())
            if (c != ' ')
                charCounter++;

        // StringBuilder new string, if space detected then we add the '%20' or the character of the string. When we hit
        // the last character with the counter of characters, we break because we know that the rest of the string is
        // going to contain spaces.
        StringBuilder newString = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ' ')
                newString.append("%20");
            else {
                charCounter--;
                newString.append(c);
                if (charCounter == 0)
                    break;
            }
        }

        // If the string builder string begins with '%20' we remove it from the beginning.
        if (Objects.equals(newString.substring(0, 3), "%20"))
            newString.replace(0, 3, "");

        return newString.toString();
    }

}
