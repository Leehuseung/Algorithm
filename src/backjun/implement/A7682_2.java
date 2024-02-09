package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 틱택토
 */
public class A7682_2 {
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

            int xBingoCnt = 0;
            int oBingoCnt = 0;

            //가로를 검사하자.
            for (int i = 0; i < 3; i++) {
                if(board[i][0] == 'X' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) xBingoCnt++;
                if(board[i][0] == 'O' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) oBingoCnt++;
            }

            //세로를 검사하자.
            for (int i = 0; i < 3; i++) {
                if(board[0][i] == 'X' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) xBingoCnt++;
                if(board[0][i] == 'O' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) oBingoCnt++;
            }

            //'/'를 검사하자.
            if(board[2][0] == 'X' && board[2][0] == board[1][1] && board[1][1] == board[0][2]) xBingoCnt++;
            if(board[2][0] == 'O' && board[2][0] == board[1][1] && board[1][1] == board[0][2]) oBingoCnt++;

            //'\'를 검사하자.
            if(board[0][0] == 'X' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) xBingoCnt++;
            if(board[0][0] == 'O' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) oBingoCnt++;

            int xCnt = 0;
            int oCnt = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(board[i][j] == 'O') oCnt++;
                    if(board[i][j] == 'X') xCnt++;
                }
            }

            //2 이상이면 틀림
            if((xBingoCnt + oBingoCnt) >= 2) {
                if(xBingoCnt == 2 && xCnt == 5 && oCnt == 4){
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
            }else if(xBingoCnt == 1 && (xCnt == oCnt+1)) {
                System.out.println("valid");
            }else if(oBingoCnt == 1 && xCnt == oCnt) {
                System.out.println("valid");
            }else if(oBingoCnt == 0 && xBingoCnt == 0 && xCnt == 5 && oCnt == 4) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }
}
