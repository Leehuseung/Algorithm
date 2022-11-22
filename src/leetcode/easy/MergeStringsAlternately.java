package leetcode.easy;

/**
 * 1768. Merge Strings Alternately
 */
public class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {
        String answer = "";
        for (int i = 0; i < Math.max(word1.length(),word2.length()); i++) {
            if(i < word1.length()){
                answer += word1.charAt(i);
            }
            if(i < word2.length()){
                answer += word2.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc","pqr"));  //apbqcr
        System.out.println(mergeAlternately("abcd","pq"));  //apbqcr
    }
}
