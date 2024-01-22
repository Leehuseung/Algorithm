package backjun.graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 연결 요소의 개수
 */
public class A111724 {
    static Node[] nodes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        nodes = new Node[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i <= M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            nodes[s].add(nodes[e]);
            nodes[e].add(nodes[s]);
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            Node node = nodes[i];
            if(!node.visit){
                result++;
                node.visit();
            }
        }
        System.out.println(result);
    }
    static class Node{
        boolean visit;
        int cnt;
        ArrayList<Node> list;

        public Node(int cnt) {
            this.cnt = cnt;
            list = new ArrayList<>();
        }
        public void add(Node node) {
            list.add(node);
        }
        public void visit(){
            if(this.visit) return;
            this.visit = true;
            for (Node node : list) node.visit();
        }
    }
}
