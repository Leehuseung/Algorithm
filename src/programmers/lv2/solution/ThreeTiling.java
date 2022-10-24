package programmers.lv2.solution;

/**
 * 3 x n 타일링
 *
 * 22.08.24
 *
 * 22.08.25
 *
 */
public class ThreeTiling {
    public static long solution(int n) {
        int mod = 1000000007;
        long[] arr = new long[n+1];
        arr[2] = 3;
        arr[4] = 11;
        for (int i = 6; i <= n; i += 2) {
            arr[i] = ((arr[i-2] * 4) % mod - arr[i-4] % mod + mod) % mod ;
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(8));
        System.out.println(solution(10));
        System.out.println(solution(12)); //2131
        System.out.println(solution(14)); //7953
    }
}
