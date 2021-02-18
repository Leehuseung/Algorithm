package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class A16435 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        int count = 0;

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= L){
                L++;
                count++;
            }
        }

        System.out.println(L);
    }
}
