package programmers.lv2;

import java.util.*;

/**
 * Lv2. 튜플
 */
public class Tuple {

    public static int[] solution(String s) {
        Map<String, Integer> counter = new HashMap<String, Integer>();
        String[] arr = s.replaceAll("\\{","").replaceAll("\\}","").split(",");

        for (int i = 0; i < arr.length; i++) {
            Integer cnt = counter.get(arr[i]);
            counter.put(arr[i], cnt == null? 1 : cnt + 1);
        }

        //배열을 완성한다.
        int[] answer = new int[counter.size()];
        Iterator it = counter.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry)it.next();
            answer[counter.size()-entry.getValue()] = Integer.parseInt(entry.getKey());
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));  //[2, 1, 3, 4]
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))); //[2, 1, 3, 4]
        System.out.println(Arrays.toString(solution("{{20,111},{111}}"))); //	[111, 20]
        System.out.println(Arrays.toString(solution("{{123}}"))); //	[123]
        System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))); //[3, 2, 4, 1]
    }
}
