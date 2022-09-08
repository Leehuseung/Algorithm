package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Lv2. 프렌즈 4블록
 */
public class FriendsFourBlock {

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] block = new char[m][n];
        //block 배열을 만든다.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                block[i][j] = board[i].charAt(j);
            }
        }

        int number = 1;
        while(number != 0){
            number = 0;
            Queue<RemoveBlock> removeBlocks = new LinkedList<>();

            //block 배열에서 사라지는 배열에 대해 검사한다.
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if(block[i][j] != 0 && block[i][j] == block[i+1][j] && block[i][j] == block[i][j+1] && block[i][j] == block[i+1][j+1]){
                        removeBlocks.add(new RemoveBlock(i,j));
                    }
                }
            }

            //queue의 block에 대해 null로 제거한다.
            while(!removeBlocks.isEmpty()){
                RemoveBlock point = removeBlocks.poll();
                if(block[point.cel][point.col] != 0){
                    answer ++;
                    number ++;
                    block[point.cel][point.col] = 0;
                }
                if(block[point.cel+1][point.col] != 0){
                    answer ++;
                    number ++;
                    block[point.cel+1][point.col] = 0;
                }
                if(block[point.cel][point.col+1] != 0){
                    answer ++;
                    number ++;
                    block[point.cel][point.col+1] = 0;
                }
                if(block[point.cel+1][point.col+1] != 0){
                    answer ++;
                    number ++;
                    block[point.cel+1][point.col+1] = 0;
                }
            }

            //null인 block을 위로 올린다.
            for (int i = m-1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if(block[i][j] == 0 && i != 0){
                        for (int k = i-1; k >= 0; k--) {
                            if(block[k][j] != 0){
                                //k와 j를 바꾼다.
                                block[i][j] = block[k][j];
                                block[k][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    static class RemoveBlock {
        int cel;
        int col;

        public RemoveBlock(int cel, int col) {
            this.cel = cel;
            this.col = col;
        }

    }

    public static void main(String[] args) {
//        System.out.println(solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));    // 14
        System.out.println(solution(6,6,new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));    // 15
    }
}
