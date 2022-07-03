package leetcode.easy;

/**
 * 1967. Number of Strings That Appear as Substrings in Word
 */
public class NumberofStringsThatAppearasSubstringsinWord {

    public static int numOfStrings(String[] patterns, String word) {
        int answer = 0;
        for (int i = 0; i < patterns.length; i++) {
            if(word.indexOf(patterns[i]) != -1) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(numOfStrings(new String[]{"a","abc","bc","d"}, "abc"));
        System.out.println(numOfStrings(new String[]{"a","b","c"}, "aaaaabbbbb"));
        System.out.println(numOfStrings(new String[]{"a","a","a"}, "ab"));
    }
}
