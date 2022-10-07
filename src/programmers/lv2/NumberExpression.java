package programmers.lv2;

/**
 * Lv2. 숫자의 표현
 */
public class NumberExpression {

    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        for (int i = 1; i < n/2+1; i++) {
            for (int j = i; j < n; j++) {
                sum += j;
                if(sum > n){
                    sum = 0;
                    break;
                } else if(sum == n){
                    answer++;
                    sum = 0;
                    break;
                }
            }
        }
        return answer + 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(15)); // 4
        System.out.println(solution(3));  // 2
    }
}
