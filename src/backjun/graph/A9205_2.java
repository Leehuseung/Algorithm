package backjun.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 맥주 마시면서 걸어가기
 */
public class A9205_2 {
    static Point sangen, festival;
    static Point[] store;
    static final int DISTANCE = 1000;
    static boolean flag = false;
    static boolean[] visited;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // 테스트 개수
        loop:
        for(int i = 0; i < t; i++) {
            flag = false;
            int n = sc.nextInt(); // 편의점 수
            store = new Point[n];
            sangen = new Point(sc.nextInt(), sc.nextInt()); // 상근이 좌표
            for(int j = 0; j < n; j++) {
                store[j] = new Point(sc.nextInt(), sc.nextInt());
            }
            festival = new Point(sc.nextInt(), sc.nextInt());
            visited = new boolean[n];

            Queue<Point> queue = new LinkedList<>();
            queue.add(sangen);

            while (!queue.isEmpty()) {
                Point p = queue.poll();
                if(Math.abs(p.x - festival.x) + Math.abs(p.y - festival.y) <= DISTANCE) {
                    System.out.println("happy");
                    continue loop;
                }
                for (int j = 0; j < visited.length; j++) {
                    if(!visited[j]){
                        Point ss = store[j];
                        if(Math.abs(p.x - ss.x) + Math.abs(p.y - ss.y) <= DISTANCE) {
                            visited[j] = true;
                            queue.add(ss);
                        }
                    }
                }
            }
            System.out.println("sad");
        }
    }
}
