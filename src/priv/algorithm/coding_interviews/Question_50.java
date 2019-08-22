package priv.algorithm.coding_interviews;

import java.util.BitSet;
import java.util.LinkedList;

/**
 * 50. 第一个只出现一次的字符位置
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 */
public class Question_50 {
    private LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        String[] testInstances = {"abaccdeff", "dsfsdfkgjeoewwqjsms"};
        Question_50 question_50 = new Question_50();

        for (String testInstance : testInstances) {
            int result;
            result = question_50.getIndexOfFirstNotRepeatingCharV1(testInstance);
            System.out.println(result);
            result = question_50.getIndexOfFirstNotRepeatingCharV2(testInstance);
            System.out.println(result);
        }
    }

    private int getIndexOfFirstNotRepeatingCharV1(String str) {
        if (str == null)
            return -1;

        int[] counter = this.countChar(str);
        int result = -1;

        while (!this.queue.isEmpty()) {
            int index = this.queue.getFirst();
            char ch = str.charAt(index);

            if (counter[ch] == 1) {
                result = index;
                break;
            }
            this.queue.removeFirst();
        }

        return result;
    }

    private int[] countChar(String str) {
        int[] counter = new int[256];
        int strLength = str.length();

        for (int index = 0; index < strLength; index++) {
            char ch = str.charAt(index);

            if (counter[ch] != 2)
                counter[ch] += 1;
            if (counter[ch] < 2)
                this.queue.addLast(index);
        }

        return counter;
    }

    private int getIndexOfFirstNotRepeatingCharV2(String str) {
        if (str == null)
            return -1;

        BitSet bitSet1 = new BitSet();
        BitSet bitSet2 = new BitSet();
        int result = -1, strLength = str.length();

        for (char ch : str.toCharArray()) {
            //0-0
            if (!bitSet1.get(ch) && !bitSet2.get(ch))
                bitSet1.set(ch);
            // 1-0
            else if (bitSet1.get(ch) && !bitSet2.get(ch))
                bitSet2.set(ch);
        }

        for (int index = 0; index < strLength; index++) {
            char ch = str.charAt(index);
            if (bitSet1.get(ch) && !bitSet2.get(ch)) {
                result = index;
                break;
            }
        }

        return result;
    }
}
