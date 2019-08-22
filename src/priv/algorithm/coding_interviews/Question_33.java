package priv.algorithm.coding_interviews;

/**
 * 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 */
public class Question_33 {
    public static void main(String[] args) {
        int[][] testInstances = {{2, 6, 5, 8, 11, 10, 9, 7}, {1, 3, 2}, {4, 6, 7, 5}};
        Question_33 question_33 = new Question_33();

        for (int[] testInstance : testInstances)
            System.out.println(question_33.postIterOfBinarySearchTree(testInstance));
    }

    private boolean postIterOfBinarySearchTree(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;

        return this.postIterOfBinarySearchTree(sequence, 0, sequence.length - 1);
    }

    private boolean postIterOfBinarySearchTree(int[] sequence, int start, int end) {
        boolean isPostIteration = false;

        if (start == end || start > end)
            return true;

        int index = start;

        while (index < end && sequence[index] < sequence[end])
            index++;

        for (int i = index; i < end; i++)
            if (sequence[i] < sequence[end])
                return false;

        isPostIteration = this.postIterOfBinarySearchTree(sequence, start, index - 1) &&
                this.postIterOfBinarySearchTree(sequence, index, end - 1);

        return isPostIteration;
    }
}
