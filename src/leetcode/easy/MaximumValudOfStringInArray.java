package leetcode.easy;

/**
 * 2496. Maximum Value of a String in an Array
 */
public class MaximumValudOfStringInArray {

    public static int maximumValue(String[] strs) {
        int max = 0;
        for (String s : strs) {
            boolean onlyDigits = s.chars().allMatch(Character::isDigit);
            if (onlyDigits) max = Math.max(max, Integer.valueOf(s));
            else max = Math.max(max, s.length());
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumValue(new String[]{"alic3","bob","3","4","00000"})); //5
        System.out.println(maximumValue(new String[]{"1","01","001","0001"})); //1
    }
}
