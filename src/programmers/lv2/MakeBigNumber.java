package programmers.lv2;

/**
 * Lv2. 큰 수 만들기
 *
 * 22.06.16
 *
 * 22.06.21 StringBuilder로 변경 후 정답
 *
 */
public class MakeBigNumber {
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] chars = number.toCharArray();
        int j = chars.length-k;
        int index = 0;
        while(j > 0){
            char maxChar = '0';
            int len = chars.length-j;
            for (int i = index; i <= len; i++) {
                if(chars[i] > maxChar){
                    maxChar = chars[i];
                    index = i+1;
                }
            }
            --j;
            sb.append(maxChar + "");
        }
        return sb.toString();
    }


    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(solution("1924",2)); //94
        System.out.println(solution("1231234",3)); //3234
        System.out.println(solution("4177252841",4)); //775841
        System.out.println(solution("321924",2)); //3924
    }
}
