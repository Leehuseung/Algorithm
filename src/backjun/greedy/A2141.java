package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 우체국
 */
public class A2141 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[][] arr = new long[N][2];
        for(int i = 0; i < N; i++) {
            arr[i][0] = in.nextLong();
            arr[i][1] = in.nextLong();
        }

        Arrays.sort(arr, (o1, o2) -> (int) (o1[0] - o2[0]));

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][1];
        }

        long half = (sum+1)/2;

        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][1];
            if(sum >= half){
                System.out.println(arr[i][0]);
                break;
            }
        }
    }
}
