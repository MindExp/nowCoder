package priv.algorithm.coding_interviews;

import java.util.Stack;

/**
 * 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 */
public class Question_31 {
    public static void main(String[] args) {

    }

    private boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        boolean judgeResult = false;
        Stack<Integer> dataStack = new Stack<>();

        if (pushOrder == null || popOrder == null || pushOrder.length != popOrder.length)
            return false;

        for (int i = 0, j = 0; i < pushOrder.length; i++) {
            dataStack.push(pushOrder[i]);
            while (!dataStack.isEmpty() && dataStack.peek() == popOrder[j]) {
                dataStack.pop();
                j++;
            }
        }

        if (dataStack.isEmpty())
            judgeResult = true;

        return judgeResult;
    }
}
