package programmers.lv1;

/**
 * Lv1. 삼총사
 */
public class ThreeMsketeers {
    static int answer;
    static int[] numbers;
    static boolean[] bools;
    public static int solution(int[] number) {
        answer = 0;
        numbers = number;
        bools = new boolean[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            recursive(i,0,0);
        }
        return answer;
    }

    private static void recursive(int seq, int total, int depth) {
        bools[seq] = true;
        if(depth > 3) {
            bools[seq] = false;
            return;
        }
        total += numbers[seq];
        if(depth == 2 && total == 0) {
            answer++;
            bools[seq] = false;
            return;
        }
        for (int i = seq; i < numbers.length; i++) {
            if(!bools[i]) {
                recursive(i, total, depth+1);
            }
        }
        bools[seq] = false;
    }

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{-2, 3, 0, 2, -5}));
        System.out.println(solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
//        System.out.println(solution(new int[]{-1, 1, -1, 1}));
    }
}