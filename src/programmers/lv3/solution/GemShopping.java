package programmers.lv3.solution;

import java.util.*;
import java.util.stream.Collectors;

/**
 * lv3. 보석 쇼핑
 *
 * 2023.05.05 코드 및 디버깅까지 참고
 *
 * https://howtolivelikehuman.tistory.com/289
 */
public class GemShopping {
    public static int[] solution(String[] gems) {
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));  //3,7
        System.out.println(Arrays.toString(solution(new String[]{"AA", "AB", "AC", "AA", "AC"}))); //1,3
        System.out.println(Arrays.toString(solution(new String[]{"A","A","A","B","B"}))); //3,4
        System.out.println(Arrays.toString(solution(new String[]{"A","B","B","B","B","B","B","C","B","A"}))); //8,10
        System.out.println(Arrays.toString(solution(new String[]{"A", "B", "C", "B", "F", "D", "A", "F", "B", "D", "B"}))); //3,7
        System.out.println(Arrays.toString(solution(new String[]{"A", "B", "B", "A"}))); //3,7
    }
}


class AnswerGemShopping {
    public static int[] solution(String[] gems) {
        Map<String, Integer> gemNum = new HashMap<>();
        Set<String> allGem = Arrays.stream(gems).collect(Collectors.toCollection(HashSet::new));
        Queue<String> queue = new LinkedList<>();

        int st = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;

        for(int i=0; i<gems.length; i++){
            gemNum.put(gems[i], gemNum.getOrDefault(gems[i], 0) + 1);
            queue.add(gems[i]);
            while(true){
                String temp = queue.peek();
                if(gemNum.get(temp) > 1){
                    gemNum.put(temp, gemNum.get(temp)-1);
                    queue.poll();
                    st++;
                }
                else{
                    break;
                }
            }

            if(allGem.size() == gemNum.size() && length > queue.size()){
                length = queue.size();
                start = st;
            }
        }
        return new int[]{start+1, start+length};
    }
}

