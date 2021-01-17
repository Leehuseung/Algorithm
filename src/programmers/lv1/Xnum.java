package programmers.lv1;


public class Xnum {
    public static void main(String[] args) {
        solution(2,5);
        solution(4,3);
        solution(0,2);
        solution(3,1);
    }
    public static long[] solution(long x, long n) {
        int a = (int)n;
        long[] answer = new long[a];
        long k = x;

        for (int i = 0; i < n; i++) {
            answer[i] = x;
            x = x + k;
        }

        return answer;
    }
}
