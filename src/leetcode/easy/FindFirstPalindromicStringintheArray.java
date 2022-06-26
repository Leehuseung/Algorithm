package leetcode.easy;

/**
 * 2108. Find First Palindromic String in the Array
 */
public class FindFirstPalindromicStringintheArray {
    public static String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            boolean b = true;
            for (int j = 0; j < s.length()/2; j++) {
                if(s.charAt(j) != s.charAt(s.length()-1-j)){
                    b = false;
                }
            }
            if(b){
                return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[]{"abc","car","ada","racecar","cool"})); // "ada"
        System.out.println(firstPalindrome(new String[]{"notapalindrome","racecar"})); // "racecar"
        System.out.println(firstPalindrome(new String[]{"def","ghi"})); // ""
    }
}
