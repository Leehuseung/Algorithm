package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 회의실 배정
 */
public class A1931 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] time = new int[N][2];
        for(int i = 0; i < N; i++) {
            time[i][0] = in.nextInt();
            time[i][1] = in.nextInt();
        }

        Arrays.sort(time, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int answer = 1;
        int endTime = time[0][1];
        for (int i = 1; i < time.length; i++) {
            if(endTime <= time[i][0]){
                answer++;
                endTime = time[i][1];
            }
        }
        System.out.println(answer);
    }
}
