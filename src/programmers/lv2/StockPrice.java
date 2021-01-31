package programmers.lv2;

import java.util.Arrays;

public class StockPrice {
    public static void main(String[] args) {
        solution(new int[]{1,2,3,2,3});
    }
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int num = prices[i];
            int second = -1;
            for (int j = i; j < prices.length; j++) {
                second++;
                if(prices[j] < num){
                    break;
                }
            }
            answer[i] = second;
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
