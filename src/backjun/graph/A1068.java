package backjun.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 트리
 */
public class A1068 {
    static int result;
    static Node[] nodes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        nodes = new Node[N+1];
        for(int i=0;  i < N ; i++) {
            nodes[i] = new Node(i);
        }
        int root = 0;
        for (int i = 0; i < N; i++) {
            int index = sc.nextInt();
            if(index == -1){
                root = i;
                continue;
            }
            nodes[index].addList(nodes[i]);
        }
        int remove = sc.nextInt();
        result = 0;

        dfs(root ,remove);
        dfsCnt(root);

        if(result == 0 && nodes[root].list.size() == 0) result = 1;
        if(root == remove) result = 0;
        System.out.println(result);
    }

    private static void dfsCnt(int root) {
        List<Node> list = nodes[root].list;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).list.isEmpty()){
                result++;
            } else {
                dfsCnt(list.get(i).num);
            }
        }
    }

    private static void dfs(int root, int remove) {
        List<Node> list = nodes[root].list;
        int m = -1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).num == remove){
                m = i;
                break;
            }
            dfs(list.get(i).num, remove);
        }
        if(m != -1) {
            list.remove(m);
        }
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
