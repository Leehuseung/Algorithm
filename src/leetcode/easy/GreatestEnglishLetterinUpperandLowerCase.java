package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2309. Greatest English Letter in Upper and Lower Case
 */
public class GreatestEnglishLetterinUpperandLowerCase {
    public static String greatestLetter(String s) {
        char[] chars = s.toCharArray();
        Set<Integer> set = new HashSet<>();
        for (char aChar : chars) {
            set.add((int)aChar);
        }

        for (int i = 96; i >= 65; i--) {
            if(set.contains(i) && set.contains(i+32)){
                return String.valueOf((char)i);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(greatestLetter("lEeTcOdE")); //E
        System.out.println(greatestLetter("arRAzFif")); //R
        System.out.println(greatestLetter("AbCdEfGhIjK")); //""
    }
}
