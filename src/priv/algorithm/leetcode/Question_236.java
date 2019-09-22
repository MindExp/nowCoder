package priv.algorithm.leetcode;

/**
 *
 */
public class Question_236 {
    public static void main(String[] args) {

    }

    private TreeNode closestAncesterNode = null;

    /**
     * 查找最近公共祖先结点
     * @param root
     * @param pNode
     * @param qNode
     * @return
     */
    private TreeNode getClosestAncesterNode(TreeNode root, TreeNode pNode, TreeNode qNode) {
        this.solution(root, pNode, qNode);

        return this.closestAncesterNode;
    }

    private boolean solution(TreeNode currentNode, TreeNode pNode, TreeNode qNode) {
        if (currentNode == null)
            return false;
        // 已找到最近公共祖先，提前终止递归查找
        if (this.closestAncesterNode != null)
            return false;

        int foundInCurrent = (currentNode == pNode || currentNode == qNode) ? 1 : 0;
        int foundInLeft = this.solution(currentNode.left, pNode, qNode) ? 1 : 0;
        int foundInRight = this.solution(currentNode.right, pNode, qNode) ? 1 : 0;

        if (foundInCurrent + foundInLeft + foundInRight == 2)
            this.closestAncesterNode = currentNode;

        return (foundInCurrent + foundInLeft + foundInRight) > 0;
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
