package programmers.lv1;

import java.util.Arrays;

public class StringBatch {
    public static void main(String[] args) {
        System.out.println(solution("nrKesM"));
    }
    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split("");

        Arrays.sort(arr);

        for (int i = arr.length-1; i >= 0 ; i--) {
            answer += arr[i];
        }

        return answer;
    }
}
