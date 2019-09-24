package priv.algorithm.leetcode;

/**
 * 1080. 根到叶路径上的不足节点
 * 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。
 * 请你删除所有不足节点，并返回生成的二叉树的根。
 */
public class Question_1080 {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度 O(N)，空间复杂度 O(1)
     * 基于后续遍历确认当前结点是否需要被删除
     * @param root
     * @return
     */
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean rootDeleted = this.dfs(root, 0, limit);
        if (rootDeleted)
            return null;
        return root;
    }

    /**
     * 基于深度优先遍历确认树中每一个结点是否需要被删除
     * @param root
     * @param currentGain
     * @param limit
     * @return 当前 root 结点是否应该被删除
     */
    private boolean dfs(TreeNode root, int currentGain, int limit) {
        if (root.left == null && root.right == null) {
            return currentGain + root.val < limit;
        }

        boolean leftDeleted = true, rightDeleted = true;
        // 确认左右子树是否需要被删除
        if (root.left != null)
            leftDeleted = this.dfs(root.left, currentGain + root.val,limit);
        if (root.right != null)
            rightDeleted = this.dfs(root.right, currentGain + root.val, limit);
        // 是否删除左右子树
        if (leftDeleted) root.left = null;
        if (rightDeleted) root.right = null;
        // 是否删除当前结点
        return leftDeleted && rightDeleted;
    }

    private class TreeNode {
        private int val;
        private TreeNode left = null;
        private TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
