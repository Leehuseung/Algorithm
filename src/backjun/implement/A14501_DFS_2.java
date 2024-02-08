package backjun.implement;

import java.util.Scanner;

/**
 * 퇴사
 */
public class A14501_DFS_2 {
    static int N = 0;
    static int MAX = 0;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        arr = new int[N+1][];

        for(int i = 1; i <= N; i++) {
            arr[i] = new int[2];
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            dfs(i,0);
        }

        System.out.println(MAX);
    }

    private static void dfs(int i, int money) {
        if(i+arr[i][0] <= N+1){
            money += arr[i][1];
            MAX = Math.max(MAX, money);
            for (int j = i+arr[i][0]; j <= N; j++) {
                dfs(j, money);
            }
        }
    }
}
