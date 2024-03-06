package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 드래곤 커브
 */
public class A15685 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //드래곤 커브의 수
        int[][] curve = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                curve[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[101][101];
        int[][] dir = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};


        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            int c = curve[i][0]; // 시작 x
            int r = curve[i][1]; // 시작 y
            int d = curve[i][2]; // 방향
            int g = curve[i][3]; // 세대
            visited[r][c] = true;

            int newR = r + dir[d][0];
            int newC = c + dir[d][1];
            list.add(d);
            visited[newR][newC] = true;

            for (int j = 1; j <= g; j++) {
                List<Integer> list2 = new ArrayList<>();
                for (int k = list.size()-1; k >= 0; k--) {
                    int dd = list.get(k);
                    int newD = rotate(dd);
                    newR = newR + dir[newD][0];
                    newC = newC + dir[newD][1];
                    list2.add(newD);
                    visited[newR][newC] = true;
                }
                list.addAll(list2);
            }
        }

        // 돌면서 개수를 센다.
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(visited[i][j] && visited[i+1][j] && visited[i][j+1] && visited[i+1][j+1]){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    static int rotate(int t ){
        if(t+1 > 3) {
            return 0;
        } else {
            return t+1;
        }
    }
}
