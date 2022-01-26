package programmers.lv1;

public class NoneNumberPlus {

    public static int solution(int[] numbers) {
        int answer = 0;

        loop:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(numbers[j] == i){
                    continue loop;
                }
            }
            answer += i;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,8,4,0,6,7,9}));
    }
}
