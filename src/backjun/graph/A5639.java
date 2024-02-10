package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이진 검색 트리
 */
public class A5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.isEmpty()) break;
            int i = Integer.parseInt(input);
            root.push(i); //전위순회
        }
        root.print(); //루트.프린트(후위순회)
        System.out.println(root.num);
    }

    static class Node {
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
        }

        void push(int pushNum){
            Node node = this;
            while(true) {
                if(node.num > pushNum) {
                    if(node.left == null){
                        node.left = new Node(pushNum);
                        break;
                    } else {
                        node = node.left;
                    }
                } else {
                    if(node.right == null){
                        node.right = new Node(pushNum);
                        break;
                    } else {
                        node = node.right;
                    }
                }
            }
        }
        void print() {
            Node node = this;
            if(node.left != null){
                node.left.print();
                System.out.println(node.left.num);
            }
            if(node.right != null){
                node.right.print();
                System.out.println(node.right.num);
            }
        }
    }
}
