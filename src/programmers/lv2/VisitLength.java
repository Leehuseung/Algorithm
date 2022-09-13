package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

/**
 * Lv2. 방문 길이
 */
public class VisitLength {

    public static int solution(String dirs) {
        Board board = new Board();
        for (int i = 0; i < dirs.length(); i++) {
            board.command(dirs.charAt(i)+"");
        }
        return board.set.size();
    }

    static class Board {
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;

        public void addHistory(String before){
            String xy = before + x + "" + y;
            String reverseXY = x + "" + y + before;
            if(!set.contains(xy) && !set.contains(reverseXY)){
                set.add(xy);
            }
        }

        public void command(String command) {
            String before = x + "" + y;
            switch (command){
                case "U" :
                    if(y <= 4){
                        y++;
                        addHistory(before);
                    }
                break;
                case "D" :
                    if(y >= -4){
                        y--;
                        addHistory(before);
                    }
                break;
                case "L" :
                    if(x >= -4){
                        x--;
                        addHistory(before);
                    }
                break;
                case "R" :
                    if(x <= 4){
                        x++;
                        addHistory(before);
                    }
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU")); //7
        System.out.println(solution("LULLLLLLU")); //7
    }
}
