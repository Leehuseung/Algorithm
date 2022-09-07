package programmers.lv2.solution;

import java.util.LinkedList;

/**
 * Lv2.수식 최대화
 *
 * 22.06.24
 *
 * 22.07.01 횐트
 *
 * 22.07.03 성공
 */
public class MathematicalExpression {
    public static long solution(String expression) {
        LinkedList<Long> numList = new LinkedList<>();
        LinkedList<Character> calList = new LinkedList<>();
        long answer = 0;

        char[][] arr = new char[][]{{'*','+','-'},{'*','-','+'},{'+','-','*'},{'+','*','-'},{'-','+','*'},{'-','*','+'}};

        char[] chars = expression.toCharArray();
        String num = "";
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '*' || chars[i] == '-' || chars[i] == '+'){
                calList.add(chars[i]);
                if(!num.equals("")){
                    numList.add(Long.parseLong(num));
                    num = "";
                }
            } else {
                num += chars[i] + "";
            }
        }

        if(!num.equals("")){
            numList.add(Long.parseLong(num));
        }

        for (int i = 0; i < arr.length; i++) {
            LinkedList<Long> nums_copy = new LinkedList<>(numList);
            LinkedList<Character> cals_copy = new LinkedList<>(calList);
            for (int j = 0; j < arr[i].length; j++) {
                calcGo(nums_copy,cals_copy,arr[i][j]);
            }
            Long newcalc = Math.abs(nums_copy.get(0));
            answer = Math.max(answer,newcalc);
        }

        return answer;
    }

    private static void calcGo(LinkedList<Long> numList, LinkedList<Character> calList, char c) {
        for (int i = 0; i < calList.size(); i++) {
            Long calNum = 0L;
            if(calList.get(i) == c && c == '-'){
                calNum = numList.get(i) - numList.get(i+1);
            } else if(calList.get(i) == c && c == '*'){
                calNum = numList.get(i) * numList.get(i+1);
            } else if(calList.get(i) == c && c == '+'){
                calNum = numList.get(i) + numList.get(i+1);
            }
            if(calList.get(i) == c){
                numList.remove(i);
                numList.remove(i);
                calList.remove(i);
                numList.add(i,calNum);
                i--;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20")); //60420
        System.out.println(solution("50*6-3*2")); //300
        System.out.println(solution("200-300-500-600*40+500+500")); //1248000


    }
}
