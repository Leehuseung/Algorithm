package concept;
/**
 * 987654321 이 존재한다.
 * 1의자리부터 순회해보자. String. 말고.
 */
public class Digit {
    public static void main(String[] args) {
        int k = 987654310;
        while(k > 0) {
            System.out.print(k % 10 + " ");
            k /= 10;
        }
        System.out.println();
    }
}
