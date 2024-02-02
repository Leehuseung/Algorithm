package backjun.greedy;

import java.util.Scanner;

/**
 * 짐 챙기는 숌
 */
public class A1817_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0;  i < N ; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if(sum + arr[i] > M){
                sum = 0;
                result++;
            }
            sum += arr[i];
        }
        if(sum > 0){
            result++;
        }
        System.out.println(result);
    }
}
