package programmers.lv2;

/**
 * Lv2. 최댓값과 최소값
 */
public class MaxAndMin {
    public static String solution(String s) {
        String[] answer = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < answer.length; i++) {
            int num = Integer.parseInt(answer[i]);
            if(num > max) max = num;
            if(num < min) min = num;
        }
        return min+" "+max;
    }

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4")); // 1 4
        System.out.println(solution("-1 -2 -3 -4")); // -4 -1
        System.out.println(solution("-1 -1")); // -1 -1
    }
}
