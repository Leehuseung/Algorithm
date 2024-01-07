package backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 행복 유치원
 */
public class A13164 {
    static int n, k, result;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        k = Integer.parseInt(s1[1]);
        arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int[] arr2 = new int[n-1];
        for (int i = 0; i < arr.length-1; i++) {
            arr2[i] = arr[i+1]-arr[i];
        }

        Arrays.sort(arr2);

        int result = 0;
        for (int i = 0; i < arr2.length - (k-1); i++) {
            result += arr2[i];
        }
        
        System.out.println(result);

    }
}
