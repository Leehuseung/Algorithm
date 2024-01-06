package backjun.greedy;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 크게 만들기
 */
public class A2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String input = br.readLine();

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            int d = Integer.parseInt(input.charAt(i)+"");
            while(K > 0 && !deque.isEmpty() && deque.getLast() < d){
                deque.pollLast();
                K--;
            }
            deque.addLast(d);
        }

        StringBuffer sb = new StringBuffer();
        while (deque.size() > K) {
            sb.append(deque.pollFirst());
        }
        System.out.println(sb);
    }
}