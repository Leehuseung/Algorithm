package programmers.lv2;
/**
 * Lv2. 스킬트리
 */
public class SkillTree {

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] arr = new int[skill.length()];
        String[] strArr = skill.split("");

        for (int i = 0; i < skill_trees.length; i++) {
            boolean confirm = true;
            String now_skill = skill_trees[i];
            //int 배열을 만든다
            for (int j = 0; j < arr.length; j++) {
                arr[j] = now_skill.indexOf(strArr[j]);
            }

            for (int j = 0; j < arr.length-1; j++) {
                //i는 i+1보다 커야한다. -1 은 예외.
                if(!(arr[j] < (arr[j+1]) || arr[j+1] == -1)){
                    confirm = false;
                }
                //-1뒤에 양수가 나올 수 없다.
                if(arr[j] == -1 && arr[j+1] > -1){
                    confirm = false;
                }
            }
            //true면 answer을 올린다.
            if(confirm) answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"})); //2
    }
}
