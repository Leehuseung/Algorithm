package backjun.greedy;

import java.util.*;

/**
 * 최소 회의실 개수
 */
public class A19598_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] time = new int[N][2];
        for(int i = 0; i < N; i++) {
            time[i][0] = in.nextInt();
            time[i][1] = in.nextInt();
        }

        Arrays.sort(time, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int result = 0;
        for (int i = 0; i < time.length; i++) {
            if(que.isEmpty()) {
                que.add(time[i]);
                result = Math.max(result, que.size());
                continue;
            }
            while(!que.isEmpty()) {
                int[] arr = que.peek();
                //시작시간이 더 크다면
                if(time[i][0] >= arr[1]){
                    que.poll();
                } else break;
            }
            que.add(time[i]);
            result = Math.max(result, que.size());
        }
        System.out.println(result);
    }
}
/*
리팩토링.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] time = new int[N][2];
        for(int i = 0; i < N; i++) {
            time[i][0] = in.nextInt();
            time[i][1] = in.nextInt();
        }

        Arrays.sort(time, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int result = 0;
        for (int i = 0; i < time.length; i++) {
            que.add(time[i]);
            while(!que.isEmpty() && time[i][0] >= que.peek()[1]) {
                que.poll();
            }
            result = Math.max(result, que.size());
        }
        result = Math.max(result, que.size());
        System.out.println(result);
    }
}

 */