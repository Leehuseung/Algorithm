package programmers;

public class MobileNumHide {
    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
    }
    public static String solution(String phone_number) {
        String answer = "";

        for(int i = 0 ; i < phone_number.length() - 4; i++){
            answer += "*";
        }

        return answer+phone_number.substring(phone_number.length()-4,phone_number.length());
    }
}
