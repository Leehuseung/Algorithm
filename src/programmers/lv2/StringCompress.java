package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Lv2. 문자열 압축
 */
public class StringCompress {

    public static int solution(String s) {
        int answer = 1000;
        if(s.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= s.length()/2; i++) {
            //i번째로 압축하는데, 1 ~ s.length/2 의 길이만큼 압축할 수 있다. (홀수,짝수 동일)
            String[] arr = new String[s.length()/i];
            String newString = "";

            for (int j = 0; j < s.length()/i; j++) {
//                System.out.println(i+ "로 압축을 진행합니다. 진행하려고 하는 문자열의 index 는 : " + j * i + "문자는 "+ s.substring(j*i,j*i+i));
                arr[j] = s.substring(j*i,j*i+i);
            }

            //중복 체크 로직 생성
            int dupleNumber = 1;
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j].equals(arr[j+1])){
                    dupleNumber++;
                } else {
                    if(dupleNumber == 1){
                        newString += arr[j];
                    } else {
                        newString += dupleNumber + arr[j];
                    }
                    dupleNumber=1;
                }
            }

            if(dupleNumber != 1){
                newString += dupleNumber + arr[arr.length-1];
            } else {
                newString += arr[arr.length-1];
            }

            newString += s.substring(s.length()-s.length()%i,s.length());

//            System.out.println(Arrays.toString(arr));
//            System.out.println("파싱해서 만들어진 압축 문자열은 : "+newString);
//            System.out.println("남는 문자는 : " + lastString);
            if(answer > newString.length()){
                answer = newString.length();
            }
        }
        return answer;
    }

    public static void main(String[] args) {


        System.out.println(solution("a")); //1
        System.out.println(solution("aabbaccc"));  //7
        System.out.println(solution("ababcdcdababcdcd"));  //8
        System.out.println(solution("abcabcdede")); //8
        System.out.println(solution("abcabcabcabcdededededede"));  //14
        System.out.println(solution("xababcdcdababcdcd")); //17



//        System.out.println(solution("aaaa"));

//        System.out.println(solution("ababdab"));

//        System.out.println(solution("aabb"));

//        System.out.println("aabb".substring(0,2));

//        System.out.println(solution("abcdabcdabcd"));

//        System.out.println(solution("ababab"));
//        System.out.println(solution("aaabbb")); // 4

//        System.out.println(solution("aabbacccv"));

//        String a = "abcdefg";

//        System.out.println();

    }
}


/*
    public static int solution(String s) {
        int answer = 1000;

        for (int i = 1; i <= s.length()/2; i++) {
            String[] stringArr = null;
            if(i == 1){
                stringArr = new String[s.length()/i];
            } else if(i % 2 == 0){
                int len = s.length()/i;
                stringArr = new String[len];
            } else {
                int len = s.length()/i+1;
                stringArr = new String[len];
            }

            for (int j = 0; j < stringArr.length; j++) {
                try{
                    stringArr[j] = s.substring(j * i,j * i + i);
                }catch (Exception e){
                    stringArr[j] = s.substring(j * i,s.length());
                }
            }

            int duplicateNumber = 0;
            String newString = "";
            for (int j = 0; j < stringArr.length-1; j++) {

                if(stringArr[j].equals(stringArr[j+1])){
                    duplicateNumber++;
                } else {
                    if(duplicateNumber != 1){
                        newString += stringArr[j];
                        duplicateNumber = 0;
                    } else {
                        newString += (1 + duplicateNumber) + stringArr[j];
                        duplicateNumber = 0;
                    }

                }

            }

            if(duplicateNumber != 0){
                newString += (1 + duplicateNumber) + stringArr[stringArr.length-1];
            } else {
                newString += stringArr[stringArr.length-1];
            }


            int count = newString.length();

            if(s.length() == 1){
                return 1;
            }

            if(answer > count) {
                answer = count;
            }
        }
        return answer;
    }

 */