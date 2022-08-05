package leetcode.easy;

/**
 * 2124. Check if All A's Appears Before All B's
 */
public class CheckIfAllAsAppearsBeforeAllB {
    public static boolean checkString(String s) {
        return !s.contains("ba");
    }
    public static void main(String[] args) {
        System.out.println(checkString("aaabbb")); //true
        System.out.println(checkString("abab")); //false
        System.out.println(checkString("bbb")); //true

    }
}
