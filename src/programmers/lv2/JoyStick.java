package programmers.lv2;

/**
 * Lv2. 조이스틱
 */
public class JoyStick {

    public static int solution(String name) {
        int answer = 0;
        char[] problem_chars = name.toCharArray();
        boolean[] bool = new boolean[name.length()];

        //각 문자마다 위아래로 가는 경우의 수를 구한다.
        for (int i = 0; i < problem_chars.length; i++) {
            answer += getTopBottomCnt(problem_chars[i]);
        }

        //bools 배열을 만든다. A는 True, A가 아니면 False
        for (int i = 0; i < problem_chars.length; i++) {
            bool[i] = (problem_chars[i] == 'A' ? true : false);
        }

        //좌우로 가는 방법중 가장 작은것을 더한다.
        answer += recur(bool,0,0);

        return answer;
    }


    private static int recur(boolean[] bools,int index,int cnt) {
        bools[index] = true;
        if(allTrue(bools)){
            bools[index] = false;
            return cnt;
        }

        int right = index;
        int rightCnt = cnt;

        while(bools[right]){
            rightCnt++;
            right++;
            if(right > bools.length-1){
                right = 0;
            }
        }

        int rightResult = recur(bools,right,rightCnt);

        int left = index;
        int leftCnt = cnt;

        while(bools[left]){
            leftCnt++;
            left--;
            if(left < 0){
                left = bools.length-1;
            }
        }

        int leftResult = recur(bools,left,leftCnt);

        bools[index] = false;

        return rightResult < leftResult ? rightResult : leftResult;
    }

    public static int getTopBottomCnt (char probelm) {
        int topCnt = probelm - 'A';
        int bottomCnt = 'Z' - probelm + 1;
        return topCnt > bottomCnt ? bottomCnt : topCnt;
    }

    public static boolean allTrue(boolean[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("JAZ")); // 11
        System.out.println(solution("JEROEN"));  //56
        System.out.println(solution("JAN"));     //23
        System.out.println(solution("BABAB"));     //6
        System.out.println(solution("BBBBAAAABA"));   //12
        System.out.println(solution("ABAAABB"));   //7






//        boolean[] bools  = new boolean[]{true,false,true,true,false};
//
//        int cnt = recur(bools,0,0);
//        System.out.println("cnt : " + cnt);
//
//        boolean[] bools2  = new boolean[]{true,false,true,true,true,false,false};
//
//        int cnt2 = recur(bools2,0,0);
//        System.out.println("cnt2 : " + cnt2);
//

    }


}




















//        int index = 0;
//        default_chars[index] = problem_chars[index];
//        if(String.valueOf(default_chars).equals(name)){
//            return answer;
//        }

//        while(!String.valueOf(default_chars).equals(name)){

//            int[] arr = getLeftRightCnt(name, index);
//            answer += arr[1];
//            index = arr[0];

//            answer += getTopBottomCnt(problem_chars[index]);
//            default_chars[index] = problem_chars[index];
//            if(String.valueOf(default_chars).equals(name)){
//                return answer;
//            }

//왼쪽으로 갈지, 오른쪽으로 갈지 정한다.
//            int left = index + (index == 0 ? problem_chars.length-1 : -1);
//            int leftCnt = 1;
//
//            while(true){
//                if(left < 0){
//                    left = problem_chars.length-1;
//                }
//                if(default_chars[left] != problem_chars[left] && problem_chars[left] != 'A'){
//                    break;
//                }
//                left--;
//                leftCnt++;
//            }
//
//            int right = index + (index == problem_chars.length-1 ? -index : 1);
//            int rightCnt = 1;
//
//            while(true){
//                if(right == problem_chars.length){
//                    right = 0;
//                }
//                if(default_chars[right] != problem_chars[right] && problem_chars[right] != 'A'){
//                    break;
//                }
//                right++;
//                rightCnt++;
//            }
//
//            if(leftCnt > rightCnt){
//                index = right;
//                answer += rightCnt;
//            } else {
//                index = left;
//                answer += leftCnt;
//            }
//            answer += getTopBottomCnt(problem_chars[index]);
//            default_chars[index] = problem_chars[index];
//            if(String.valueOf(default_chars).equals(name)){
//                return answer;
//            }
//        }
//        return answer;