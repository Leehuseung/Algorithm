package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * Lv2. 전력망을 둘로 나누기
 */
public class PowerGrid {
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Node[] nodes = new Node[n];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i+1);
        }
        for (int i = 0; i < wires.length; i++) {
            int[] arr = wires[i];
            int v1 = arr[0]-1;
            int v2 = arr[1]-1;
            Node v1Node = nodes[v1];
            Node v2Node = nodes[v2];
            v1Node.children.add(v2Node);
            v2Node.children.add(v1Node);
        }

        for (int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            List<Node>   children = node.children;
            for (int j = 0; j < children.size(); j++) {
                Node child = children.get(j);
                answer = Math.min(answer, Math.abs(dfs(node,child) - dfs(child,node)));
            }
        }

        return answer;
    }

    private static int dfs(Node node, Node exceptNode) {
        int cnt = 0;
        List<Node> list = node.children;
        for (int i = 0; i < list.size(); i++) {
            Node child = list.get(i);
            if(exceptNode.num != child.num){
                cnt++;
                cnt += dfs(child,node) + 1;
            }
        }
        return cnt;
    }


    static class Node {
        List<Node> children = new ArrayList<>();
        int num;
        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][] { {1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}}));
        System.out.println(solution(9, new int[][] { {1,2},{2,3},{3,4}}));
        System.out.println(solution(7, new int[][] {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));

    }
}
