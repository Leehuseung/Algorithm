package programmers.lv1;

import java.util.*;

class exam {
    public static int[] solution(int[] answers) {
        int[] answer = new int[3];
        
        int[] aPick = {1,2,3,4,5};
        int[] bPick = {2,1,2,3,2,4,2,5};
        int[] cPick = {3,3,1,1,2,2,4,4,5,5};
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	
    	for(int i = 0 ; i < answers.length; i++) {
    		if(answers[i] == cPick[i%10]) answer[2]++;
    		if(answers[i] == bPick[i%8])  answer[1]++;
    		if(answers[i] == aPick[i%5])  answer[0]++;
    	}

    	map.put(answer[2],3);
    	map.put(answer[1],2);
    	map.put(answer[0],1);

    	Arrays.sort(answer);

    	List<Integer> resultList = new ArrayList<Integer>();
    	
    	for(int i = answer.length-1; i >= 0; i--) {
    		if(i == answer.length-1) {
    			resultList.add(answer[i]);
    		} else if(answer[i] == answer[i+1]){
    			resultList.add(answer[i]);
    		} else {
    			break;
    		}
    	} 
    	
    	answer = new int[resultList.size()];
    	
    	
    	
    	for(int i = 0 ; i < resultList.size(); i++) {
    		if(!map.containsKey(resultList.get(i))) {
    			if(map.size() == 0) {
    				answer[i] = answer[i-1]+1;
    			}
    			for(Map.Entry<Integer,Integer> mapdetail : map.entrySet()) {
    				if(mapdetail.getValue() == 2) {
    					answer[i] = answer[i-1]+2;
    				} else {
    					answer[i] = answer[i-1]+1;
    				}
    			}
    		} else {
    			answer[i] = (int)map.get(resultList.get(i));
    			map.remove(resultList.get(i));
    		}
    	}
    	
    	return answer;
    }
    
    public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{2,1,1,1})));
	}
    
    
}