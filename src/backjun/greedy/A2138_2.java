package backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 전구와 스위치
 */
public class A2138_2 {

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
        int result = -1;
        //0 번을 안누르는 경우
        for (int i = 1; i < a.length; i++) {
            if(a[i-1] != b[i-1]){
                result++;
                push(a, i);
            }
        }
        if(a[a.length-1] == b[b.length-1]) {
            result++;
            System.out.println(result);
            return;
        }

        //1번을 누르고 시작하는 경우
        result = -1;
        push(a2,0);
        result++;
        for (int i = 1; i < a2.length; i++) {
            if(a2[i-1] != b[i-1]){
                result++;
                push(a2, i);
            }
        }
        if(a2[a.length-1] == b[b.length-1]) {
            result++;
            System.out.println(result);
            return;
        }

        System.out.println(-1);
    }

    private static void push(int[] a, int i) {
        for (int j = i-1; j < i+2; j++) {
            if(j < a.length && j >= 0){
                if(a[j] == 0){
                    a[j] = 1;
                } else if (a[j] == 1){
                    a[j] = 0;
                }
            }
        }
    }
}
