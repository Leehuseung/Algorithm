package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 치킨 배달
 */
public class A15686 {
    static int[][] map;
    static int removeCnt;
    static int result = Integer.MAX_VALUE;
    static List<int[]> list;
    static List<int[]> homeList;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int storeCnt = 0;
        list = new ArrayList<>();
        homeList = new ArrayList<>();
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    storeCnt++;
                    list.add(new int[]{i,j});
                } else if (map[i][j] == 1) {
                    homeList.add(new int[]{i,j});
                }
            }
        }

        removeCnt = storeCnt-M;
        if(removeCnt > 0) combination(removeCnt - 1, 0, true);
        //첫째를 안지우는 경우
        combination(removeCnt, 0, false);

        System.out.println(result);
    }

    private static void combination(int cnt, int i, boolean remove) {
        if(i > list.size()-1) return;
        int[] info = list.get(i);
        int r = info[0];
        int c = info[1];
        if(remove){
            map[r][c] = 0;
        }

        if(cnt == 0){
            //남은수를 계산한다.
            int sum = 0;

            for (int j = 0; j < homeList.size(); j++) {
                int[] ii = homeList.get(j);
                int rr = ii[0];
                int cc = ii[1];
                int min = Integer.MAX_VALUE;
                for (int t = 1; t < map.length; t++) {
                    for (int k = 1; k < map.length; k++) {
                        if(map[t][k] == 2) {
                            min = Math.min(min, Math.abs(rr-t) + Math.abs(cc-k));
                        }
                    }
                }
                sum += min;
            }

            result = Math.min(result, sum);
            if(remove)map[r][c] = 2;
            return;
        }
        //지우는 경우
        combination(cnt-1,i+1, true);
        //안지우는 경우
        combination(cnt, i+1, false);
        if(remove) {
            map[r][c] = 2;
        }
    }
}
