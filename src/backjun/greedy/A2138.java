package backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 전구와 스위치
 */
public class A2138 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] a = new int[n];
        int[] a2 = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s1.charAt(i)-'0';
            a2[i] = s1.charAt(i)-'0';
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = s2.charAt(i)-'0';

        int result = 0;
        for (int i = 1; i < n; i++) {
            if(a[i-1] != b[i-1]){
                push(a, i);
                result++;
            }
        }
        if(a[n-1] == b[n-1]){
            System.out.println(result);
            return;
        }

        result = 1;
        push(a2, 0);
        for (int i = 1; i < n; i++) {
            if(a2[i-1] != b[i-1]){
                push(a2, i);
                result++;
            }
        }

        if(a2[n-1] == b[n-1]){
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
    public static void push(int[] arr, int i) {
        for (int j = i-1; j <= i+1; j++) {
            if(j < 0) continue;
            if(j >= arr.length) continue;
            arr[j] = arr[j] == 0 ? 1 : 0;
        }
    }
}
