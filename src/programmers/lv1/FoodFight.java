package programmers.lv1;

/**
 * Lv1. 푸드 파이트 대회
 */
public class FoodFight {
    public static String solution(int[] food) {
        String answer = "";

        for (int i = 1; i < food.length; i++) {
            int k = food[i];
            for (int j = 0; j < k/2; j++) {
                answer += String.valueOf(i);
            }
        }

        answer += "0";

        for (int i = food.length-1; i > 0 ; i--) {
            int k = food[i];
            for (int j = 0; j < k/2; j++) {
                answer += String.valueOf(i);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,4,6})); //1223330333221
        System.out.println(solution(new int[]{1,7,1,2})); //111303111
    }
}
