package programmers.lv1;

/**
 * Lv1. 지폐 접기
 */
public class BillFolding {
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int walletMax = Math.max(wallet[0], wallet[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);

        int billMax = Math.max(bill[0], bill[1]);
        int billMin = Math.min(bill[0], bill[1]);

        while (billMax > walletMax || billMin > walletMin) {
            billMax = billMax/2;
            int a = billMax;
            int b = billMin;
            billMax = Math.max(a,b);
            billMin = Math.min(a,b);
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{50,50}, new int[] {100,241}));
    }
}
