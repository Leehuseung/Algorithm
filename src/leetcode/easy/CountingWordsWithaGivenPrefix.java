package leetcode.easy;

/**
 * 2185. Counting Words With a Given Prefix
 */
public class CountingWordsWithaGivenPrefix {
    public static int prefixCount(String[] words, String pref) {
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[i].startsWith(pref)){
                answer++;
            }
        }
        return answer;
    }
}
