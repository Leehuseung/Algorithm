package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 저울
 */
public class A2437_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        int sum = 1;


        Arrays.sort(arr);
        if(arr[0] != 1) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(sum < arr[i]){
                System.out.println(sum);
                return;
            }
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
