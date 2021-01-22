package programmers.lv1;

public class ThreeNumber {
    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));
    }
    public static double solution(int n) {
        int answer = 0;
        String num2 = "";

        num2 = makeThree(n,num2);

        return makeTen(num2);
    }

    private static double makeTen(String num2) {
        String[] arr = num2.split("");
        double returnNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("0")){
                continue;
            }
            returnNum += (Double.parseDouble(arr[i]) * Math.pow(3,i));
        }
        return returnNum;
    }

    public static String makeThree(int num,String num2){
        int value = num / 3;
        int b = num % 3;

        num2 = b + "" + num2;

        if(value == 0){
            System.out.println(num2);
            return num2;
        }
        return makeThree(value,num2);
    }
}

