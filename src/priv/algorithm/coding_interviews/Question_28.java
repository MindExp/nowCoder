package priv.algorithm.coding_interviews;

/**
 * 28 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Question_28 {
    public static void main(String[] args) {

    }

    private boolean isSymmetrical(TreeNode root) {
        if (root == null)
            return true;

        return this.isSysmmetrical(root.left, root.right);
    }

    private boolean isSysmmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;

        return this.isSysmmetrical(root1.left, root2.right) && this.isSysmmetrical(root1.right, root2.left);
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
