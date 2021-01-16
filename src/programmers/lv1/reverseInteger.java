package programmers.lv1;

import java.util.Arrays;

public class reverseInteger {
    public static void main(String[] args) {
        solution(12345);
    }
    public static int[] solution(long n) {
        int[] answer = {};

        String[] arr = (n+"").split("");

        answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            answer[i] = Integer.parseInt(arr[arr.length-1-i]);
        }

        return answer;
    }
}
