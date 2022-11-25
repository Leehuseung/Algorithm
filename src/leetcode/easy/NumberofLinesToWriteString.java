package leetcode.easy;

import java.util.Arrays;

/**
 * 806. Number of Lines To Write String
 */
public class NumberofLinesToWriteString {

    public static int[] numberOfLines(int[] widths, String s) {
        int line = 1;
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int num = chars[i] - 'a';
            if(cnt + widths[num] > 100){
                cnt = widths[num];
                line++;
                continue;
            }
            cnt += widths[num];
        }
        return new int[]{line,cnt};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfLines(new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10} , "abcdefghijklmnopqrstuvwxyz"))); // [3,60]
//        System.out.println(numberOfLines(new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "bbbcccdddaaa") ); //

    }
}
