package programmers.lv3;

/**
 * Lv3. 정수 삼각형
 */
public class IntegerTriangle {

    public static int solution(int[][] triangle) {
        int answer = 0;
        if(triangle.length == 1) return triangle[0][0];
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(i != 0 && j == 0){
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j];
                } else if(i != 0 && (i == j)){
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
                } else {
                    if(i != 0 && (triangle[i-1][j-1] >= triangle[i-1][j])){
                        triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
                    } else if(i != 0 && (triangle[i-1][j-1] < triangle[i-1][j])){
                        triangle[i][j] = triangle[i][j] + triangle[i-1][j];
                    }
                }
                answer = Math.max(triangle[i][j],answer);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4},{4, 5, 2, 6, 5}})); // 30
    }
}
