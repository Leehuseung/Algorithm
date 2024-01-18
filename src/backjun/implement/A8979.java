package backjun.implement;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 올림픽
 */
public class A8979 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[][] arr = new int[N][];

        for(int i = 0; i < N; i++) {
            arr[i] = new int[5];
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            arr[i][2] = in.nextInt();
            arr[i][3] = in.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o2[1] == o1[1]){
                if(o2[2] == o1[2]){
                    return o2[3] - o1[3];
                }
                return o2[2] - o1[2];
            }
            return o2[1] - o1[1];
        });


        int result = -1;
        arr[0][4] = 1;
        for (int i = 1; i < N; i++) {
            //이전사람과 모두 같다면 이전사람의 순위를 넣는다.
            if(
                    arr[i][1] == arr[i - 1][1] &&
                    arr[i][2] == arr[i - 1][2] &&
                    arr[i][3] == arr[i - 1][3]
            ){
                arr[i][4] = arr[i-1][4];
                if(arr[i][0] == K){
                    result = arr[i][4];
                }
                continue;
            }
            arr[i][4] = i+1;
            if(arr[i][0] == K){
                result = arr[i][4];
            }
        }
        System.out.println(result == -1 ? 1 : result);
    }
}

/*
5 4
1 3 0 0
2 3 0 0
3 2 0 0
4 1 0 0
5 2 0 0

2 2
1 1 0 0
2 1 0 0
 */