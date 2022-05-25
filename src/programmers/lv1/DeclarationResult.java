package programmers.lv1;

import java.util.*;

/*
 * Lv1. 신고결과 받기
 */
public class DeclarationResult {

     static int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];
         HashMap<String, User> map = new HashMap<>();

        //User에 대한 데이터를 셋팅한다.
         for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new User(id_list[i]));
         }

         //신고할 사람에 대한 데이터를 셋팅한다.
         for (int i = 0; i < report.length; i++) {
             String[] arr = report[i].split(" ");

             String userName = arr[0];
             String badUserName = arr[1];

             List<String> declareList = map.get(userName).getDeclareList();
             if(!declareList.contains(badUserName)){
                 User badUserObj = map.get(badUserName);
                 //신고횟수를 1 올린다.
                 badUserObj.setK(badUserObj.getK()+1);
                 //신고한 리스트에 넣는다.
                 declareList.add(badUserName);
             }
         }

         for (int i = 0; i < id_list.length; i++) {
             List<String> declareList = map.get(id_list[i]).getDeclareList();

             //이메일 받을 횟수
             int num = 0;

             //신고대상자면 num을 올린다.
             for (int j = 0; j < declareList.size(); j++) {
                 //신고된 사람인지?
                 if(map.get(declareList.get(j)).isDeclare(k)){
                     num++;
                 }
             }
             answer[i] = num;
         }

        return answer;
    }



    static class User {

         User(String name){
             this.name = name;
         }

         String name; //사용자 이름
         List<String> declareList = new ArrayList<String>(); // 신고할 사람
         int k = 0; // 신고당한 횟수

        /*
        이메일 발송 대상인가?
         */
        public boolean isDeclare(int declareNum){
            if(k >= declareNum){
                return true;
            }
            return false;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getDeclareList() {
            return declareList;
        }

        public void setDeclareList(List<String> declareList) {
            this.declareList = declareList;
        }

        public int getK() {
            return k;
        }

        public void setK(int k) {
            this.k = k;
        }
    }



    public static void main(String[] args) {

        String id_list[] = new String[] {"muzi", "frodo", "apeach", "neo"};
        String report[] = new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int result[] = solution(id_list,report,2);
        System.out.println(Arrays.toString(result));

    }
}

