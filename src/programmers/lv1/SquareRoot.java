package programmers.lv1;

import java.text.DecimalFormat;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(solution(121));
        System.out.println(solution(3));
    }
    public static long solution(long n) {
        long answer = 0;
        double num = Math.sqrt(n);

        answer = (long)num;

        if(num - (double)answer > 0){
            return -1;
        } else {
            return (answer+1) * (answer+1);
        }
    }
}
