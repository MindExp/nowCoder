package priv.algorithm.coding_interviews;

/**
 * 55.1 二叉树的深度
 */
public class Question_55_1 {
    public static void main(String[] args) {

    }

    private int getTreeDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(this.getTreeDepth(root.left), this.getTreeDepth(root.right));
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
