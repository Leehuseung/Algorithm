package programmers.lv2;

import java.util.*;

/**
 * Lv2. 호텔 대실
 *
 * 풀이참고.
 */
public class HotelReservation {

    public static int solution(String[][] book_time) {
        Arrays.sort(book_time, Comparator.comparing(o -> o[0]));
        int time[][] = new int[book_time.length][2];

        for(int i =0;i<book_time.length;i++){
            int startTime = Integer.parseInt(book_time[i][0].replace(":",""));
            int endTime = Integer.parseInt(book_time[i][1].replace(":",""));

            endTime += 10;
            if(endTime%100 >= 60){
                endTime+=40;
            }
            time[i][0] = startTime;
            time[i][1] = endTime;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();


        for(int[] timeTemp : time){
            if(queue.size() == 0){
                queue.add(timeTemp[1]);
                continue;
            }
            if((queue.peek()) <= timeTemp[0]){
                queue.poll();
                queue.add(timeTemp[1]);
            }else{
                queue.add(timeTemp[1]);
            }
        }

        return queue.size();
    }

    public static void main(String[] args) {
//        System.out.println(solution(new String[][]{
//            {"10:00", "12:00"},
//            {"12:20", "13:00"},
//        })); //3
        System.out.println(solution(new String[][]{
            {"15:00", "17:00"},
            {"16:40", "18:20"},
            {"14:20", "15:20"},
            {"14:10", "19:20"},
            {"18:20", "21:20"}
        })); //3
//        System.out.println(solution(new String[][]{
//                {"09:10", "10:10"},
//                {"05:20", "07:00"}
//        })); // 1
//        System.out.println(solution(new String[][]{
//            {"10:20", "12:30"},
//            {"10:20", "12:30"},
//            {"10:20", "12:30"}
//        })); //3
//        System.out.println(solution(new String[][]{
//                {"05:57", "06:02"},
//                {"04:00", "06:59"},
//                {"03:56", "07:57"},
//                {"06:12", "08:55"},
//                {"07:09", "07:11"}
//        }));// 3
//        System.out.println(solution(new String[][]{
//                {"00:01","00:10"},
//                {"00:19","00:29"},
//        }));// 2
//        System.out.println(solution(new String[][]{
//                {"08:00", "08:30"},
//                {"08:00", "13:00"},
//                {"12:30", "13:30"}
//        }));// 2
//        System.out.println(solution(new String[][]{
//                {"16:00", "16:10"},
//                {"16:10", "16:20"},
//                {"16:20", "16:30"}
//        }));// 2
//        System.out.println(solution(new String[][]{
//                {"10:58", "14:59"},
//                {"10:00", "11:59"},
//        }));//2
//        System.out.println(solution(new String[][]{
//                {"10:58", "14:59"},
//                {"10:00", "10:01"},
//        }));//2
    }
}
