package leetcode.easy;

/**
 * LeetCode 1844. Replace All Digits with Characters
 */
public class ReplaceAllDigitswithCharacters {
    public static String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(i % 2 == 1){
                int shift = Integer.parseInt(String.valueOf(arr[i]));
                arr[i] = (char) (arr[i-1] + shift);
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(replaceDigits("a1c1e1")); //abcdef
        System.out.println(replaceDigits("a1b2c3d4e")); //abbdcfdhe
    }
}
