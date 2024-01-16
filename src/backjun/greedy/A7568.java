package backjun.greedy;

import java.util.Scanner;

/**
 * 덩치
 */
public class A7568 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] arr = new int[N][];
        int[] answer = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = new int[2];
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i != j && arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    answer[i]++;
                }
            }
        }

        for (int i = 0; i < N ; i++) {
            System.out.print(answer[i]+1);
            System.out.print(N-1 != i ? " " : "");
        }
    }
}
