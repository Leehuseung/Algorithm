package backjun.greedy;

import java.util.*;

/**
 * 저울
 */
public class A2437 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int sum = 1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > sum){
                break;
            }
            sum += arr[i];
        }
        System.out.println(sum);
    }
}