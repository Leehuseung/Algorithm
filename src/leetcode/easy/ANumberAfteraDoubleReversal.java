package leetcode.easy;

/**
 * LeetCode 2119. A Number After a Double Reversal
 */
public class ANumberAfteraDoubleReversal {

    public static boolean isSameAfterReversals(int num) {
        if(num == 0) return true;
        String s = num + "";
        if(s.lastIndexOf("0") == s.length()-1) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSameAfterReversals(526));  //true
        System.out.println(isSameAfterReversals(1800)); //false
        System.out.println(isSameAfterReversals(0));
    }
}
