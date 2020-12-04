package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


class Solution {
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
        //zz
        //testfdsfdsf
        //testfdsfdsfdd
        //testfdsfdsf
        return answer;
    }
}