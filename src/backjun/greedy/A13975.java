package backjun.greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 파일 합치기 3
 */
public class A13975 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int T,N;
    static Queue<Long> pq;
    public static void main(String[] args) throws NumberFormatException, IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(input.readLine());
        for(int t=0; t<T; t++) {
            N = Integer.parseInt(input.readLine());
            pq = new PriorityQueue<>();
            tokens = new StringTokenizer(input.readLine());
            for (int n = 0; n < N; n++) {
                pq.offer(Long.parseLong(tokens.nextToken()));
            }
            long to = 0;
            long sum = 0;
            while(pq.size() > 1){
                long o = pq.poll();
                long z = pq.poll();
                to = o + z;
                sum += to;
                pq.offer(to);
            }
            System.out.println(sum);
        }
    }
}
