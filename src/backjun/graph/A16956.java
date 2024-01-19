package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 늑대와 양
 */
public class A16956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int result = 1;

        char[][] field = new char[r][c];

        for (int i = 0; i < r; i++) {
            String rowInput = br.readLine();
            for (int j = 0; j < c; j++) {
                field[i][j] = rowInput.charAt(j);
            }
        }
    loop:
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //늑대가 옆에 존재하면 종료한다.
                if(i > 0 && field[i][j] == 'S' && field[i-1][j] == 'W') {
                    result = 0;
                    break loop;
                }
                if(j > 0 && field[i][j] == 'S' && field[i][j-1] == 'W') {
                    result = 0;
                    break loop;
                }
                if(i < r-1 && field[i][j] == 'S' && field[i+1][j] == 'W') {
                    result = 0;
                    break loop;
                }
                if(j < c-1 && field[i][j] == 'S' && field[i][j+1] == 'W') {
                    result = 0;
                    break loop;
                }
                //그게 아니면 옆에를 'D'로 바꾼다.
                if(i > 0 && field[i][j] == 'S' && field[i-1][j] == '.') {
                    field[i-1][j] = 'D';
                };
                if(j > 0 && field[i][j] == 'S' && field[i][j-1] == '.') {
                    field[i][j-1] = 'D';
                };
                if(i < r-1 && field[i][j] == 'S' && field[i+1][j] == '.') {
                    field[i+1][j] = 'D';
                };
                if(j < c-1 && field[i][j] == 'S' && field[i][j+1] == '.') {
                    field[i][j+1] = 'D';
                };
            }
        }
        System.out.println(result);
        if(result == 1){
            for (int i = 0; i < r; i++) {
                System.out.println(String.valueOf(field[i]));
            }
        }
    }
}
