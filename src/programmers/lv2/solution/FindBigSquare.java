package programmers.lv2.solution;

/**
 * Lv2. 가장 큰 정사각형 찾기
 *
 * 22.06.30
 *
 * 22.07.12 DP를 활용한 풀이.
 *
 * 브루트 포스트로 처음에 풀이했지만 효율성 테스트 실패
 *
 * DP를 사용하는건 봤지만 풀이과정은 생각하지 못했다. 코드는 안보고 로직까지만 확인.
 */
public class FindBigSquare {
    public static long solution(int[][] board) {
        int max = 0;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                int top = board[i-1][j];
                int left = board[i][j-1];
                int topLeft = board[i-1][j-1];
                int min = Integer.MAX_VALUE;

                min = Math.min(min,top);
                min = Math.min(min,left);
                min = Math.min(min,topLeft);

                if(min > 0 && board[i][j] > 0){
                    board[i][j] = min+1;
                    max = Math.max(board[i][j],max);
                } else if (max == 0 && board[i][j] == 1){
                    max = 1;
                }
            }
        }
        if(max == 0 && (board[0][0] == 1 || board[1][0] == 1 || board[0][1] == 1)){
            max = 1;
        }
        return max * max;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0},{0,0}})); // 1
        System.out.println(solution(new int[][]{{0}})); // 0
        System.out.println(solution(new int[][]{{0,0},{0,0}})); // 0
        System.out.println(solution(new int[][]{{0,1},{0,0}})); // 0
        System.out.println(solution(new int[][]{{0,0},{1,0}})); // 0
        System.out.println(solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}})); //9
        System.out.println(solution(new int[][]{{1,1,1,1},{0,1,1,1},{0,1,1,1}})); //9
        System.out.println(solution(new int[][]{{0,0,1,1},{1,1,1,1}})); //4
        System.out.println(solution(new int[][]{{1,1,1},{1,0,1},{1,1,1}})); //1
        System.out.println(solution(new int[][]{
                {1, 1, 0, 0, 1, 1, 1},
                {1, 1, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1}
        })); //16
    }
}