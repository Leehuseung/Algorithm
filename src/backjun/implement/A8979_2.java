package backjun.implement;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 올림픽
 */
public class A8979_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[][] arr = new int[N][];

        for(int i = 0; i < N; i++) {
            arr[i] = new int[4];
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            arr[i][2] = in.nextInt();
            arr[i][3] = in.nextInt();
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int result = 1;
        K = K-1;
        for (int i = 0; i < N; i++) {
            if(K == arr[i][0]-1) continue;
            //금메달이 많다.
            if(arr[i][1] > arr[K][1]){
                result++;
            //금메달이 많다면 은메달이 많다.
            } else if(arr[i][1] == arr[K][1] && arr[i][2] > arr[K][2] ) {
                result++;
            //금메달 은메달이 많다면 동메달이 많다.
            } else if(arr[i][1] == arr[K][1] && arr[i][2] == arr[K][2] && arr[i][3] > arr[K][3]) {
                result++;
            }
        }

        System.out.println(result);
    }
}
