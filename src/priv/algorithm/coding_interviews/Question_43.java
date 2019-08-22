package priv.algorithm.coding_interviews;

import java.util.ArrayList;

/**
 * 43. 从 1 到 n 整数中 number(0~9) 出现的次数
 */
public class Question_43 {
    public static void main(String[] args) {
        Question_43 question_43 = new Question_43();
        int[][] testInstances = {{1, 1}, {5, 2}, {35782, 1}, {352952, 3}, {5738392, 0}, {5738392, 9}};

        int result1, result2;
        for (int[] testInstance : testInstances) {
            result1 = question_43.countNumberAppearsInOne2N_A1(testInstance[0], testInstance[1]);
            result2 = question_43.countNumberAppearsInOne2N_A2(testInstance[0], testInstance[1]);
            System.out.println(result1 + "\t" + result2);
        }

    }

    // 方案一：暴力解法，不可取，时间复杂度 O(N * logN)
    private int countNumberAppearsInOne2N_A1(int n, int number) {
        int counter = 0;

        for (int i = 1; i < n + 1; i++)
            counter += this.countNumberInN(i, number);

        return counter;
    }

    private int countNumberInN(int n, int number) {
        int counter = 0;

        while (n != 0) {
            if (n % 10 == number)
                counter++;
            n = n / 10;
        }
        return counter;
    }

    // 方案二：掌握，未通过 targetNumber 为 0 的测试用例，时间复杂度 O(N)
    private int countNumberAppearsInOne2N_A2(int n, int targetNumber) {
        int counter = 0;
        int higherBit, currentBit, remainder = 0;
        // 357952
        for (int bit = 1; bit <= n; bit *= 10) {
            currentBit = (n / bit) % 10;
            remainder = n % bit;
            higherBit = (n / bit) / 10;

            if (currentBit > targetNumber)
                counter += (higherBit + 1) * bit;
            else if (currentBit == targetNumber)
                // counter += (higherBit + 1) * (remainder + 1);
                counter += 1 * (remainder + 1) + higherBit * bit;
            else
                counter += (higherBit - 1 + 1) * bit;
        }

        return counter;
    }

    // 存在 bug 待修复
    private int countNumberApparencesInOne2N(int n, int number) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] bitChars;
        int bitNumber, countNumbers = 0;

        while (n != 0) {
            bitNumber = n % 10;
            stringBuffer.append(bitNumber);
            n /= 10;
        }

        bitChars = stringBuffer.toString().toCharArray();
        int preNumber, postNumber;
        ArrayList<Integer> preNumberAndPostNumber;

        for (int index = 0; index < bitChars.length; index++) {
            // currentNumber = Integer.valueOf(bitChars[index] + "");
            preNumberAndPostNumber = this.getPreNumberAndLastPostNumber(bitChars, index);
            preNumber = preNumberAndPostNumber.get(0);
            postNumber = preNumberAndPostNumber.get(1);

            if (bitChars[index] == number)
                countNumbers += (preNumber + 1) * (postNumber + 1);
            else if (bitChars[index] > number)
                countNumbers += (preNumber + 1) * Math.pow(10, bitChars.length - 1 - index);
            else
                countNumbers += preNumber *  Math.pow(10, bitChars.length - 1 - index);
        }

        return countNumbers;
    }

    private ArrayList<Integer> getPreNumberAndLastPostNumber(char[] bitChars, int targetIndex) {
        StringBuffer preNumberStr = new StringBuffer();
        StringBuffer postNumberStr = new StringBuffer();
        char ch;
        ArrayList<Integer> preNumberAndPostNumber = new ArrayList<>();

        for (int index = 0; index < bitChars.length; index++) {
            ch = bitChars[index];
            if (index < targetIndex)
                preNumberStr.append(ch);
            else
                postNumberStr.append(ch);
        }
        if (preNumberStr.toString().equals(""))
            preNumberStr.append("0");
        if (postNumberStr.toString().equals(""))
            postNumberStr.append("0");
        preNumberAndPostNumber.add(Integer.valueOf(preNumberStr.toString()));
        preNumberAndPostNumber.add(Integer.valueOf(postNumberStr.toString()));

        return preNumberAndPostNumber;
    }
}
