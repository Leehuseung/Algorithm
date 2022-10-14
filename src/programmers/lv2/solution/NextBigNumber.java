package programmers.lv2.solution;

/**
 * Lv2. 다음 큰 숫자
 *
 * 22.06.21
 *
 * Solution - Integer.bitCount를 활용하자
 *
 */
public class NextBigNumber {

    public static int solution(int n) {
        int cnt = Integer.bitCount(n);
        while(cnt != Integer.bitCount(++n)) {}
        return n;
    }

    public static void main(String[] args) {
        System.out.println(solution(78)); //83
        System.out.println(solution(15)); //23
    }
}
