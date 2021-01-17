package programmers.lv1;

import java.util.Arrays;
import java.util.Collections;

public class numSort {
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }
    public static long solution(long n) {
        String[] a = (n+"").split("");

        Long[] arr = new Long[a.length];

        for (int i = 0; i < a.length; i++) {
            arr[i] = Long.parseLong(a[i]);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        String b = "";
        for (int i = 0; i < arr.length; i++) {
            b += arr[i]+"";
        }

        return Long.parseLong(b);
    }
}
