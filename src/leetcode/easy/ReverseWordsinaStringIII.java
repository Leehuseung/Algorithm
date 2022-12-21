package leetcode.easy;

/**
 * LeetCode 557. Reverse Words in a String III
 */
public class ReverseWordsinaStringIII {
    public static String reverseWords(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            char[] carr = arr[i].toCharArray();
            for (int j = carr.length-1; j >=0 ; j--) {
                answer += carr[j];
            }
            if(i != arr.length-1){
                answer += " ";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest")); // "s'teL ekat edoCteeL tsetnoc"
        System.out.println(reverseWords("God Ding")); // "doG gniD"

    }
}
