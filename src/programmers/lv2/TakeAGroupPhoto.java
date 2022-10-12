package programmers.lv2;

/**
 * Lv2. 단체사진 찍기
 * 22.08.02
 */
public class TakeAGroupPhoto {
    static boolean[] bools = new boolean[8];
    static String[] arr = new String[]{"A","C","F","J","M","N","R","T"};
    static int answer;

    public static int solution(int n, String[] data) {
        answer = 0;
        for (int i = 0; i < arr.length; i++) {
            recursive(arr[i],i,data);
        }
        return answer;
    }

    private static void recursive(String s, int i,String[] data) {
        bools[i] = true;
        if(s.length() == 8){
            confirm(s,data);
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if(!bools[j]){
                recursive(s + arr[j], j,data);
                bools[j] = false;
            }
        }
        bools[i] = false;
    }

    private static void confirm(String s, String[] data) {
        for (int i = 0; i < data.length; i++) {
            String info = data[i];
            String start = info.charAt(0)+"";
            String end = info.charAt(2)+"";
            String cal = info.charAt(3)+"";
            int size = Integer.parseInt(info.charAt(4)+"");

            int len = Math.abs(s.indexOf(start) - s.indexOf(end))-1;
            if(cal.equals("<")){
                if(len < size){

                } else {
                    return;
                }
            } else if (cal.equals(">")){
                if(len > size) {

                } else {
                    return;
                }
            } else {
                if(len == size) {

                } else {
                    return;
                }
            }
        }
        ++answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2,new String[]{"N~F=0", "R~T>2"})); // 3648
        System.out.println(solution(2,new String[]{"M~C<2", "C~M>1"})); // 0
    }
}
