package programmers.lv2.solution;

/**
 * Lv2. 멀쩡한 사각형
 *
 * 22.06.20
 *
 * Solution - 유클리드 호제법을 사용해야한다.. 풀이 참고함.
 *
 */
public class NormalSquare {

    public static long solution(long w, long h) {
        return w * h - (w + h - recursive(w,h));
    }

    public static long recursive(long a ,long b) {
        if(b == 0){
            return a;
        } else {
            return recursive(b, a % b);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(8,12)); //80
    }
}
