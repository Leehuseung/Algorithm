package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이진 검색 트리
 */
public class A5639_2 {
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

        root.print();
        System.out.println(root.num);
    }

    static class Node {
        Node left;
        Node right;
        int num;

        public void push(int child) {
            if(this.num < child){
                if(right == null) {
                    this.right = new Node(child);
                } else {
                    this.right.push(child);
                }
            } else {
                if(left == null) {
                    this.left = new Node(child);
                } else {
                    this.left.push(child);
                }
            }
        }
        public Node(int num) {
            this.num = num;
        }

        public void print() {
            if(this.left != null){
                this.left.print();
                System.out.println(this.left.num);
            }
            if(this.right != null) {
                this.right.print();
                System.out.println(this.right.num);
            }
        }
    }
}
