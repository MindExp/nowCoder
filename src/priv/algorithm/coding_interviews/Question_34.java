package priv.algorithm.coding_interviews;

import java.util.ArrayList;

/**
 * 34. 二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Question_34 {
    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {

    }

    private ArrayList<ArrayList<Integer>> findPath(TreeNode rootNode, int target) {
        ArrayList<Integer> trackingPathList = new ArrayList<>();

        // 回溯法寻找路径
        this.findPathByBackTracking(rootNode, target, trackingPathList);

        return this.resultList;
    }

    private void findPathByBackTracking(TreeNode rootNode, int target, ArrayList<Integer> trackingPathList) {
        if (rootNode == null)
            return ;

        trackingPathList.add(rootNode.val);
        target -= rootNode.val;

        if (target == 0 && rootNode.left == null && rootNode.right == null)
            this.resultList.add(new ArrayList<>(trackingPathList));
        else {
            this.findPathByBackTracking(rootNode.left, target, trackingPathList);
            this.findPathByBackTracking(rootNode.right, target, trackingPathList);
        }
        // 回溯
        trackingPathList.remove(trackingPathList.size() - 1);
    }

    private class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
