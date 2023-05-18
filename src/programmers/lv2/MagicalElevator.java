package programmers.lv2;

import java.util.Random;

/**
 * Lv2. 마법의 엘리베이터
 */
public class MagicalElevator {

    public static int solution(int storey) {
        int answer = 0;
        String s = storey + "";
        String[] ss = s.split("");
        for (int i = ss.length-1; i >= 0; i--) {
            int k = Integer.parseInt(ss[i]);
            if(k < 5) {
                answer += k;
            } else if(k == 5){
                answer += k;
                if(i != 0 && Integer.parseInt(ss[i-1]) > 4){
                    ss[i-1] = String.valueOf(Integer.parseInt(ss[i-1])+1);
                }
            } else {
                answer += (10 - k);
                if(i != 0){
                    ss[i-1] = String.valueOf(Integer.parseInt(ss[i-1])+1);
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static int solution3(int storey) {
        int answer = 0;
        String s = storey + "";
        String[] ss = s.split("");
        for (int i = ss.length-1; i >= 0; i--) {
            int k = Integer.parseInt(ss[i]);
            if(k < 5) {
                answer += k;
            } else if(k == 5){
                answer += k;
                if(i != 0 && Integer.parseInt(ss[i-1]) > 4){
                    ss[i-1] = String.valueOf(Integer.parseInt(ss[i-1])+1);
                }
            } else {
                answer += (10 - k);
                if(i != 0){
                    ss[i-1] = String.valueOf(Integer.parseInt(ss[i-1])+1);
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution(16)); // 6
//        System.out.println(solution(2554)); // 16
//        System.out.println(solution(8888)); // 6
//        System.out.println(solution(6888)); // 6
//        System.out.println(solution(155)); // 11
//        System.out.println(solution(293)); // 7
//        System.out.println(solution(678)); // 8
//        System.out.println(solution(999)); // 2
    }
}
