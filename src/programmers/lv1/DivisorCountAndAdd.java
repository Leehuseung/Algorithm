package programmers.lv1;

/*
 * Lv.1 약수의 개수와 덧셈
 */
public class DivisorCountAndAdd {

    public static int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if(getDivisorCnt(i) % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    public static int getDivisorCnt(int num) {
        int count = 0;
        for (int i = 1; i <= num ; i++) {
            if(num % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(24,27));


    }
}
