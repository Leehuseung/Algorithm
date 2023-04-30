package leetcode.easy;

import java.util.Arrays;

/**
 * 821. Shortest Distance to a Character
 */
public class ShortestDistancetoaCharacter {

    public static int[] shortestToChar(String S, char C) {
        int n = S.length(), pos = -n, res[] = new int[n];
        for (int i = 0; i < n; ++i) {
            if (S.charAt(i) == C) pos = i;
            res[i] = i - pos;
        }
        for (int i = pos - 1; i >= 0; --i) {
            if (S.charAt(i) == C)  pos = i;
            res[i] = Math.min(res[i], pos - i);
        }
        return res;
    }

    public static int[] shortestToChar2(String s, char c) {
        int[] arr = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(chars[i] == c){
                arr[i] = 0;
                continue;
            }
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;

            for (int j = i; j >= 0 ; j--) {
                if(chars[j] == c){
                    left = Math.abs(i-j);
                    break;
                }
            }

            for (int j = i; j < s.length(); j++) {
                if(chars[j] == c){
                    right = Math.abs(i-j);
                    break;
                }
            }
            arr[i] = Math.min(left,right);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode",'e'))); //[3,2,1,0,1,0,0,1,2,2,1,0]
    }
}
