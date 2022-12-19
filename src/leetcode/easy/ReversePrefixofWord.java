package leetcode.easy;

/**
 * 2000. Reverse Prefix of Word
 */
public class ReversePrefixofWord {

    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        StringBuilder sb = new StringBuilder(word.substring(0,index+1));
        sb.reverse();
        return sb.toString() + word.substring(index+1);
    }


    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd",'d')); // dcbaefd
        System.out.println(reversePrefix("xyxzxe",'z')); // zxyxxe
        System.out.println(reversePrefix("abcd",'z')); // abcd
    }
}
