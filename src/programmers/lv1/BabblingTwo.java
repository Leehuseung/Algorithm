package programmers.lv1;

/**
 * Lv1. 옹알이 (2)
 */
public class BabblingTwo {

    public static int solution(String[] babbling) {
        int answer = 0;
        String[] can = new String[]{"aya", "ye", "woo", "ma"};

        fir:
        for (int i = 0; i < babbling.length; i++) {
            String babble = babbling[i];

            String before = "";
            bab:
            while(babble.length() > 0) {
                for (int j = 0; j < can.length; j++) {
                    if(babble.startsWith(can[j])) {
                        if(before.equals(can[j])){
                            continue fir;
                        }
                        babble = babble.replaceFirst(can[j], "");
                        before = can[j];
                        continue bab;
                    }
                }
                break;
            }
            if(babble.length() == 0){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"aya", "yee", "u", "maa"} )); // 1
        System.out.println(solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"} )); // 2
    }
}
