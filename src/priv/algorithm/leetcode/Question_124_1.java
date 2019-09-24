package priv.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 给定一个非空二叉树，返回其最大路径和。本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class Question_124_1 {
    public static void main(String[] args) {

}

    private ArrayList<ArrayList<Integer>> pathsList = new ArrayList<>();

    /**
     * 基于非递归后续遍历获取根节点到叶节点的路径
     * @param root
     */
    public void getLeafNodesPath(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisitedNode = null;
        TreeNode pNode = root;

        while (pNode != null) {
            stack.push(pNode);
            pNode = pNode.left;
        }
        while (!stack.isEmpty()) {
            pNode = stack.pop();
            if (pNode.right == null || pNode.right == lastVisitedNode) {
                if (pNode.left == null && pNode.right == null) {
                    stack.push(pNode);
                    ArrayList<Integer> path = this.addLeafNodePath(stack);
                    this.pathsList.add(path);
                    stack.pop();
                }
                lastVisitedNode = pNode;
            } else {
                stack.push(pNode);
                pNode = pNode.right;
                while (pNode != null) {
                    stack.push(pNode);
                    pNode = pNode.left;
                }
            }
        }
    }

    private ArrayList<Integer> addLeafNodePath(Stack<TreeNode> stack){
        ArrayList<Integer> path = new ArrayList<>();
        for (TreeNode node : stack) {
            path.add(node.val);
        }
        return path;
    }

    private int getMaxSubPath() {
        int maxSubPath = Integer.MIN_VALUE;
        for (int index = 0; index < this.pathsList.size(); index++) {
            int currentMaxSubPath = this.getMaxSubPathByDP(this.pathsList.get(index));
            maxSubPath = Math.max(maxSubPath, currentMaxSubPath);
        }
        return maxSubPath;
    }

    /**
     * 动态规划求解：dp[i] = Math.max(dp[i-1] + array[i], array[i])
     * @param arrayList
     * @return
     */
    private int getMaxSubPathByDP(ArrayList<Integer> arrayList){
        int currentMax = arrayList.get(0);
        int finalMax = Integer.MIN_VALUE;
        for (int index = 1; index < arrayList.size(); index++) {
            currentMax = Math.max(currentMax + arrayList.get(index), arrayList.get(index));
            finalMax = Math.max(finalMax, currentMax);
        }
        return finalMax;
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
