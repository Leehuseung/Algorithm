package programmers.lv2;

import java.util.Arrays;

/**
 * Lv2. 카펫
 */
public class Carpet {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        //Yellow가 나올 수 있는 case를 구한다.
        for (int i = yellow; i > 0; i--) {
            if ((yellow % i) == 0 && i >= (yellow / i)) {
                int width = i;
                int height = yellow / i;
                int calculateBrownCount = width * 2 + height * 2 + 4;
                if (brown == calculateBrownCount) {
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2))); // [4,3]
        System.out.println(Arrays.toString(solution(8, 1))); // [3,3]
        System.out.println(Arrays.toString(solution(24, 24))); // [8,6]
        System.out.println(Arrays.toString(solution(50, 22))); // [24,3]
    }
}
