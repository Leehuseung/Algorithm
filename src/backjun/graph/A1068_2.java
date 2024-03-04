package backjun.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 트리
 */
public class A1068_2 {
    static int result;
    static Node[] nodes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        nodes = new Node[N+1];
        for(int i=0;  i < N ; i++) {
            nodes[i] = new Node(i);
        }
        int root = -2;
        for (int i = 0; i < N; i++) {
            int index = sc.nextInt();
            if(index == -1) {
                root = i;
                continue;
            };
            Node node = nodes[index];
            node.addList(nodes[i]);
        }
        int removeIndex = sc.nextInt();

        nodes[removeIndex] = null;

        dfs(root);

        System.out.println(result);
    }

    private static void dfs(int i) {
        if(nodes[i] == null) return;

        boolean is = true;
        List<Node> list = nodes[i].list;
        if(!list.isEmpty()){
            for (Node node : list) {
                if (nodes[node.num] != null) {
                    is = false;
                    dfs(node.num);
                }
            }
        }

        if(is) result++;
    }

    static class Node {
        int num;
        List<Node> list;
        void addList(Node node){
            list.add(node);
        }
        public Node(int num) {
            this.num = num;
            this.list = new ArrayList<>();
        }
    }
}
