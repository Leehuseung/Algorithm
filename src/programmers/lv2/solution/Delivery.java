package programmers.lv2.solution;

import java.util.*;

/**
 * Lv2. 배달
 *
 * 22.07.19
 *
 * 22.07.22 다익스트라 풀이 참조
 */
public class Delivery {
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] graph = new int[N+1][N+1];
        int[] dist = new int[N+1];
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });

        for(int i = 0; i < N+1; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < road.length; i++){
            int start = road[i][0];
            int end = road[i][1];
            int value = road[i][2];
            if(graph[start][end] > value){
                graph[start][end] = value;
                graph[end][start] = value;
            }

        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(pQueue, graph, 1, dist);
        for(int i = 1; i < N+1; i++){
            if(dist[i] <= K){
                answer++;
            }
        }

        return answer;
    }

    public static void dijkstra(PriorityQueue<int[]> pQueue, int[][] graph, int start, int[] dist){
        dist[start] = 0;
        pQueue.add(new int[]{dist[start], start});

        while(!pQueue.isEmpty()){
            int[] pop = pQueue.remove();
            int popStart = pop[1];
            int popDist = pop[0];

            for(int i = 1; i < graph.length; i++){
                int endDist = graph[popStart][i];

                if(endDist != Integer.MAX_VALUE){

                    if(dist[i] > dist[popStart] + endDist){
                        dist[i] = dist[popStart] + endDist;
                        pQueue.add(new int[]{dist[i], i});
                    }
                }
            }
        }
    }


    public static int solution2(int N, int[][] road, int K) {
         int[] distanceArr = new int[N+1];
        boolean[] visit = new boolean[N+1];
        int[][] dist = new int[N+1][N+1];
        int answer = 0;
        init(visit,distanceArr);

        for(int i = 0; i < N+1; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < road.length; i++) {
            if(dist[road[i][0]][road[i][1]] > road[i][2]){
                dist[road[i][0]][road[i][1]] = road[i][2];
                dist[road[i][1]][road[i][0]] = road[i][2];
            }
        }

        dijkstra2(1,visit,dist,distanceArr);

        for (int i = 1; i < distanceArr.length; i++) {
            if(distanceArr[i] <= K){
                answer++;
            }
        }

        return answer;
    }

    private static void init(boolean[] visit, int[] distanceArr){
        for (int i = 0; i < visit.length; i++) {
            visit[i] = false;
        }
        for (int i = 0; i < distanceArr.length; i++) {
            distanceArr[i] = Integer.MAX_VALUE;
        }
    }

    private static void dijkstra2(int unmber, boolean[] visit, int[][] dist, int[] distanceArr) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        // 거리,마을
        queue.add(new int[]{0,1});
        distanceArr[1] = 0;

        while(!queue.isEmpty()) {
            int[] pollCity = queue.poll();
            int distance = pollCity[0];
            int cityNumber = pollCity[1];
            if (visit[cityNumber]) continue;
            visit[cityNumber] = true;

            for (int i = 1; i < distanceArr.length; i++) {
                if (dist[cityNumber][i] != Integer.MAX_VALUE && distanceArr[i] > distanceArr[cityNumber] + dist[cityNumber][i]) {
                    distanceArr[i] = distanceArr[cityNumber] + dist[cityNumber][i];
                    queue.add(new int[]{distanceArr[i], i});
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(solution(6,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,1},{5,3,1},{5,4,1}},3));
        System.out.println(solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3));
        System.out.println(solution2(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3));
        System.out.println(solution(6,new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}},4));
        System.out.println(solution(5,new int[][]{{1,2,4},{1,3,1},{3,4,1},{4,2,1},{2,5,1}},4));
    }
}


