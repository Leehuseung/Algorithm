package programmers.lv1;

public class FindNum {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
    public static int solution(int n) {
        int answer = 0;

        if(n >= 2){
            answer++;
        }

        for (int i = 3; i <= n; i++) {
            if(isPrime(i)){
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPrime(int num){
        for(int i=2; i * i<=2; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
