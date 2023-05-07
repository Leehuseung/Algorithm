package programmers.lv1;

/**
 * Lv1. 기사단원의 무기
 */
public class TemplarWeapon {
    public static int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int cnt = 0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if(j * j == i){
                    cnt++;
                } else if(i % j == 0) {
                    cnt += 2;
                }
            }
            if(cnt > limit){
                answer += power;
                continue;
            }
            answer += cnt;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(5,3,2)); //10
        System.out.println(solution(10,3,2)); //21
    }
}
