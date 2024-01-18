package backjun.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 2+1 세일
 */
public class A11508_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Integer[] arr = new Integer[N];

        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int i = 0;
        int result = 0;
        while(i < N){
            if(i % 3 != 2){
                result += arr[i];
            }
            i++;
        }
        System.out.println(result);
    }
}
/*
7
10
9
4
2
6
4
3
 */