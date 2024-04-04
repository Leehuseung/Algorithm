package backjun.array;

import java.util.*;

/**
 * 절대값 힙
 */
public class A11286 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // PriorityQueue 정의

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            if (x != 0) {
                pq.offer(new int[]{x, Math.abs(x)}); // 절대값을 포함한 배열을 우선순위 큐에 추가
            } else {
                if (pq.isEmpty()) {
                    System.out.println(0); // 배열이 비어있을 경우 0 출력
                } else {
                    int[] min = pq.poll(); // 우선순위 큐에서 절대값이 가장 작은 원소 추출
                    System.out.println(min[0]); // 해당 원소의 원래 값을 출력
                }
            }
        }
    }
}
