package programmers.lv2;

import java.util.HashMap;
import java.util.HashSet;

public class MobileNumber {
    public static void main(String[] args) {

    }
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if(phone_book[i].equals(phone_book[j])){
                    continue;
                }
                if(phone_book[j].startsWith(phone_book[i])){
                    return false;
                }
            }
        }
        return answer;
    }
}
