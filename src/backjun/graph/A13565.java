package backjun.graph;

import java.util.Scanner;

/**
 * 침투
 */
public class A13565 {
    static int rrr, ccc;
    static int[][] graph;
    static boolean[][] visited;
    static boolean check = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        rrr = sc.nextInt();
        ccc = sc.nextInt();

        graph = new int[rrr][ccc];
        visited = new boolean[rrr][ccc];

        for (int i = 0; i < rrr; i++) {
            String str = sc.next();
            for (int j = 0; j < ccc; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < ccc; i++) {
            dfs(0,i);
        }

        System.out.println(check ? "YES" : "NO");
    }

    private static void dfs(int r, int c) {
        if(visited[r][c] || graph[r][c] == 1) return;
        if(r == rrr-1 && graph[r][c] == 0) {
            check = true;
        };
        visited[r][c] = true;

        if(c > 0 && !visited[r][c-1] && graph[r][c-1] == 0){
            dfs(r,c-1);
        }

        if(r > 0 && !visited[r-1][c] && graph[r-1][c] == 0){
            dfs(r-1,c);
        }

        if(r < rrr -1 && !visited[r+1][c] && graph[r+1][c] == 0){
            dfs(r+1,c);
        }

        if(c < ccc -1 && !visited[r][c+1] && graph[r][c+1] == 0){
            dfs(r,c+1);
        }
    }
}
