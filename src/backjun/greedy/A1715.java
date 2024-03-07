package backjun.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 카드 정렬하기
 */
public class A1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) pq.add(sc.nextInt());
        int sum = 0;


        if(pq.size() == 1) {
            System.out.println(sum);
            return;
        }

        while(!pq.isEmpty()) {
            int a = pq.poll();
            int b = 0;
            if(!pq.isEmpty()){
                b = pq.poll();
            }
            int s = a + b;
            sum += s;
            if(!pq.isEmpty()) {
                pq.add(s);
            }
        }

        System.out.println(sum);
    }
}
