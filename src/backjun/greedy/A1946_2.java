package backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 신입 사원
 */
public class A1946_2 {
    static int T, num;
    static int[][] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            num = Integer.parseInt(br.readLine());
            score = new int[num][2];
            for (int j = 0; j < num; j++) {
                String[] str = br.readLine().split(" ");
                score[j][0] = Integer.parseInt(str[0]);
                score[j][1] = Integer.parseInt(str[1]);
            }

            Arrays.sort(score, Comparator.comparingInt(o -> o[0]));
            int t = num;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < num-1; j++) {
                int ss = score[j][1];
                min = Math.min(min,ss);
                if(score[j+1][1] > min){
                    t--;
                }
            }
            System.out.println(t);
        }
    }
}
