package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 틱택토
 */
/*
OXOXOXOXX invalid
XO.X.OXO. invalid
 */
public class A7682 {

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();
            if(s.equals("end")) break;
            //board 초기화 및 배열생성
            board = new char[3][];
            board[0] = new char[]{s.charAt(0), s.charAt(1), s.charAt(2)};
            board[1] = new char[]{s.charAt(3), s.charAt(4), s.charAt(5)};
            board[2] = new char[]{s.charAt(6), s.charAt(7), s.charAt(8)};

            //숫자가 맞는지?
            boolean valid = countValid();
            if(!valid){
                System.out.println("invalid");
                continue;
            }
            boolean hasBlank = boardHasBlank();
            //공백을 갖고 있다면 한개만 승리해야한다.
            if(hasBlank) {
                int cnt = 0;
                boolean winnerX = validWinner('X');
                boolean winnerO = validWinner('O');
                if(winnerX) cnt++;
                if(winnerO) cnt++;
                if(cnt != 1) {
                    System.out.println("invalid");
                    continue;
                }
                //O 가 승리일 때는 숫자가 X 와 동일해야한다.
                if (winnerO && cnt == 1 && !countEqualValid()) {
                    System.out.println("invalid");
                    continue;
                }
                if (winnerX && cnt == 1 && !countXValid()) {
                    System.out.println("invalid");
                    continue;
                }
            //공백이 없다면 승리가 두개면 안됨.
            } else {
                int Xcnt = 0;
                int Ocnt = 0;
                boolean winnerX = validWinner('X');
                boolean winnerO = validWinner('O');
                if(winnerX) Xcnt++;
                if(winnerO) Ocnt++;
                if(Xcnt > 1 || Ocnt > 1 || (Xcnt > 0 && Ocnt > 0)){
                    System.out.println("invalid");
                    continue;
                }
                if ((winnerX && !countXValid())|| (winnerO && !countEqualValid())) {
                    System.out.println("invalid");
                    continue;
                }
            }
            System.out.println("valid");
        }
    }

    private static boolean validWinner(char b) {
        //가로 검사
        for (int i = 0; i < 3; i++) {
            int ttt = 0; // - 가로 검사
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == b) ttt++;
            }
            if(ttt == 3) return true;
        }
        //세로검사
        for (int i = 0; i < 3; i++) {
            int ttt = 0;
            for (int j = 0; j < 3; j++) {
                if(board[j][i] == b) ttt++;
            }
            if(ttt == 3) return true;
        }

        // \ 대각선 검사
        int ttt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j && board[i][j] == b){
                    ttt++;
                }
            }
        }
        if(ttt == 3) return true;

        // / 대각선 검사
        ttt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i + j == 2 && board[i][j] == b){
                    ttt++;
                }
            }
        }
        if(ttt == 3) return true;

        return false;
    }

    private static boolean boardHasBlank() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean countValid() {
        int xCnt = 0;
        int oCnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == 'X'){
                    xCnt++;
                } else if (board[i][j] == 'O'){
                    oCnt++;
                }
            }
        }
        return oCnt == xCnt || oCnt == xCnt-1;
    }
    private static boolean countXValid() {
        int xCnt = 0;
        int oCnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == 'X'){
                    xCnt++;
                } else if (board[i][j] == 'O'){
                    oCnt++;
                }
            }
        }
        return oCnt == xCnt-1;
    }

    private static boolean countEqualValid() {
        int xCnt = 0;
        int oCnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == 'X'){
                    xCnt++;
                } else if (board[i][j] == 'O'){
                    oCnt++;
                }
            }
        }
        return oCnt == xCnt;
    }
}
