package programmers.lv1;

/**
 * Lv1. 숫자 짝꿍
 */
public class NumberMate {
    public static String solution(String X, String Y) {
        String answer = "";

        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for (int i = 0; i < xArr.length; i++) {
            xArr[i] = 0;
        }

        for (int i = 0; i < yArr.length; i++) {
            yArr[i] = 0;
        }

        for (int i = 0; i < X.length(); i++) {
            Integer integer = Integer.valueOf(String.valueOf(X.charAt(i)));
            ++xArr[integer];
        }

        for (int i = 0; i < Y.length(); i++) {
            Integer integer = Integer.valueOf(String.valueOf(Y.charAt(i)));
            ++yArr[integer];
        }

        boolean all = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            Integer min = Math.min(xArr[i], yArr[i]);
            if(i > 0 && min > 0) all = false;
            for (int j = 0; j < min; j++) {
                sb.append(i);
            }
        }

        answer = sb.toString();

        return answer.equals("") ? "-1" : all ? "0" : answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("100","2345")); //-1
        System.out.println(solution("12321","42531")); //321
    }
}
