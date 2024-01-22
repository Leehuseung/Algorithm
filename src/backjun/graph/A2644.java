package backjun.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 촌수계산
 */
public class A2644 {
    static boolean[] visit;
    static Node[] nodes;
    static int result = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        visit = new boolean[n+1];
        nodes = new Node[n+1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            Node parentNode = nodes[sc.nextInt()];
            Node childNode = nodes[sc.nextInt()];
            childNode.parent = parentNode;
            parentNode.addChild(childNode);
        }

        dfs(start,end,0);

        System.out.println(result);
    }

    private static void dfs(int start, int end, int i) {
        if(visit[start]) return;
        visit[start] = true;
        if(end == start){
            result = i;
            return;
        }
        i++;
        Node node = nodes[start];
        if(node.parent != null) dfs(node.parent.num, end, i);
        for (int j = 0; j < node.children.size(); j++) {
            Node child = node.children.get(j);
            dfs(child.num, end, i);
        }
    }

    static class Node {
        int num;
        Node parent;
        List<Node> children;
        Node(int num) {
            this.children = new ArrayList<>();
            this.num = num;
        }
        void addChild(Node node) {
            children.add(node);
        }
    }
}
