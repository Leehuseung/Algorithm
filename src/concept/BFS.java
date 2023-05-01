package concept;

/**
 * 다음 순서대로 배열을 출력한다.
 *
 * 1
 * 2
 * 3
 * 12
 * 13
 * 2
 * 23
 * 3
 * 123
 */
public class BFS {

    static String[] arr = new String[]{"1","2","3"};
    static boolean[] bools = new boolean[arr.length];

    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < arr.length; j++) {
                bfs(j,arr[j],i);
            }
        }
    }

    private static void bfs(int idx, String s,int len) {
        bools[idx] = true;
        if(s.length() == len){
            //어떤 로직 이 여기들어가야 되고
            //여기서 사용하는 로직의 변수는 모두 static이나 재귀로 들고다녀야하는 당점이 있다..
            System.out.println(s);
        }

        for (int j = idx+1; j < arr.length; j++) {
            if(!bools[j]){
                bfs(j,s+arr[j],len);
            }
        }
        bools[idx] = false;
    }


}

