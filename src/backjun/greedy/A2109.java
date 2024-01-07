package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 순회강연
 */
public class A2109 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] arr = new int[N][];

        for(int i = 0; i < N; i++) {
            arr[i] = new int[2];
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);
        boolean[] bools = new boolean[10001];
        int result = 0;
        for (int[] ints : arr) {
            int price = ints[0];
            int day = ints[1];
            for (int i = day; i >= 1; i--) {
                if(!bools[i]) {
                    bools[i] = true;
                    result += price;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
