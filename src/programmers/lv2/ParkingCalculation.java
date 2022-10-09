package programmers.lv2;

import java.util.*;

/**
 * Lv2. 주차 요금 계산
 */
public class ParkingCalculation {
    public static int[] solution(int[] fees, String[] records) {
        List<String> list = new ArrayList();
        HashMap<String, Queue<String[]>> map = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] parkInfo = records[i].split(" ");
            String time = parkInfo[0];
            String carNum = parkInfo[1];
            String kind = parkInfo[2];

            if(!list.contains(carNum)){
                list.add(carNum);
            }

            if(!map.containsKey(carNum)){
                Queue<String[]> queue = new LinkedList<>();
                queue.add(new String[]{time,kind});
                map.put(carNum,queue);
            } else {
                Queue<String[]> queue = map.get(carNum);
                queue.add(new String[]{time,kind});
            }
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            Queue<String[]> queue = map.get(list.get(i));
            int fee = 0;
            int totalTime = 0;

            while(!queue.isEmpty()){
                String[] inInfo = queue.poll();
                String[] time = inInfo[0].split(":");
                int startHour = Integer.parseInt(time[0]);
                int startMinute = Integer.parseInt(time[1]);
                int endHour = 0;
                int endMinute = 0;
                if(!queue.isEmpty()){
                    String[] endInInfo = queue.poll();
                    String[] endTime = endInInfo[0].split(":");
                    endHour = Integer.parseInt(endTime[0]);
                    endMinute = Integer.parseInt(endTime[1]);
                } else {
                    endHour = 23;
                    endMinute = 59;
                }
                totalTime += (endHour * 60 + endMinute) - (startHour * 60 + startMinute);
            }

            if(totalTime <= fees[0]) {
                answer[i] = fees[1];
            } else {
                fee += fees[1];
                totalTime = totalTime - fees[0];
                fee += ((totalTime/fees[2]) * fees[3]);
                if(totalTime % fees[2] != 0){
                    fee += fees[3];
                }
                answer[i] = fee;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(
                solution(
                new int[]{180, 5000, 10, 600},
                new String[]
                    {
                        "05:34 5961 IN",
                        "06:00 0000 IN",
                        "06:34 0000 OUT",
                        "07:59 5961 OUT",
                        "07:59 0148 IN",
                        "18:59 0000 IN",
                        "19:09 0148 OUT",
                        "22:59 5961 IN",
                        "23:00 5961 OUT"
                    }
            )
        ));  //[14600, 34400, 5000]
    }
}
