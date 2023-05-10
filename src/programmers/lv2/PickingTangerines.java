package programmers.lv2;

import java.util.Arrays;

/**
 * Lv2. 귤 고르기
 */
public class PickingTangerines {

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[10000001];
        for (int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i]] = arr[tangerine[i]]+1;
        }
        Arrays.sort(arr);
        int t = 10000000;
        while(k > 0) {
            k -= arr[t--];
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6,new int[]{1, 3, 2, 5, 4, 5, 2, 3})); //3
        System.out.println(solution(4,new int[]{1, 3, 2, 5, 4, 5, 2, 3})); //2
        System.out.println(solution(2,new int[]{1, 1, 1, 1, 2, 2, 2, 3})); //1
    }
}
