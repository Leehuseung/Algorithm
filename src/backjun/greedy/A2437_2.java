package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 저울
 */
public class A2437_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        long min = 1;
        for (long l : arr) {
            if (l > min) {
                break;
            }
            min += l;
        }
        System.out.println(min);

    }
}
