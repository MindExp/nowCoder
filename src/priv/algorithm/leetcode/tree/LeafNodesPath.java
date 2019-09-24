package priv.algorithm.leetcode.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 */
public class LeafNodesPath {
    private LinkedList<String> paths = new LinkedList<>();

    /**
     * 基于非递归后续遍历获取树中结点路径【栈中结点即为路径】
     * @param root
     */
    public void getLeafsPath(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;
        TreeNode lastVisited = null;

        while (pNode != null) {
            stack.push(pNode);
            pNode = pNode.left;
        }
        while (!stack.isEmpty()) {
            pNode = stack.pop();
            if (pNode.right == null || pNode.right == lastVisited) {
                // 检测当前访问结点是否为叶节点
                if (pNode.left == null && pNode.right == null) {
                    stack.push(pNode);
                    this.addLeafNodePath(stack);
                    stack.pop();
                }
                lastVisited = pNode;
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

    private void addLeafNodePath(Stack<TreeNode> stack) {
        StringBuilder pathBuilder = new StringBuilder();
        Iterator<TreeNode> iterator = stack.iterator();
        while (iterator.hasNext()) {
            String nodeContent = String.valueOf((iterator.next().val));
            String insertStr = (pathBuilder.length() > 0) ? "->" + nodeContent : nodeContent;
            pathBuilder.append(insertStr);
        }
        this.paths.add(pathBuilder.toString());
    }

    public void printPaths() {
        for (String path : this.paths) {
            System.out.println(path);
        }
    }
}
