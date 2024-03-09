package backjun.graph;

import java.util.*;

/**
 * 물통 (DFS)
 */
public class A2251_2 {
    static int[] bucket;
    static int[] real;
    static boolean[][][] visited;
    static List<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aa = sc.nextInt();
        int bb = sc.nextInt();
        int cc = sc.nextInt();
        bucket = new int[]{aa,bb,cc};
        real = new int[]{0,0,cc};
        answer = new ArrayList<>();
        visited = new boolean[201][201][201];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,cc});

        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int a = info[0];
            int b = info[1];
            int c = info[2];
            if(visited[a][b][c]) continue;
            visited[a][b][c] = true;
            if(!answer.contains(c) && a == 0) answer.add(c);

            // 0 -> 1
            if(bucket[1] > b){
                int k = Math.min(bucket[1] - b, a);
                queue.add(new int[]{a-k, b+k, c});
            }
            // 0 -> 2
            if(bucket[2] > c){
                int k = Math.min(bucket[2] - c, a);
                queue.add(new int[]{a-k, b, c+k});
            }
            // 1 -> 0
            if(bucket[0] > a){
                int k = Math.min(bucket[0] - a, b);
                queue.add(new int[]{a+k, b-k, c});
            }
            // 1 -> 2
            if(bucket[2] > c){
                int k = Math.min(bucket[2] - c, b);
                queue.add(new int[]{a, b-k, c+k});
            }
            // 2 -> 0
            if(bucket[0] > a){
                int k = Math.min(bucket[0] - a, c);
                queue.add(new int[]{a+k,b,c-k});
            }
            // 2 -> 1
            if(bucket[1] > b){
                int k = Math.min(bucket[1] - b, c);
                queue.add(new int[]{a,b+k,c-k});
            }
        }

        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.print(integer);
            System.out.print(" ");
        }
    }
}
