package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 전쟁 - 전투
 */
public class A1303 {
    static int n;
    static int m;
    static char[][] arr;
    static int[][] dir = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    static List<Integer> white;
    static List<Integer> blue;
    static boolean[][] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];
        white = new ArrayList<>();
        blue = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    cnt = 0;
                    dfs(i,j);
                    if(arr[i][j] == 'B'){
                        blue.add(cnt);
                    } else {
                        white.add(cnt);
                    }
                }
            }
        }

        long whiteInteger = 0;
        long blueInteger = 0;

        for (int i = 0; i < white.size(); i++) {
            whiteInteger += Math.pow(white.get(i),2);
        }

        for (int i = 0; i < blue.size(); i++) {
            blueInteger += Math.pow(blue.get(i),2);
        }

        System.out.println(whiteInteger + " " + blueInteger);
    }

    private static void dfs(int i, int j) {
        if(visited[i][j]) return;
        cnt++;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newR = i + dir[k][0];
            int newC = j + dir[k][1];
            if(newR >= 0 && newC >= 0 && newR < n && newC < m && arr[i][j] == arr[newR][newC]){
                dfs(newR,newC);
            }
        }
    }
}
