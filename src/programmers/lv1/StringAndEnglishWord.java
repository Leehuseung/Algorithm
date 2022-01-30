package programmers.lv1;

public class StringAndEnglishWord {

    public static int solution(String s) {
        return Integer.parseInt(stringToNum(s));
    }

    public static String stringToNum(String param){
        if(param.contains("one")){
            param = param.replaceAll("one","1");
        };
        if(param.contains("zero")){
            param = param.replaceAll("zero","0");
        };
        if(param.contains("two")){
            param = param.replaceAll("two","2");
        };
        if(param.contains("three")){
            param = param.replaceAll("three","3");
        };
        if(param.contains("four")){
            param = param.replaceAll("four","4");
        };
        if(param.contains("five")){
            param = param.replaceAll("five","5");
        };
        if(param.contains("six")){
            param = param.replaceAll("six","6");
        };
        if(param.contains("seven")){
            param = param.replaceAll("seven","7");
        };
        if(param.contains("eight")){
            param = param.replaceAll("eight","8");
        };
        if(param.contains("nine")){
            param = param.replaceAll("nine","9");
        };
        return param;
    }

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }
}
