package priv.algorithm.coding_interviews;

import java.util.Stack;

/**
 * 30. 包含 min 函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
 */
public class Question_30 {

    public static void main(String[] args) {


    }

    private class minElementStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public minElementStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        private void push(int value) {
            dataStack.push(value);
            minStack.push(minStack.isEmpty() ? value : Math.min(value, minStack.peek()));
        }

        private void pop() {
            dataStack.pop();
            minStack.pop();
        }

        private int peek() {
            return dataStack.peek();
        }

        private int minElementInStack() {
            return minStack.peek();
        }
    }
}
