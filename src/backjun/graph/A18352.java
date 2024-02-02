package backjun.graph;

import java.util.*;

/**
 * 특정 거리의 도시 찾기
 */
public class A18352 {

    static int n,m,k,x;
    static int visited[];
    static ArrayList<Integer>[] graph;
    static List<Integer> ans;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 노드 수
        m = sc.nextInt(); // 간선 수
        k = sc.nextInt(); // 목표 거리
        x = sc.nextInt(); // 시작점
        graph = new ArrayList[n+1]; // 그래프 데이터 저장
        ans = new ArrayList<>(); // 정답


        for (int i=1; i<=n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for (int i=1; i<=m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph[s].add(e);
        }

        visited = new int[n+1];

        for(int i=0; i<=n; i++){
            visited[i] = -1;
        }

        bfs(x);

        if (ans.isEmpty()) {
            System.out.println("-1");
        } else{
            Collections.sort(ans);
            for (int temp : ans){
                System.out.println(temp);
            }
        }
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x]++;
        while(!queue.isEmpty()) {
            int t = queue.poll();
            ArrayList<Integer> list = graph[t];
            for (Integer integer : list) {
                if (visited[integer] == -1) {
                    visited[integer] = visited[t]+1;
                    if (visited[integer] == k) {
                        ans.add(integer);
                    }
                    queue.add(integer);
                }
            }
        }
    }


    /**
     * 반례를 못찾음..
     * 메모리 초과는 있을수 있지만 출력 초과가 나오는데 이유를 모르겠다..
     */
//    static int n,m,k,x;
//    static boolean visited[];
//    static ArrayList<Integer>[] graph;
//    static List<Integer> ans;
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//
//        n = sc.nextInt(); // 노드 수
//        m = sc.nextInt(); // 간선 수
//        k = sc.nextInt(); // 목표 거리
//        x = sc.nextInt(); // 시작점
//        graph = new ArrayList[n+1]; // 그래프 데이터 저장
//        ans = new ArrayList<>(); // 정답
//        visited = new boolean[n+1]; // 방문 배열 초기화
//
//        for (int i=1; i<=n; i++){
//            graph[i] = new ArrayList<Integer>();
//        }
//
//        for (int i=1; i<=m; i++){
//            int s = sc.nextInt();
//            int e = sc.nextInt();
//            graph[s].add(e);
//        }
//
//        bfs(x, 1);
//
//        if (ans.isEmpty()) {
//            System.out.println("-1");
//        } else{
//            Collections.sort(ans);
//            for (int temp : ans){
//                System.out.println(temp);
//            }
//        }
//    }
//
//    private static void bfs(int x, int cnt) {
//        Queue<Integer> queue = new LinkedList<>();
//        if(cnt > k) return;
//        visited[x] = true;
//
//        List<Integer> list = graph[x];
//
//        for (int i = 0; i < list.size(); i++) {
//            if(visited[list.get(i)]) continue;
//            visited[list.get(i)] = true;
//            queue.add(list.get(i));
//        }
//
//        while(!queue.isEmpty()) {
//            int t = queue.poll();
//            if(cnt == k){
//                ans.add(t);
//            }
//            bfs(t, cnt+1);
//        }
//    }
}