package backjun.greedy;

import java.util.*;

/**
 * 단어 수학
 */
public class A1339_2 {
    public static void main(String[] args) {
        int[] info = new int[30];
        int[] score = new int[30];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.next();
        }
        int result = 0;
        int s = 9;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        //길이는 큰순서,
        for (int i = 0; i < arr.length; i++) {
            char[] chars = arr[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int len = chars.length-j;
                char c = chars[j];
                pq.add(new int[]{c-65, len});
            }
        }
        //각 ABCD 등의 가중치를 구한다.
        while(!pq.isEmpty()){
            int[] c = pq.poll();
            int index = c[0];
            score[index] += (int) Math.pow(10, c[1]-1);
        }

        Arrays.sort(score);
        // 가중치 큰순서부터 9,.1 까지 곱해서 더한다.
        for (int i = score.length-1; i >= 0; i--) {
            if(s == 0){
                break;
            }
            result += (score[i] * s--);
        }

        System.out.println(result);
    }
}

