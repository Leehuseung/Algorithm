package backjun.greedy;

import java.util.*;

/**
 * 단어 수학
 */
public class A1339 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.next();
        }
        Arrays.sort(arr, (o1, o2) -> o2.length() - o1.length());
        Map<String, Integer> map = new HashMap<>();
        int val = 9;
        for (int i = 0; i < arr.length; i++) {
            String[] ss = arr[i].split("");
            for (int j = 0; j < ss.length; j++) {
                int index = ss.length - j - 1;
                if(!map.containsKey(ss[j])) {
                    map.put(ss[j], (int)Math.ceil(Math.pow(10, index)));
                } else {
                    map.put(ss[j], map.get(ss[j]) + (int)Math.ceil(Math.pow(10, index)));
                }
            }
        }

        List<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList);
        int answer = 0;
        for (int i = valueList.size() - 1; i >= 0 ; i--) {
            answer += valueList.get(i) * val--;
        }

        System.out.println(answer);
    }
}
