package concept;

/**
 * 유클리드 호제법
 *
 * 최대 공약수를 구한다.
 */
public class UclidGCD {

    static int gcd(int x,int y) {
        if(y == 0){
            return x;
        } else {
            return gcd(y, x % y);
        }
    }


    public static void main(String[] args) {
        System.out.println(12 % 8);
    }
}
