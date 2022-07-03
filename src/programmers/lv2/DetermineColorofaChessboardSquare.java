package programmers.lv2;

/**
 * LeetCode 1812. Determine Color of a Chessboard Square
 */
public class DetermineColorofaChessboardSquare {
    public static boolean squareIsWhite(String coordinates) {
        int a = coordinates.charAt(0) - 96;
        int b = Integer.parseInt(coordinates.charAt(1) + "");
        if((a%2==0 && b%2==0) ||(a%2==1 && b%2==1)){
           return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(squareIsWhite("a1")); //false
        System.out.println(squareIsWhite("h3")); //true
        System.out.println(squareIsWhite("c7")); //false
    }
}
