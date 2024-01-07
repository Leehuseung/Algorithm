package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2+1 세일
 */
public class A11508 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        int p = N % 3;
        int a = N / 3;
        int result = 0;

        for (int i = 0; i < p; i++) {
            result += arr[i];
        }

        int t = arr.length-1;
        while(a > 0){
            result += arr[t];
            result += arr[t-1];
            t -= 3;
            a--;
        }

        System.out.println(result);

    }
}
/*
7
10
9
4
2
6
4
3
 */