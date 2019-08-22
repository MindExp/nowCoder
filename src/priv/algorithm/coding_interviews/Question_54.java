package priv.algorithm.coding_interviews;

import java.util.Stack;

/**
 * 54. 二叉查找树的第 K 大个结点
 */
public class Question_54 {
    public static void main(String[] args) {

    }

    private TreeNode kthNode = null;
    private int counter = 0;
    private boolean found = false;

    private TreeNode getKthTreeNode(TreeNode root, int k) {
        this.inOrderSearchV1(root, k);
        return this.kthNode;
    }

    // 递归实现
    private void inOrderSearchV1(TreeNode root, int k) {
        if (root == null || k <= 0 || this.found)
            return;
        this.inOrderSearchV1(root.left, k);
        counter++;
        if (counter == k) {
            this.kthNode = root;
            this.found = true;
        }
        this.inOrderSearchV1(root.right, k);
    }

    // 非递归实现
    private void inOrderSearchV2(TreeNode root, int k) {
        if (root == null || k <= 0)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                this.counter++;
                if (this.counter == k) {
                    this.kthNode = pNode;
                    break;
                }
                pNode = pNode.right;
            }
        }
    }

    private class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
