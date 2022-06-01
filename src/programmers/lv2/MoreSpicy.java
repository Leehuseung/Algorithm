package programmers.lv2;

import java.util.*;

/*
 * Lv2. 더맵게
 */
public class MoreSpicy {

    public static int solution(int[] scoville, int K) {
        FoodList foodList = new FoodList(K);

        //Foodlist를 만든다.
        for (int scovileNum : scoville) {
            foodList.add(scovileNum);
        }

        while(!foodList.isComplete()){
            foodList.proceedScovile();
        }

        return foodList.getCalScovile();
    }

    static class FoodList {
        Queue<Integer> list;
        int completeScovileNum; //모든 음식의 scovile 목표

        int calScovile; //Scovile한 횟수

        FoodList(int completeScovileNum) {
            this.list = new PriorityQueue<>();
            this.completeScovileNum = completeScovileNum;
            this.calScovile = 0;
        }

        public void add(int foodScovileNum) {
            list.add(foodScovileNum);
        }

        public boolean isComplete(){
            if(list.size() == 1){
                return true;
            }
            if(list.peek() >= completeScovileNum){
                return true;
            } else {
                return false;
            }

        }

        public int getCalScovile () {
            if(list.size() == 1 && list.peek() < completeScovileNum){
                return -1;
            }
            return calScovile;
        }

        public void proceedScovile() {
            calScovile++;
            int scovile = list.poll() + (list.poll() * 2);
            //scovile 구해서 넣는다.
            list.add(scovile);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7)); //2
        System.out.println(solution(new int[]{1, 1, 1}, 10)); //-1
        System.out.println(solution(new int[]{1, 2, 3}, 11)); //2
    }
}
