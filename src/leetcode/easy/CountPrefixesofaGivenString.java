package leetcode.easy;

/**
 * 2255. Count Prefixes of a Given String
 */
public class CountPrefixesofaGivenString {

    public static int countPrefixes(String[] words, String s) {
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            if(s.startsWith(words[i])){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }

}
