package backjun.search;

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
        int result = 0;
        while(min <= max) {
            int middle = (min + max) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) if (arr[i] > middle) sum += arr[i] - middle;
            if(sum >= M) {
                result = middle;
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }

        System.out.println(result);

    }
}
