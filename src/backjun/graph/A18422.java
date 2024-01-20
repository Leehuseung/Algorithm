package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Emacs
 */
public class A18422 {
    static char[][] field;
    static boolean[][] bools;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        field = new char[r][c];
        bools = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String rowInput = br.readLine();
            for (int j = 0; j < c; j++) {
                field[i][j] = rowInput.charAt(j);
            }
        }
        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!bools[i][j] && field[i][j] == '*'){
                    result++;
                    extracted(i,j);
                }
            }
        }
        System.out.println(result);
    }

    private static void extracted(int t, int o) {
        for (int i = t; i < r; i++) {
            for (int j = o; j < c; j++) {
                if(field[i][j] == '.') return;
                if(field[i][j] == '*' && !bools[i][j]){
                    bools[i][j] = true;
                }
                //그게 아니면 옆에를 'D'로 바꾼다.
                if(i > 0 && field[i][j] == '*' && field[i-1][j] == '*' && !bools[i-1][j]) {
                    extracted(i-1,j);
                };
                if(j > 0 && field[i][j] == '*' && field[i][j-1] == '*' && !bools[i][j-1]) {
                    extracted(i,j-1);
                };
                if(i < r -1 && field[i][j] == '*' && field[i+1][j] == '*' && !bools[i+1][j]) {
                    extracted(i+1,j);
                };
                if(j < c -1 && field[i][j] == '*' && field[i][j+1] == '*' && !bools[i][j+1]) {
                    extracted(i,j+1);
                };
            }
        }
    }
}
