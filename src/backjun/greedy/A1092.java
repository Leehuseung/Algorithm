package backjun.greedy;

import java.util.*;

/**
 * 배
 */
public class A1092 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            arr.add(in.nextInt());
        }
        int M = in.nextInt();
        List<Integer> box = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            box.add(in.nextInt());
        }

        Collections.sort(arr, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());
        if(arr.get(0) < box.get(0)){
            System.out.println(-1);
            return;
        }

        int result = 0;

        while(!box.isEmpty()) {
            int index = 0;
            for (int i = 0; i < arr.size();) {
                if(index == box.size()){
                    break;
                }
                if(arr.get(i) >= box.get(index)){
                    box.remove(index);
                    i++;
                } else {
                    index++;
                }
            }
            result++;
            
        }
        System.out.println(result);
    }
}

/*
3
7 8 9
9
1 2 3 4 5 6 7 8 9
 */