package leetcode.easy;

/**
 * 2224. Minimum Number of Operations to Convert Time
 */
public class MinimumNumberofOperationstoConvertTime {

    public static int convertTime(String current, String correct) {
        int answer = 0;
        String[] start = current.split(":");
        String[] end = correct.split(":");
        int startTime = Integer.parseInt(start[0]);
        int startMinute = Integer.parseInt(start[1]);
        int endTime = Integer.parseInt(end[0]);
        int endMinute = Integer.parseInt(end[1]);
        int startTotal = (startTime * 60) + startMinute;
        int endTotal = (endTime * 60) + endMinute;
        int result = endTotal - startTotal;

        while(result != 0){
            if(result >= 60){
                result -= 60;
            } else if(result >= 15){
                result -= 15;
            } else if(result >= 5){
                result -= 5;
            } else if(result >= 1){
                result -= 1;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(convertTime("02:30","04:35"));
    }
}
