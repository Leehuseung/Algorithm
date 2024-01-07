package backjun.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 최소 회의실 개수
 */
public class A19598 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] time = new int[N][2];
        for(int i = 0; i < N; i++) {
            time[i][0] = in.nextInt();
            time[i][1] = in.nextInt();
        }

        Arrays.sort(time, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int cnt = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            cnt++;
            pq.add(time[i][1]);
            while(!pq.isEmpty() && time[i][0] >= pq.peek()){
                cnt--;
                pq.poll();
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);

    }
}
