package leetcode.easy;

/**
 * LeetCode 1816. Truncate Sentence
 */
public class TruncateSentence {

    public static String truncateSentence(String s, int k) {
        String answer = "";

        String[] arr = s.split(" ");

        for (int i = 0; i < k; i++) {
            answer += arr[i];
            if(i != k-1){
                answer += " ";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant",4)); // Hello how are you
        System.out.println(truncateSentence("What is the solution to this problem",4)); // what is the solution
    }
}
