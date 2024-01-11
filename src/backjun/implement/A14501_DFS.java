package backjun.implement;

import java.util.Scanner;

/**
 * 퇴사
 */
public class A14501_DFS {
    static int N = 0;
    static int MAX = 0;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        arr = new int[N][];

        for(int i = 0; i < N; i++) {
            arr[i] = new int[2];
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        dfs(0, 0);

        System.out.println(MAX);
    }

    static void dfs(int i, int price){
        if(i == N){
            MAX = Math.max(price, MAX);
            return;
        }
        if(N >= arr[i][0] + i){
            MAX = Math.max(price + arr[i][1], MAX);
            dfs(i + arr[i][0], price + arr[i][1]);
        }

        dfs(i+1, price);
    }
}
/*
찾는데 도움된 테스트 케이스
3
3 100
1 99
1 2
 */