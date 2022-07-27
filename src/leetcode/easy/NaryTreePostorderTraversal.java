package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal
 */
public class NaryTreePostorderTraversal {
    public static List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        recur(root,list);
        return list;
    }

    private static void recur(Node root, List<Integer> list) {
        if(root == null){
            return;
        }
        List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            recur(node,list);
        }
        list.add(root.val);
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
    public static void main(String[] args) {

    }
}
