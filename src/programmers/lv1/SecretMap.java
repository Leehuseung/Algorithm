package programmers.lv1;

import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        solution(5,new int[]{9,20,28,18,11},new int[]{30,1,21,17,28});
    }
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        int[][] answerArr = new int[n][n];

        getAnserArr(arr1,answerArr,n);
        getAnserArr(arr2,answerArr,n);

        for (int i = 0; i < answerArr.length; i++) {
            String shap = "";
            for (int j = 0; j < answerArr[i].length; j++) {
                if(answerArr[i][j] == 1){
                   shap += "#";
                } else {
                    shap += " ";
                }
            }
            answer[i] = shap;
        }

        return answer;
    }

    private static int[][] getAnserArr(int[] arr1, int[][] answerArr, int n) {

        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i];
            String binary = getBinaryNum(num,n);
            String[] binaryArr = binary.split("");
            for (int j = 0; j < binaryArr.length; j++) {
                if(Integer.parseInt(binaryArr[j]) == 1){
                    answerArr[i][j] = 1;
                }
            }
        }
        return answerArr;
    }

    public static String getBinaryNum (int num,int length){
        String binary = Integer.toBinaryString(num);
        if(binary.length() < length){
            int k = length - binary.length();
            for (int i = 0; i < k ; i++) {
                binary = "0" + binary;
            }
        }
        return binary;
    }
}
