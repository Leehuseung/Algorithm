package programmers.lv2;

import java.util.*;

/**
 * Lv2. [3차] 압축
 */
public class Press {
    public static int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();

        HashMap<String,Integer> map = new HashMap<>();
        int num = 1;
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            map.put(c++ + "",num++);
        }

        for (int i = 0; i < msg.length(); ) {
            String s = msg.charAt(i)+"";
            if(i != msg.length()-1){
                String answerKey = s;
                while(map.containsKey(s)){
                    if(i == msg.length()-1){
                        answerKey = answerKey + msg.charAt(i)+"";
                        i++;
                        break;
                    }
                    i++;
                    answerKey = s;
                    s = s + msg.charAt(i);
                }
                list.add(map.get(answerKey));
            } else {
                i++;
                list.add(map.get(s));
            }
            if(s.length() != 1){
                map.put(s,num++);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO"))); //[11, 1, 27, 15]
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT"))); //[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        System.out.println(Arrays.toString(solution("ABABABABABABABAB"))); //	[1, 2, 27, 29, 28, 31, 30]
    }
}
