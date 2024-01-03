package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ATM
 */
public class A11399 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * (arr.length - i);
        }
        System.out.println(sum);
    }
}
