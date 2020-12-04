package programmers;

import java.util.Arrays;

public class Knum {

	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int t = 0 ; t < commands.length; t++) {
        	int i = commands[t][0];
        	int j = commands[t][1];
        	int k = commands[t][2];
        	int[] arr = new int[j-i+1];
        	
        	int a = i-1;
        	for(int p = 1; p <= arr.length; p++) {
        		arr[p-1] = array[a++];
        	}
        	
        	Arrays.sort(arr);
        	
        	answer[t] = arr[k-1];
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		System.out.println(Arrays.toString(solution(array,commands)));


		System.out.println(Arrays.toString(solution(array,commands)));


	}
}
