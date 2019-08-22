package priv.algorithm.coding_interviews;

/**
 * 55.2 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树
 */
public class Question_55_2 {
    public static void main(String[] args) {

    }

    private boolean balanced = true;
    private int isBalancedBinaryTree(TreeNode root) {
        if (root == null || !balanced)
            return 0;

        int leftNodes = this.isBalancedBinaryTree(root.left);
        int rightNodes = this.isBalancedBinaryTree(root.right);
        int depth = 1 + Math.max(leftNodes, rightNodes);

        if (Math.abs(leftNodes - rightNodes) > 1)
            this.balanced = false;

        return depth;
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
