package programmers.lv1;

import java.util.HashMap;
import java.util.Iterator;

public class NotFinishedPlayer {

    public static void main(String[] args) {

//        String[] a = {"leo","kiki","eden"};
//        String[] b = {"eden","kiki"};

//        String[] a = {"mislav","stanko","mislav","ana"};
//        String[] b = {"stanko","ana","mislav"};

        String[] a = {"marina","s", "marina", "filipa","s","cc"};
        String[] b = {"marina", "filipa", "marina", "s","s"};

        System.out.println(" 결과 : "+ solution(a,b));

    }

    public static String solution(String[] participant, String[] completion) {

        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])){
                map.put(participant[i],(Integer)map.get(participant[i])+1);
            } else {
                map.put(participant[i],1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            if(!map.containsKey(completion[i])){
                return completion[i];
            } else if((Integer)map.get(completion[i]) == 1){
                map.remove(completion[i]);
            } else {
                map.put(completion[i],(Integer)map.get(completion[i])-1);
            }
        }

        Iterator itr = map.keySet().iterator();
        while(itr.hasNext()){
            return (String)itr.next();
        }

        return "ss";
    }

//    public static String solution(String[] participant, String[] completion) {
//        String answer = "";
//        a:
//         for(int i = 0 ; i < participant.length; i++){
//            String part = participant[i];
//            boolean a = false;
//            for(int k = 0; k < completion.length; k++){
//                if(completion[k].equals(part)){
//                    a = true;
//                    completion[k] = "";
//                    continue a;
//                }
//            }
//             if(a == false){
//                 return part;
//             }
//         }
//        return answer;
//    }
}
