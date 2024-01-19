package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Bucket Brigade
 */
public class A17198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r = 10;

        char[][] field = new char[r][r];
        boolean[][] bools = new boolean[10][10];

        int[] start = new int[3];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String rowInput = br.readLine();
            for (int j = 0; j < r; j++) {
                field[i][j] = rowInput.charAt(j);
                if(field[i][j] == 'B'){
                    start = new int[]{i,j,0};
                    queue.add(start);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int i = arr[0];
            int j = arr[1];
            int cnt = arr[2];

            if(i > 0 && field[i-1][j] == 'L') {
                min = Math.min(min, cnt);
            }
            if(j > 0 && field[i][j-1] == 'L') {
                min = Math.min(min, cnt);
            }
            if(i < 9 && field[i+1][j] == 'L') {
                min = Math.min(min, cnt);
            }
            if(j < 9 && field[i][j+1] == 'L') {
                min = Math.min(min, cnt);
            }

            //주위를 넣는다.
            if(i > 0 && field[i-1][j] == '.' && field[i-1][j] != 'R' && field[i-1][j] != 'B') {
                field[i-1][j]='C';
                queue.add(new int[]{i-1,j,cnt+1});
            }
            if(j > 0 && field[i][j-1] == '.' && field[i][j-1] != 'R' && field[i][j-1] != 'B') {
                field[i][j-1]='C';
                queue.add(new int[]{i,j-1,cnt+1});
            }
            if(i < 9 && field[i+1][j] == '.' && field[i+1][j] != 'R' && field[i+1][j] != 'B') {
                field[i+1][j]='C';
                queue.add(new int[]{i+1,j,cnt+1});
            }
            if(j < 9 && field[i][j+1] == '.' && field[i][j+1] != 'R' && field[i][j+1] != 'B') {
                field[i][j+1]='C';
                queue.add(new int[]{i,j+1,cnt+1});
            }
        }
        System.out.println(min);
    }
}
