package leetcode.easy;

/**
 * 999. Available Captures for Rook
 */
public class AvailableCapturesforRook {

    public static int numRookCaptures(char[][] board) {
        int answer = 0;
        loop:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'R'){
                    //상
                    if(i != 0){
                        for (int k = i; k >= 0; k--) {
                            if(board[k][j] == 'p'){
                                answer++;
                                break;
                            } else if(board[k][j] == 'B'){
                                break;
                            }
                        }
                    }

                    //하
                    if(i != board.length-1){
                        for (int k = i; k < board.length; k++) {
                            if(board[k][j] == 'p'){
                                answer++;
                                break;
                            } else if(board[k][j] == 'B'){
                                break;
                            }
                        }
                    }

                    //좌
                    if(j != 0){
                        for (int k = j; k >= 0; k--) {
                            if(board[i][k] == 'p'){
                                answer++;
                                break;
                            } else if(board[i][k] == 'B'){
                                break;
                            }
                        }
                    }

                    //우
                    if(j != board[i].length-1){
                        for (int k = j; k < board.length; k++) {
                            if(board[i][k] == 'p'){
                                answer++;
                                break;
                            } else if(board[i][k] == 'B'){
                                break;
                            }
                        }
                    }
                    break loop;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(numRookCaptures(new char[][]{
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
        }));

        numRookCaptures(new char[][]{
                {'R','.','p','.','p','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'p','.','.','.','.','.','.','.'},
                {'p','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
        });
    }
}
