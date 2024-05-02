
package backjun.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 이중 우선순위 큐
 */
public class A7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            int k = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String symbol = st.nextToken();
                int q = Integer.parseInt(st.nextToken());

                if(symbol.equals("I")){
                    pq.add(q);
                    reversePq.add(q);
                    map.put(q, map.getOrDefault(q, 0) +1);
                } else if (symbol.equals("D")) {
                    removePq(map, q == -1 ? pq : reversePq);
                }
            }

            if(map.size() == 0){
                System.out.println("EMPTY");
                continue;
            }

            print(reversePq, map);
            print(pq, map);
        }
    }

    private static void print(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
        while(true) {
            int tt = pq.peek();
            if(map.containsKey(tt)){
                System.out.print(tt + " ");
                break;
            } else {
                pq.poll();
            }
        }
    }

    private static void removePq(Map<Integer, Integer> map, PriorityQueue<Integer> pq) {
        while(true) {
            if(map.containsKey(pq.peek())) {
                int tt = pq.poll();
                int mapInt = map.get(tt)-1;
                if(mapInt == 0) {
                    map.remove(tt);
                } else {
                    map.put(tt, mapInt);
                }
                break;
            }
            if(pq.size() == 0) break;
            pq.poll();
        }
    }
}