package programmers.lv2;

/**
 * Lv2. k진수에서 소수 개수 구하기
 */
public class KDecimalCount {

    public static int solution(int n, int k) {
        int answer = 0;
        String convert = Long.toString(n,k);
        String arr[] = convert.split("0");

        for (int i = 0; i < arr.length; i++) {
            if(!arr[i].equals("")){
                long num = Long.parseLong(arr[i]);
                if(num != 1 && isPrime(num)){
                    answer++;
                }
            }
        }
        return answer;
    }

    private static boolean isPrime(long num) {
        for (int i = 2; Math.sqrt(num) <= num ; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(437674, 3) ); // 3
        System.out.println(solution(110011, 10)); //2
    }
}
