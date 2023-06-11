package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lv2. 우박수열 정적분
 *
 * 23.06.11
 */
public class HailwaterSequenceDefiniteIntegral {

    public static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        List<Integer> list = new ArrayList<>();
        List<Double> areas = new ArrayList<>();

        while(true){
            list.add(k);
            if(k == 1){
                break;
            } else if(k % 2 == 0){
                k = k / 2;
            } else {
                k = k * 3 + 1;
            }
        }

        for (int i = 0; i < list.size()-1; i++) {
            double area = (double) (list.get(i) + list.get(i+1)) / 2;
            areas.add(area);
        }

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = ranges[i][1] + areas.size();
            double an = 0;
            if(start > end){
                answer[i] = -1;
                continue;
            }
            for (int j = start; j < end; j++) {
                an += areas.get(j);
            }
            answer[i] = an;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(5,
                                new int[][]{
                                        {0, 0},
                                        {0, -1},
                                        {2, -3},
                                        {3, -3}
                                }
                        )
                ));
    }
}
