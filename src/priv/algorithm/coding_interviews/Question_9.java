package priv.algorithm.coding_interviews;

import java.util.Stack;

/**
 * 9. 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 */
public class Question_9 {
    public static void main(String[] args){

    }

    private Stack<Integer> push_stack = new Stack<Integer>();
    private Stack<Integer> pop_stack = new Stack<Integer>();

    private void push(int item){
        push_stack.push(item);
    }

    private int pop(){
        int topElement;
        if (pop_stack.isEmpty()) {
            while (!push_stack.isEmpty())
                pop_stack.push(push_stack.pop());
        }
        topElement = pop_stack.pop();

        return topElement;
    }
}
