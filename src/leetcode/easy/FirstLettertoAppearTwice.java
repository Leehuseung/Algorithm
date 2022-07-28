package leetcode.easy;

import java.util.*;

/**
 * 2351. First Letter to Appear Twice
 */
public class FirstLettertoAppearTwice {
    public static char repeatedCharacter(String s) {
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])){
                return arr[i];
            } else {
                set.add(arr[i]);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(repeatedCharacter("abccbaacz"));  // c
        System.out.println(repeatedCharacter("abcdd"));  // d
        System.out.println(repeatedCharacter("nwcn"));  // n
        System.out.println(repeatedCharacter("jkodgypoya"));  // o

    }
}
