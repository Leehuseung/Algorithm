package programmers.lv2;

/**
 * Lv2. 점찍기
 */
public class Dot {

    public static long solution(int k, int d) {
        long answer = 0;
        for(int i = 0; i <= d; i += k) {
            long dd = (long) d * d;
            long ii = (long) i * i;
            int top = (int) Math.sqrt(dd - ii);
            answer += (top / k) + 1; //최대 값이 y인 좌표 내부에 찍을 수 있는 점의 개수는 소수 점을 제거한 y / k + 1
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2,4)); //6
        System.out.println(solution(1,5)); //26
    }
}
