package leetcode.easy;

import java.util.Arrays;

/**
 * 942. DI String Match
 */
public class DIStringMatch {
    public static int[] diStringMatch(String s) {
        int[] answer = new int[s.length()+1];
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length();

        for (int i = 0; i <= chars.length; i++) {
            if(i == chars.length || chars[i] == 'D'){
                answer[i] = end--;
            } else {
                answer[i] = start++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
        System.out.println(Arrays.toString(diStringMatch("III")));
        System.out.println(Arrays.toString(diStringMatch("DDI")));
    }
}
