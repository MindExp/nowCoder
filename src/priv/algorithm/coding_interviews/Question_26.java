package priv.algorithm.coding_interviews;

/**
 * 26. 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Question_26 {
    public static void main(String[] args) {

    }

    private boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        boolean isSubTree = false;
        // 前序遍历二叉树
        if (root1.val == root2.val && this.isSubTreeAndSameRootValue(root1, root2)) {
            return true;
        } else
            isSubTree = this.hasSubTree(root1.left, root2) || this.hasSubTree(root1.right, root2);

        return isSubTree;
    }

    private boolean isSubTreeAndSameRootValue(TreeNode root1, TreeNode root2) {
        boolean isSubTree;
        if (root2 == null)
            return true;
        if (root1 == null || root1.val != root2.val)
            return false;

        isSubTree = this.isSubTreeAndSameRootValue(root1.left, root2.left) &&
                this.isSubTreeAndSameRootValue(root1.right, root2.right);

        return isSubTree;
    }

    private boolean hasSubTree_2(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        return this.isSubTreeWithSameRootValue(root1, root2) || this.isSubTreeWithSameRootValue(root1.left, root2) ||
                this.isSubTreeWithSameRootValue(root1.right, root2);
    }

    private boolean isSubTreeWithSameRootValue(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null || root1.val != root2.val)
            return false;

        return this.isSubTreeWithSameRootValue(root1.left, root2.left) && this.isSubTreeWithSameRootValue(root1.right, root2.right);
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
