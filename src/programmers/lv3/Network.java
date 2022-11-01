package programmers.lv3;

import java.util.ArrayList;
import java.util.List;

/**
 * Lv3. 네트워크
 */
public class Network {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < computers.length; i++) {
            Node node = nodes.get(i);
            for (int j = 0; j < computers.length; j++) {
                if(computers[i][j] == 1 && i != j){
                    node.child.add(nodes.get(j));
                }
            }
        }

        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if(!node.v){
                visitNode(node);
                answer++;
            }
        }

        return answer;
    }

    private static void visitNode(Node node) {
        node.v = true;
        for (int i = 0; i < node.child.size(); i++) {
            Node child = node.child.get(i);
            if(!child.v){
                visitNode(child);
            }
        }
    }

    static class Node {
        int num;
        boolean v = false;
        List<Node> child;
        public Node(int num) {
            this.num = num;
            this.child = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(3,new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(solution(3,new int[][]{{1,1,0},{1,1,1},{0,1,1}}));
    }
}
