package backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 파일 합치기 3
 */
public class A13975_2 {
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
            long sum = 0;
            while(!pq.isEmpty()){
                if(pq.size() == 1){
                    break;
                }
                long a = pq.poll();
                long b = pq.poll();
                sum += a + b;
                pq.add(a + b);
            }
            System.out.println(sum);
        }
    }
}
/*
1
4
1 2 3 4
 */