package leetcode.easy;

/**
 * LeetCode Easy 2114. Maximum Number of Words Found in Sentences
 */
public class MaximumNumberofWordsFoundinSentences {

    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {

            String[] aa = sentence.split(" ");

            if(sentence.split(" ").length > max){
                max = sentence.split(" ").length;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"});
    }
}
