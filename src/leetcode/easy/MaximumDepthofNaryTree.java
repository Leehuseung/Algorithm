package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 559. Maximum Depth of N-ary Tree
 */
public class MaximumDepthofNaryTree {
    static int answer = 0;
    public static int maxDepth(Node root) {
        if(root.children == null || root.children.size() == 0){
            return answer;
        }
        recursive(root,1);
        return answer;
    }

    private static void recursive(Node root, int i) {
        if(root.children == null || root.children.size() == 0){
            answer = Math.max(answer,i);
            return;
        }

        for (int j = 0; j < root.children.size(); j++) {
            Node node = root.children.get(j);
            recursive(node,i+1);
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    //best
    public static int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        for(Node child: root.children) {
            max = Math.max(max, maxDepth2(child));
        }

        return max + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1,new ArrayList<>());
        Node three = new Node(3, new ArrayList<>());
        Node two = new Node(2, new ArrayList<>());
        Node four = new Node(4, new ArrayList<>());
        root.children.add(three);
        root.children.add(two);
        root.children.add(four);

        maxDepth2(root);


    }
}

