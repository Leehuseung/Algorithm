package programmers.lv2;

/**
 * Lv2. 피보나치
 */
public class Fibonacci {

    static int[] arr = new int[100001];

    public static int solution(int n) {
        int answer = recursive(n) % 1234567;
        return answer;
    }

    public static int recursive(int n) {
        if(n <= 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            if(arr[n] != 0) {
                return arr[n];
            } else {
                int sum = recursive(n-2) + recursive(n-1);
                arr[n] = sum % 1234567;
                return arr[n];
            }
        }
    };

    public static void main(String[] args) {
//        System.out.println(solution(3)); // 2
//        System.out.println(solution(5)); // 5
//        System.out.println(solution(6)); // 8
        System.out.println(solution(7)); // 13
    }
}
