package backjun.bruteforce;

import java.util.Scanner;

/**
 * 나무 자르기
 */
public class A2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }
        int min = 0;
        int middle = (max+min) / 2;

        while(max > min) {
            middle = (max+min) / 2;
            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += Math.max(arr[i] - middle, 0);
            }

            if(sum < M) {
                max = middle;
            } else {
                min = middle+1;
            }
        }

        System.out.println(min-1);
    }
}
