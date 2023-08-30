package leetcode.top.interview;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        char[] chars = s.trim().toCharArray();
        int result = 0;
        for (int i = chars.length-1; i >= 0 ; i--) {
            if (chars[i] == ' '){
                return result;
            }
            result++;
        }
        return result;
    }
    public static int lengthOfLastWord1(String s) {
        String[] a = s.split(" ");
        return a[a.length-1].length();
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World")); // 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); //
    }
}
