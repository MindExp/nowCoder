package priv.algorithm.coding_interviews;

import java.util.LinkedList;

/**
 * 41.2 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 */
public class Question_41_2 {
    public static void main(String[] args) {
        String[] testInatances = {"g", "go", "goo", "goog", "googl", "google"};

        for (String testInstance : testInatances) {
            Question_41_2 question_41_2 = new Question_41_2();
            for (char ch : testInstance.toCharArray()) {
                question_41_2.insertChar(ch);
            }
            char target = question_41_2.findFirstAppearingOnaceCharacter();
            System.out.println(target);
        }
    }

    private int[] counter = new int[256];
    private LinkedList<Character> queue = new LinkedList<>();

    // 方案一
    private void insertChar(char ch) {
        // 若字符 ch 存在重复，则计数器统一计为 2
        if (counter[ch] != 2)
            counter[ch] += 1;
        // 若该字符已经存在，则不入队
        if (counter[ch] < 2)
            queue.add(ch);
    }

    private char findFirstAppearingOnaceCharacter() {
        // 若不存在则返回字符 '#'
        char target = '#', ch;

        LinkedList pNode = this.queue;
        int queueSize = pNode.size();
        for (int index = 0; index < queueSize; index++) {
            ch = (char)pNode.get(index);
            if (counter[ch] == 1) {
                target = ch;
                break;
            }
        }

        return target;
    }

    // 方案二
    private void insertCharA2(char ch) {
        counter[ch] += 1;
        queue.add(ch);

        while (!queue.isEmpty() && counter[queue.peek()] > 1)
            queue.poll();
    }

    private char findFirstAppearingOnaceCharacter_A2() {

        return queue.isEmpty() ? '#' : this.queue.peek();
    }
}
