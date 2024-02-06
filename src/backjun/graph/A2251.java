package backjun.graph;

import java.util.*;

/**
 * 물통(2251)
 */
public class A2251 {
    static int[] bucket;
    static int[] real;
    static List<Integer> answer;
    static boolean[][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        bucket = new int[]{a,b,c};
        real = new int[]{0,0,c};
        answer = new ArrayList<>();
        visited = new boolean[201][201][201];
        dfs(0,0,c);

        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.print(integer);
            System.out.print(" ");
        }
    }

    private static void dfs(int a, int b,int c){
        if(visited[a][b][c]) return;
        visited[a][b][c] = true;
        if(!answer.contains(c) && a == 0){
            answer.add(c);
        }

        // 0 -> 1
        if(bucket[1] > b){
            int k = Math.min(bucket[1] - b, a);
            dfs(a-k, b+k, c);
        }
        // 0 -> 2
        if(bucket[2] > c){
            int k = Math.min(bucket[2] - c, a);
            dfs(a-k, b, c+k);
        }
        // 1 -> 0
        if(bucket[0] > a){
            int k = Math.min(bucket[0] - a, b);
            dfs(a+k, b-k, c);
        }
        // 1 -> 2
        if(bucket[2] > c){
            int k = Math.min(bucket[2] - c, b);
            dfs(a, b-k, c+k);
        }
        // 2 -> 0
        if(bucket[0] > a){
            int k = Math.min(bucket[0] - a, c);
            dfs(a+k,b,c-k);
        }
        // 2 -> 1
        if(bucket[1] > b){
            int k = Math.min(bucket[1] - b, c);
            dfs(a,b+k,c-k);
        }
    }
}