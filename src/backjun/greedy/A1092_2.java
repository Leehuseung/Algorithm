package backjun.greedy;

import java.util.*;

/**
 * 배
 */
public class A1092_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> cranes = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            cranes.add(in.nextInt());
        }
        int M = in.nextInt();
        List<Integer> boxes = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            boxes.add(in.nextInt());
        }

        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());
        if(cranes.get(0) < boxes.get(0)){
            System.out.println(-1);
            return;
        }

        int result = 0;

        while(!boxes.isEmpty()){
            int index = 0;
            for (int i = 0; i < cranes.size();) {
                if(index == boxes.size()) break;
                int crane = cranes.get(i);
                int box = boxes.get(index);

                if(box <= crane){
                    boxes.remove(index);
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
