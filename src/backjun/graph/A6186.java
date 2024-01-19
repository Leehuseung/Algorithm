package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Best Grass
 */
public class A6186 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int result = 0;

        char[][] field = new char[r][c];
        boolean[][] bools = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String rowInput = br.readLine();
            for (int j = 0; j < c; j++) {
                field[i][j] = rowInput.charAt(j);
            }
        }


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i > 0 && !bools[i-1][j] && field[i-1][j] == '#'){
                    bools[i][j] = true;
                }
                if(j > 0 && !bools[i][j-1] && field[i][j-1] == '#'){
                    bools[i][j] = true;
                }
                if(i < r-1 && !bools[i+1][j] && field[i+1][j] == '#'){
                    bools[i][j] = true;
                }
                if(j < c-1 && !bools[i][j+1] && field[i][j+1] == '#'){
                    bools[i][j] = true;
                }
                if(!bools[i][j] && field[i][j] == '#'){
                    result++;
                    bools[i][j] = true;
                }
            }
        }
        System.out.println(result);
    }
}
