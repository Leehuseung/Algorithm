package backjun.implement;

import java.util.Scanner;

/**
 * 줄 세우기
 */
public class A10431 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int[][] arr = new int[P][];
        for (int i = 0; i < arr.length; i++) {
            int cases = sc.nextInt();
            arr[i] = new int[20];
            for (int j = 0; j < 20; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < P; i++) {
            int cnt = 0;
            //정렬 시작
            for (int k = 1; k < 20; k++) {
                for (int j = 1; j < 20-k+1; j++) {
                    // j-1 이 j보다 크면 교체한다.
                    if(arr[i][j-1] > arr[i][j]){
                        int t = arr[i][j-1];
                        arr[i][j-1] = arr[i][j];
                        arr[i][j] = t;
                        cnt++;
                    }
                }
            }
            System.out.println((i+1) + " " + cnt);
        }
    }
}
