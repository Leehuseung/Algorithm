package programmers.lv1;

public class TwoNumberSum {

    public static void main(String[] args) {
        System.out.println(solution(3,5));
        System.out.println(solution(3,3));
        System.out.println(solution(5,3));
    }

    public static long solution(int a, int b) {
        long answer = 0;

        if ( a > b ){
            int k = a;
            a = b;
            b = k;
        }

        for (int i = a; i <= b; i++) {
            answer += i;
        }

        return answer;
    }
}
