package programmers.lv1;

public class NotFinishedPlayer {

    public static void main(String[] args) {

        String[] a = {"mislav","stanko", "mislav","ana"};
        String[] b = {"stanko", "ana","mislav","mislav"};

        System.out.println(" 겨로가 : "+ solution(a,b));

    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        a:
         for(int i = 0 ; i < participant.length; i++){
            String part = participant[i];
            boolean a = false;
            for(int k = 0; k < completion.length; k++){
                if(completion[k].equals(part)){
                    a = true;
                    completion[k] = "";
                    continue a;
                }
            }
             if(a == false){
                 return part;
             }
         }
        return answer;
    }
}
