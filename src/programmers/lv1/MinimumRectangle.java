package programmers.lv1;

public class MinimumRectangle {

    public static int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0;
        int maxH = 0;

        //가로를 무조건 크게 만든다.
        if(sizes[0][0] > sizes[0][1]){
            maxW = sizes[0][0];
            maxH = sizes[0][1];
        } else {
            maxW = sizes[0][1];
            maxH = sizes[0][0];
        }

        for (int i = 0; i < sizes.length; i++) {
            int nowW = sizes[i][0];
            int nowH = sizes[i][1];

            //가로를 무조건 크게 만든다.
            if(sizes[i][0] > sizes[i][1]){
                nowW = sizes[i][0];
                nowH = sizes[i][1];
            } else {
                nowW = sizes[i][1];
                nowH = sizes[i][0];
            }

            //가로 세로가 안맞을 경우
            if(nowW > maxW && nowH > maxH){
                maxW = nowW;
                maxH = nowH;
            //가로가 큰 경우
            } else if(nowW > maxW && nowH <= maxH){
                maxW = nowW;
            //세로가 큰 경우
            } else if(nowW <= maxW && nowH > maxH) {
                maxH = nowH;
            }
        }
        return maxW * maxH;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60,50},{30,70},{60,30},{80,40}}));
        System.out.println(solution(new int[][]{{10,7},{12,3},{8,15},{14,7},{5,15}}));
        System.out.println(solution(new int[][]{{14,4},{19,6},{6,16},{18,7},{7,11}}));
    }
}
