package programmers.lv2.solution;

/**
 * Lv2. 124나라의 숫자
 *
 * 22.06.19(pseudo)
 *
 * 22.06.22(code참조)
 *
 * 22.07.03 재풀이
 */
public class OneTwoFour {
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n / 3 != 0){
            if(n % 3 == 0){
                n--;
                sb.append(4);
            } else {
                sb.append(n % 3);
            }
            n = n/3;
        }
        sb.append(n != 0 ? n : "");
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
        System.out.println(solution(8));
        System.out.println(solution(9));
        System.out.println(solution(10));
        System.out.println(solution(11));
        System.out.println(solution(12));
        System.out.println(solution(13));
        System.out.println(solution(14));
        System.out.println(solution(15));
        System.out.println(solution(16));
    }
}
