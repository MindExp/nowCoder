package priv.algorithm.coding_interviews;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 32.1 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Question_32_1 {
    public static void main(String[] args) {

    }

    private ArrayList printBinaryTreeByLevelSorting(TreeNode rootNode) {
        ArrayList<Integer> resultList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (rootNode == null)
            return resultList;

        queue.addLast(rootNode);
        while (!queue.isEmpty()) {
            TreeNode pNode = queue.pollFirst();
            resultList.add(pNode.val);
            if (pNode.left != null)
                queue.addLast(pNode.left);
            if (pNode.right != null)
                queue.addLast(pNode.right);
        }

        return resultList;
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
