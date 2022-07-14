package programmers.lv2;


import java.util.LinkedList;

/**
 * Lv2. 1차 캐시
 */
public class Cash {

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if(cacheSize == 0){
                answer += 5;
                continue;
            }
            if(list.contains(city)) {
                answer++;
                list.remove(city);
                list.addFirst(city);
            } else if(list.size() == cacheSize){
                list.removeLast();
                list.addFirst(city);
                answer += 5;
            } else {
                list.addFirst(city);
                answer += 5;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(3 , new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"} )); // 50
        System.out.println(solution(3 , new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"} )); // 21
        System.out.println(solution(2 , new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"} )); // 60
        System.out.println(solution(5 , new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"} )); // 52
        System.out.println(solution(2 , new String[]{"Jeju", "Pangyo", "NewYork", "newyork"} )); // 16
        System.out.println(solution(0 , new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"} )); // 25

    }
}
