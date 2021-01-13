package programmers.lv1;

import java.util.Stack;

public class DoorPick {
    public static void main(String[] args) {
        int[][] a = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] b = {1,5,3,5,1,2,1,4};
        System.out.println(solution(a,b));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        a:
        for (int i = 0; i < moves.length; i++) {
            int selNum = moves[i]-1;
            for (int j = 0; j < board[selNum].length ; j++) {
                if(board[j][selNum] != 0){
                    if(stack.size() != 0 && stack.peek() == board[j][selNum]){
                        stack.pop();
                        answer++;
                        board[j][selNum] = 0;
                        continue a;
                    } else {
                        stack.add(board[j][selNum]);
                        board[j][selNum] = 0;
                        continue a;
                    }
                }
            }
        }
        return answer * 2;
    }
}