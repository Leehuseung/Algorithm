package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 순회강연
 */
public class A2109_2 {
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
        boolean[] check = new boolean[10001];
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!check[arr[i][1]]){
                result += arr[i][0];
                check[arr[i][1]]= true;
                continue;
            }
            int price = arr[i][0];
            for (int j = arr[i][1]-1; j >= 1 ; j--) {
                if(!check[j]){
                    check[j]= true;
                    result += price;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
/*
7
20 1
2 1
10 3
100 2
90 2
5 20
50 10

255
 */