package backjun.graph;

import java.util.*;

/**
 * 맥주 마시면서 걸어가기
 */
public class A9205 {
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

            if(n == 0) {
                if(Math.abs(sangen.x - festival.x) + Math.abs(sangen.y - festival.y) <= DISTANCE) flag=true;
            }

            Queue<Point> queue = new LinkedList<>();
            queue.add(sangen);
            a:
            while(!queue.isEmpty()) {
                Point start = queue.poll();

                for (int j = 0; j < n; j++) {
                    int distance = Math.abs(start.x - festival.x) + Math.abs(start.y - festival.y);
                    if(DISTANCE >= distance) {
                        flag=true;
                        break a;
                    }
                    if(!visited[j]){
                        Point end = store[j];
                        int newDistance = Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
                        if(DISTANCE >= newDistance) {
                            visited[j] = true;
                            queue.add(end);
                        }
                    }
                }
            }

            if(flag)
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }
}
