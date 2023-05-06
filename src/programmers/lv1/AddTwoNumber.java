package programmers.lv1;

import java.util.*;


class AddTwoNumber {
    public int[] solution(int[] numbers) {
        Set set = new HashSet<Integer>();
        for(int i = 0 ; i < numbers.length ; i++) {
        	for(int j = i+1; j < numbers.length; j++) {
    			set.add(numbers[i] + numbers[j]);
        	}
        }
        
        int[] answer = new int[set.size()];
        
        List list = new ArrayList<>(set);
        
        Collections.sort(list);
        
        for(int i = 0 ; i < list.size(); i++) {
        	answer[i] = (Integer)list.get(i);
        }
        return answer;
    }
}