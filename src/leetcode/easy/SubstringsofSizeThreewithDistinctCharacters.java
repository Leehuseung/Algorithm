package leetcode.easy;

/**
 * 1876. Substrings of Size Three with Distinct Characters
 */
public class SubstringsofSizeThreewithDistinctCharacters {

    public static int countGoodSubstrings(String s) {
        int answer = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length-2; i++) {
            int a = i;
            int b = i+1;
            int c = i+2;
            if(chars[a] != chars[b] && chars[b] != chars[c] && chars[a] != chars[c]){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz"));
        System.out.println(countGoodSubstrings("aababcabc"));
    }
}
