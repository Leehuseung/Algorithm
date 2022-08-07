package programmers.lv2;

import java.util.Arrays;

/**
 * Lv2. 카카오 프렌즈 컬러링북
 */
public class KakaoBook {
    static boolean[][] visit = null;
    static int sum;
    public static int[] solution(int m, int n, int[][] picture) {
        visit = new boolean[picture.length][picture[0].length];
        sum = 0;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                sum = 0;
                if(visit[i][j] || picture[i][j] == 0){
                    continue;
                }
                numberOfArea++;
                recur(picture,i,j,picture[i][j]);
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea,sum);
            }
        }
        return new int[]{numberOfArea,maxSizeOfOneArea};
    }

    private static void recur(int[][] picture, int i, int j, int target) {
        if(picture.length == i || picture[0].length == j || j < 0 || i < 0) {
            return;
        }else if(picture[i][j] != target || visit[i][j]){
            return;
        } else {
            visit[i][j] = true;
            sum++;
        }
        recur(picture,i+1,j,target);
        recur(picture,i,j+1,target);
        recur(picture,i-1,j,target);
        recur(picture,i,j-1,target);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6,4,new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
        System.out.println(Arrays.toString(solution(13,16,new int[][]{
                {0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
                {0 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,1 ,1 ,0 ,0 ,0 ,0 ,0 ,0 },
                {0 ,0 ,0 ,0 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,0 ,0 ,0 ,0 },
                {0 ,0 ,0 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,0 ,0 ,0 },
                {0 ,0 ,1 ,1 ,1 ,2 ,1 ,1 ,1 ,1 ,2 ,1 ,1 ,1 ,0 ,0 },
                {0 ,1 ,1 ,1 ,2 ,1 ,2 ,1 ,1 ,2 ,1 ,2 ,1 ,1 ,1 ,0 },
                {0 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,0 },
                {0 ,1 ,2 ,2 ,2 ,1 ,1 ,1 ,1 ,1 ,1 ,2 ,2 ,2 ,1 ,0 },
                {0 ,1 ,1 ,1 ,1 ,1 ,2 ,1 ,1 ,2 ,1 ,1 ,1 ,1 ,1 ,0 },
                {0 ,0 ,1 ,1 ,1 ,1 ,1 ,2 ,2 ,1 ,1 ,1 ,1 ,1 ,0 ,0 },
                {0 ,0 ,0 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,0 ,0 ,0 },
                {0 ,0 ,0 ,0 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,0 ,0 ,0 ,0 }
        })));
    }
}
