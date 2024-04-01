package backjun.dp;

import java.util.Scanner;

/**
 * 1로 만들기
 */
public class A1463_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i-1]+1;
            if(i % 2 == 0) {
                arr[i] = Math.min(arr[i/2] + 1, arr[i]);
            }
            if(i % 3 == 0) {
                arr[i] = Math.min(arr[i/3] + 1, arr[i]);
            }
        }
        System.out.println(arr[N]-1);
    }
}
