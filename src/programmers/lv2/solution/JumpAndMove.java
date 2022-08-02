package programmers.lv2.solution;

/**
 * Lv2. 점프와 순간 이동
 *
 * 22.06.29
 *
 * 22.07.01 bitCount, 또는 2로나눠서 홀수면 1을빼고 answer에 1을 더한다.
 */
public class JumpAndMove {

    public static int solution(int n) {
        int sub = 1;
        int ans = 0;
        while(n != 0){
            if(n % 2 == 1){
                n -= sub;
                ans += 1;
            }
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(5)); //6
        System.out.println(solution(6)); //2
        System.out.println(solution(5000)); //5
    }
}
