package backjun.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 인구 이동
 */
public class A16234 {
    static int N;
    static int L;
    static int R;
    static int[][] countries;
    static boolean[][] bools;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        L = in.nextInt();
        R = in.nextInt();
        countries = new int[N][];
        bools = new boolean[N][];

        for(int i = 0; i < N; i++) {
            countries[i] = new int[N];
            bools[i] = new boolean[N];
            for (int j = 0; j < N; j++) countries[i][j] = in.nextInt();
        }
        int result = 0;
        while (true) {
            boolean check = false;
            bools = new boolean[N][];
            for (int i = 0; i < N; i++) {
                bools[i] = new boolean[N];
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int[] info = new int[2];
                    info[0] = 0;
                    info[1] = 0;
                    List<int[]> list = new ArrayList<>();
                    bfs(i,j,info, list);
                    if(list.size() > 1){
                        check = true;
                    }
                    for (int k = 0; k < list.size(); k++) {
                        int row = list.get(k)[0];
                        int col = list.get(k)[1];
                        countries[row][col] = info[0] / info[1];
                    }
                }
            }
            if(!check) {
                break;
            } else {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void bfs(int i, int j, int[] cnt, List<int[]> list) {
        if(bools[i][j]){
            return;
        }
        bools[i][j] = true;
        list.add(new int[]{i,j});
        cnt[0] += countries[i][j];
        cnt[1]++;
        if(i != 0 && (Math.abs(countries[i][j]-countries[i-1][j]) >= L && Math.abs(countries[i][j]-countries[i-1][j]) <= R)) {
            bfs(i-1,j, cnt, list);
        };
        if(i != N-1 && (Math.abs(countries[i][j]-countries[i+1][j]) >= L && Math.abs(countries[i][j]-countries[i+1][j]) <= R)) {
            bfs(i+1,j, cnt, list);
        };
        if(j != 0 && (Math.abs(countries[i][j]-countries[i][j-1]) >= L && Math.abs(countries[i][j]-countries[i][j-1]) <= R)) {
            bfs(i,j-1, cnt, list);
        }
        if(j != N-1 && (Math.abs(countries[i][j]-countries[i][j+1]) >= L && Math.abs(countries[i][j]-countries[i][j+1]) <= R)) {
            bfs(i,j+1, cnt, list);
        }
    }
}
