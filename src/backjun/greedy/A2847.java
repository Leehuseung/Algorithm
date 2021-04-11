package backjun.greedy;

import java.util.Scanner;

public class A2847 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(sc.nextLine());
            arr[i] = score;
        }

        int count = 0;

        for (int i = arr.length-1; i >= 1 ; i--) {
            while(arr[i] <= arr[i-1]){
                arr[i-1] = arr[i-1] - 1;
                count++;
            }
        }

        System.out.println(count);

    }
}
