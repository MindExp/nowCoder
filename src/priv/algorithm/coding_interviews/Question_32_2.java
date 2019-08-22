package priv.algorithm.coding_interviews;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 32.2 把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Question_32_2 {
    public static void main(String[] args) {
        
    }
    
    private ArrayList<ArrayList<Integer>> printBinaryTreeByLevelSorting(TreeNode rootNode) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (rootNode == null)
            return resultList;

        queue.addLast(rootNode);

        while (!queue.isEmpty()) {
            ArrayList<Integer> levelList = new ArrayList<>();
            int queueSize = queue.size();

            while (queueSize-- > 0) {
                TreeNode pNode = queue.pollFirst();
                levelList.add(pNode.val);
                if (pNode.left != null)
                    queue.addLast(pNode.left);
                if (pNode.right != null)
                    queue.addLast(pNode.right);
            }
            resultList.add(levelList);
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
