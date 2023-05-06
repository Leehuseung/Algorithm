package programmers.lv1;

/**
 * Lv2. 콜라 문제
 */
public class Cola {

    public static int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            answer += ((n / a) * b );
            n = ((n / a) * b ) + (n % a);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2,1,20)); // 19
        System.out.println(solution(3,1,20)); // 9
    }
}
