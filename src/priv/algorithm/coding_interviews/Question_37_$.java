package priv.algorithm.coding_interviews;

/**
 * 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 */
// 未通过 nowcoder 测试用例
public class Question_37_$ {
    private StringBuffer serializedStr = new StringBuffer();
    private TreeNode deSerializedRootNode;
    int index = -1, serializedStrLen;

    public static void main(String[] args) {
        int[] pre = {6, 5, 4, 7, 2, 3};
        int[] in = {5, 4, 6, 2, 7, 3};

        Question_37_$ question_37_$ = new Question_37_$();
        TreeNode rootNode = question_37_$.reConstructBinaryTree(pre, in);

        String serializedStr = question_37_$.serialize(rootNode);
        System.out.println(serializedStr);
        rootNode = question_37_$.deSerialize(serializedStr);
        question_37_$.printBianryTreeByPreOrderRecursion(rootNode);
    }

    private String serialize(TreeNode rootNode) {
        this.serializeAction(rootNode);
        String str = this.serializedStr.toString();
        this.serializedStrLen = str.length();

        return str;
    }

    // 中序遍历序列化
    private void serializeAction(TreeNode rootNode) {
        if (rootNode == null) {
            serializedStr.append("#" + ",");
            return;
        }

        serializedStr.append(rootNode.val + ",");
        this.serializeAction(rootNode.left);
        this.serializeAction(rootNode.right);
    }

    private TreeNode deSerialize(String str) {
        if (str == null || str.length() == 0 || index > this.serializedStrLen)
            return null;

        String[] strArray = str.split(",");
        TreeNode deSerializedRootNode = null;
        index++;
        if (!strArray[index].equals("#")) {
            deSerializedRootNode = new TreeNode(Integer.valueOf(strArray[index]));
            deSerializedRootNode.left = this.deSerialize(str);
            deSerializedRootNode.right = this.deSerialize(str);
        }

        return deSerializedRootNode;
    }

    private class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root;

        if (pre == null || in == null)
            return null;
        if (pre.length != in.length){
            // 输入错误标记
            System.out.println("error input data, can not construct binary tree.");
            return null;
        }

        root = this.reConstructBinaryTreeAction(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTreeAction(int [] pre, int preStart, int preEnd, int [] in, int inStart, int inEnd) {
        // 注意边界条件
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(pre[preStart]);
        int indexOfRootNodeInInorder = 0;

        for (int index = inStart; index <= inEnd; index++) {
            if (pre[preStart] == in[index]) {
                indexOfRootNodeInInorder = index;
                break;
            }
        }

        int leftDistance = indexOfRootNodeInInorder - inStart;
        root.left = this.reConstructBinaryTreeAction(pre, preStart + 1, preStart + leftDistance,
                in, inStart, indexOfRootNodeInInorder - 1);
        root.right = this.reConstructBinaryTreeAction(pre, preStart + leftDistance + 1, preEnd,
                in, indexOfRootNodeInInorder + 1, inEnd);

        return root;
    }

    private void printBianryTreeByPreOrderRecursion(TreeNode rootNode) {
        if (rootNode == null)
            return;
        System.out.println(rootNode.val);
        this.printBianryTreeByPreOrderRecursion(rootNode.left);
        this.printBianryTreeByPreOrderRecursion(rootNode.right);
    }
}
