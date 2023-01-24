package leetcode.easy;

/**
 * 1332. Remove Palindromic Subsequences
 */
public class RemovePalindromicSubsequences {
    public static int removePalindromeSub(String s) {
        if(isPalindromic(s)){
            return 1;
        }
        return 2;
    }

    private static boolean isPalindromic(String substring) {
        StringBuilder builder = new StringBuilder(substring);
        builder.reverse();
        return substring.equals(builder.toString());
    }

    public static void main(String[] args) {
        System.out.println(removePalindromeSub("ababa"));   //1
        System.out.println(removePalindromeSub("abb"));     //2
        System.out.println(removePalindromeSub("baabb"));   //2
        System.out.println(removePalindromeSub("bbaabaaa"));// 1

    }
}
