package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 우체국
 */
public class A2141_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[][] arr = new long[N][2];
        long sum = 0;
        for(int i = 0; i < N; i++) {
            arr[i][0] = in.nextLong();
            arr[i][1] = in.nextLong();
            sum += arr[i][1];
        }
        Arrays.sort(arr, (o1, o2) -> (int) (o1[0] - o2[0]));
        long k = sum / 2;
        k += sum % 2;

        long dSum = 0;
        for (int i = 0; i < N; i++) {
            dSum += arr[i][1];
            if(dSum >= k){
                System.out.println(arr[i][0]);
                break;
            }
        }
    }
}
/*
3
1 2
2 5
3 7
3
1 2
2 5
3 8
3
1 101
2 100
3 202
 */