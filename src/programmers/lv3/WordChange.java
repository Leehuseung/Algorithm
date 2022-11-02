package programmers.lv3;

/**
 * Lv3. 단어 변환
 */
public class WordChange {
    static boolean[] booleans;
    public static int solution(String begin, String target, String[] words) {
        booleans = new boolean[words.length];
        int answer = recursive(begin,target,words,0);
        return answer;
    }

    public static int recursive(String nowString,String target, String[] words,int depth){
        int an = 0;
        if(nowString.equals(target)){
            return depth;
        }

        for (int i = 0; i < words.length; i++) {
            if(!booleans[i]){
                if(compareOne(nowString,words[i])){
                    booleans[i] = true;
                    recursive(words[i],target,words,depth+1);
                    booleans[i] = false;
                };
            }
        }
        return an;
    }

    private static boolean compareOne(String nowString, String word) {
        int num = 0;
        for (int i = 0; i < nowString.length(); i++) {
            if(nowString.charAt(i) != word.charAt(i)){
                num++;
            }
        }
        return num == 1 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(solution("hit","cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"})); // 4
        System.out.println(solution("hit","cog", new String[]{"hot", "dot", "dog", "lot", "log"})); // 0

    }
}
