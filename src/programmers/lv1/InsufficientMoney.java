package programmers.lv1;

public class InsufficientMoney {
    public static long solution(int price, int money, int count) {
        long totalPrice = 0;

        for (int i = 1; i <= count; i++) {
            totalPrice += (price * i);
        }

        return (totalPrice > money ? totalPrice - money : 0);
    }

    public static void main(String[] args) {
        System.out.println(solution(3,20,4));
    }
}
