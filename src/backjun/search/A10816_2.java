package backjun.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 숫자 카드 2
 */
public class A10816_2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);	// 이분 탐색을 하기 위해서는 반드시 정렬되어있어야 한다.

        int M = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            int key = in.nextInt();

            // upperBound와 lowerBound의 차이 값을 구한다.
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
        }
        System.out.println(sb);
    }

    public static int lowerBound(int[] arr, int key) {
        int pl = 0;
        int pr = arr.length;
        while(pl <= pr){
            int mid = (pl + pr) / 2;
            if(arr[mid] >= key) {
                pr = mid - 1;
            } else {
                pl = mid + 1;
            }
        }
        return pl;
    }

    public static int upperBound(int[] arr, int key) {
        int pl = 0;
        int pr = arr.length;
        int index = 0;
        while(pl <= pr){
            int mid = (pl + pr) / 2;
            if(arr[mid] <= key) {
                pl = mid+1;
            } else {
                pr = mid-1;
            }
        }
        return pl;
    }

}
