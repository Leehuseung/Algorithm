package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 빗물
 */
public class A14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] map = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(H - arr[j] <= i) {
                    map[i][j] = true;
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] == false){
                    int left = j;
                    int right = j;
                    boolean leftStone = false;
                    while(left-- > 0) {
                        if(map[i][left] == true) {
                            leftStone = true;
                            break;
                        }
                    }
                    boolean rightStone = false;
                    while(right++ < W-1) {
                        if(map[i][right]) {
                            rightStone = true;
                            break;
                        }
                    }
                    if(leftStone && rightStone) {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
