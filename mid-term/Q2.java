import java.util.ArrayList;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[14];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i + 1);
        }
        for (int i = 0; i < nodes.length; i++) {
            if (i * 2 + 1 < nodes.length) {
                nodes[i].left = nodes[i * 2 + 1];
            }
            if (i * 2 + 2 < nodes.length) {
                nodes[i].right = nodes[i * 2 + 2];
            }
        }
        nodes[5].left = null;
        new Solution().printPerimeter(nodes[0]);
        nodes[3].left = null;
        new Solution().printPerimeter(nodes[0]);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /**
     * the space complexity is O(n)
     * the time complexity is O(n)
     *
     * @param root the root node of tree
     */
    public void printPerimeter(TreeNode root) {
        ArrayList<Integer> orderList = new ArrayList<>();
        getRightNode(root, orderList);
        getBottomNode(root, orderList);
        getLeftNode(root, orderList);
        System.out.println(orderList);
    }

    /**
     * the time complexity is O(|height|)
     *
     * @param root the root node of tree
     */
    private void getRightNode(TreeNode root, ArrayList<Integer> orderList) {
        TreeNode node = root;
        while (node != null && (node.left != null || node.right != null)) {
            orderList.add(node.val);
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }

    /**
     * the space complexity is O(n)
     * the time complexity is O(|height|)
     *
     * @param root the root node of tree
     */
    private void getLeftNode(TreeNode root, ArrayList<Integer> orderList) {
        TreeNode node = root;
        Stack<Integer> stack = new Stack<>();
        while (node != null && (node.left != null || node.right != null)) {
            if (node != root) {
                stack.push(node.val);
            }
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        while (!stack.empty()) {
            orderList.add(stack.pop());
        }
    }

    /**
     * the time complexity is O(n)
     *
     * @param root the root node of tree
     */
    private void getBottomNode(TreeNode root, ArrayList<Integer> orderList) {
        if (root != null) {
            getBottomNode(root.right, orderList);
            if (root.left == null && root.right == null) {
                orderList.add(root.val);
            }
            getBottomNode(root.left, orderList);
        }
    }
}