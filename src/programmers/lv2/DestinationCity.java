package programmers.lv2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 1436. Destination City
 */
public class DestinationCity {

    public static String destCity(List<List<String>> paths) {
        LinkedList<String> list = new LinkedList<>();
        Queue<List<String>> queue = new LinkedList<>();
        for (int i = 0; i < paths.size(); i++) {
            List<String> cities = paths.get(i);
            if(i == 0){
                list.add(cities.get(0));
                list.add(cities.get(1));
            } else {
                queue.add(cities);
            }
        }
        while(!queue.isEmpty()) {
            List<String> cities = queue.poll();
            String cityA = cities.get(0);
            String cityB = cities.get(1);
            if(list.getLast().equals(cityA)){
                list.add(cityB);
            } else if(list.getFirst().equals(cityB)){
                list.addFirst(cityA);
            } else {
                queue.add(cities);
            }
        }
        return list.getLast();
    }

}

