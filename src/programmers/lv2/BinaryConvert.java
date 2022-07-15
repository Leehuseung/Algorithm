package programmers.lv2;

import java.util.Arrays;

/**
 * Lv2. 이진 변환 반복하기
 */
public class BinaryConvert {

    public static long[] solution(String s) {
        long count = 0;
        long bitCount = 0;
        while(!s.equals("1")){
            int len = s.length();
            s = s.replaceAll("0","");
            bitCount += len-s.length();
            s = Integer.toBinaryString(s.length());
            ++count;
        }
        return new long[]{count,bitCount};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));  // [3,8]
        System.out.println(Arrays.toString(solution("01110")));  // [3,3]
    }
}