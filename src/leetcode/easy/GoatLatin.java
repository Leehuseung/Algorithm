package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 824. Goat Latin
 */
public class GoatLatin {
    public static String toGoatLatin(String S) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String res = "";
        int i = 0, j = 0;
        for (String w : S.split("\\s")) {
            res += ' ' + (vowels.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
            for (j = 0, ++i; j < i; ++j) {
                res += "a";
            }
        };
        return res.substring(1);
    }
    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }
}
