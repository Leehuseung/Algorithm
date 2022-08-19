package programmers.lv2;

/**
 * Lv2. 멀리 뛰기
 */
public class RunFar {

    public static long solution(int n) {
        long[] arr = new long[n];
        arr[0] = 1;
        if(n == 1){
            return 1;
        }
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i-2] % 1234567 + arr[i-1] % 1234567;
        }
        return arr[n-1] % 1234567;
    }

    public static void main(String[] args) {
        System.out.println(solution(4)); //5
        System.out.println(solution(3)); //3
        System.out.println(solution(2)); //3
        System.out.println(solution(1)); //3
//        System.out.println(solution(2000)); //3
    }
}
