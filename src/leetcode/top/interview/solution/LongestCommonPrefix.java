package leetcode.top.interview.solution;

import java.util.Arrays;

/**
 * 14. Longest Common Prefix
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        return "";
    }
    public static String myLongestCommonPrefix(String[] strs) {
        int minLength = 200;
        for (String str : strs) minLength = Math.min(minLength, str.length());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            char a = strs[0].charAt(i);
            for (String s : strs) {
                if (a != s.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(a);
        }

        return sb.toString();
    }

    public static String bestLongestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix(new String[]{"faower","faow","flight"})); // "fl"
//        System.out.println(longestCommonPrefix(new String[]{"abc","bcd","adc","aaa"})); // "fl"
//        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"})); // ""
//        System.out.println(longestCommonPrefix(new String[]{"a"})); // "a"
//        System.out.println(longestCommonPrefix(new String[]{"flower","flower","flower","flower"})); // ""
    }
}
