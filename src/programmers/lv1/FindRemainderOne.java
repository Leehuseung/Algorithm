package programmers.lv1;

/*
 * Lv1. 나머지가 1이 되는 수 찾기
 */
public class FindRemainderOne {

    public static int solution(int n) {
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if(n % i == 1){
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
    }
}
