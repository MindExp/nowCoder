package priv.algorithm.coding_interviews;

/**
 * 8. 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 测试用例：
 */
public class Question_8 {
    public static void main(String[] args) {

    }

    private TreeNode findNextNode(TreeNode currentNode) {
        TreeNode pNode, nextNode = null;
        TreeNode parentNode;

        /*
         1. 如当前节点的右子节点不为 null，则下一个节点位于右子树的最左边
         2. 如当前节点的右子节点为 null, 则下一个节点：
            2.1. 当前节点为其父节点的左子节点，则下一个节点为当前节点的父节点
            2.2. 当前节点为其父节点的右子节点，则下一个节点的左子节点通过父节点一直向上查找，直到找到一个节点为其父节点的左子节点
         3. 不存在下一个节点，返回null
          */

        if (currentNode.right != null) {
            pNode = currentNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            nextNode = pNode;
        }else {
            pNode = currentNode;
            while (pNode.parent != null){
                parentNode = pNode.parent;
                if (pNode == parentNode.left){
                    nextNode = parentNode;
                    break;
                }else
                    pNode = pNode.parent;
            }
        }

        return nextNode;
    }

    private class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode parent = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}