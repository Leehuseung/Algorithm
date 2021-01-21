package programmers.lv1;

public class KeyPad {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},"left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},"right"));
    }
    public static String solution(int[] numbers, String hand) {
        String answer = "";

        int[][] numPosition = new int[][]{{0,0},{1,0},{2,0},{0,1},{1,1},{2,1},{0,2},{1,2},{2,2},{1,3}};
        
        int[] leftPosition = new int[]{0,3};
        int[] rightPosition = new int[]{2,3};
        //LRLLLRLLLRL
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            String addString = "";
            switch(num){
                case 1 : case 4 : case 7 :
                    addString = "L";
                    break;
                case 3 : case 6 : case 9 :
                    addString = "R";
                    break;
                case 2 : case 5: case 8: case 0:
                    if(num == 0){
                        num = 10;
                    }
                    int leftLength = Math.abs(leftPosition[0] - numPosition[num-1][0]) + Math.abs(leftPosition[1] - numPosition[num-1][1]);
                    int rightLength = Math.abs(rightPosition[0] - numPosition[num-1][0]) + Math.abs(rightPosition[1] - numPosition[num-1][1]);

                    if(rightLength > leftLength){
                        addString = "L";
                    }else if(rightLength < leftLength){
                        addString = "R";
                    } else {
                        if(hand.equals("right")){
                            addString = "R";
                        } else {
                            addString = "L";
                        }
                    }
                    break;
            }
            if(addString.equals("R")){
                rightPosition = numPosition[num-1];
            } else {
                leftPosition = numPosition[num-1];
            }
            answer += addString;
        }

        return answer;
    }
}
