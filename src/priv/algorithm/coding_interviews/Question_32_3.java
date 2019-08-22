package priv.algorithm.coding_interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 32.3 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Question_32_3 {
    public static void main(String[] args) {

    }

    private ArrayList<ArrayList<Integer>> printBinaryTreeByZOrder(TreeNode rootNode) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> levelList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;

        if (rootNode == null)
            return resultList;

        queue.addLast(rootNode);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            while (queueSize-- > 0) {
                TreeNode pNode = queue.pollFirst();
                levelList.add(pNode.val);

                if (pNode.left != null)
                    queue.addLast(pNode.left);
                if (pNode.right != null)
                    queue.addLast(pNode.right);

            }

            if (!leftToRight)
                Collections.reverse(levelList);
            resultList.add(levelList);
            levelList.clear();
            leftToRight = !leftToRight;
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
