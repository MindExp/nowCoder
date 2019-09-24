package priv.algorithm.leetcode;

/**
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class Question_124 {
    public static void main(String[] args) {

    }

    private int maxPathSum = Integer.MIN_VALUE;

    /**
     * 基于递归求解最大路径，时间复杂度 O(N)，空间复杂度 O(log(N))
     * @param root
     * @return
     */
    public int maxGain(TreeNode root) {
        if (root == null)
            return 0;

        int leftGain = Math.max(this.maxGain(root.left), 0);
        int rightGain = Math.max(this.maxGain(root.right), 0);
        int currentNodeGain = root.val + leftGain + rightGain;

        this.maxPathSum = Math.max(maxPathSum, currentNodeGain);
        // 最终仅能选择通过该结点的一条路径
        return root.val + Math.max(leftGain, rightGain);
    }

    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
