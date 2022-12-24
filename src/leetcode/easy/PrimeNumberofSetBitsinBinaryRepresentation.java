package leetcode.easy;

/**
 * 762. Prime Number of Set Bits in Binary Representation
 */
public class PrimeNumberofSetBitsinBinaryRepresentation {

    public static int countPrimeSetBits(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int bitCnt = Integer.bitCount(i);
            if(bitCnt != 1 && isPrime(bitCnt)){
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPrime(int number){
        for (int i = 2; i <= Math.sqrt(number) ; i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6,10));
        System.out.println(countPrimeSetBits(10,15));
    }
}
