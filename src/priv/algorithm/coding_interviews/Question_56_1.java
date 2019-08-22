package priv.algorithm.coding_interviews;

import java.util.HashMap;

/**
 * 56. 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
 */
public class Question_56_1 {
    public static void main(String[] args) {
        int[][] testInstances = {{0, 1, 2, 3, 4, 4, 2, 3, 1, 6}, {6, 1, 2, 3, 0, 4, 4, 2, 3, 1}, {1, 2, 0, 3, 4, 6, 4, 2, 3, 1}};
        Question_56_1 question_56_1 = new Question_56_1();

        for (int[] testInstance : testInstances) {
            int[] diffOne = new int[1], diffTwo = new int[1];
            question_56_1.findNumsAppearOanceV3(testInstance, diffOne, diffTwo);
            System.out.println(diffOne[0]);
            System.out.println(diffTwo[0]);
        }
    }

    /**
     * 异或运算法则：
     * 1. a xor a = 0
     * 2. 交换律：a xor b  = b xor a= 1
     * 3. 结合律：a xor b xor c = (a xor b) xor c = a xor (b xor c)
     * 4. d = a xor b xor c, 则 a = d xor b xor c
     * 5. a xor b xor a = b
     */

    private void findNumsAppearOanceV1(int[] numbers, int[] diffOne, int[] diffTwo) {
        if (numbers == null || numbers.length < 2)
            return;

        int xorResult = 0;
        for (int index = 0; index < numbers.length; index++)
            xorResult ^= numbers[index];

        int indexOfFirstOneBit = this.getIndexOfFirstOneBit(xorResult);
        int targetOne = 0, targetTwo = 0;
        for (int index = 0; index < numbers.length; index++) {
            if (this.isSameValueOnBit(numbers[index], indexOfFirstOneBit))
                targetOne ^= numbers[index];
            else
                targetTwo ^= numbers[index];
        }
        diffOne[0] = targetOne;
        diffTwo[0] = targetTwo;
    }

    /**
     * 推荐方案
     * @param numbers
     * @param diffOne
     * @param diffTwo
     */
    private void findNumsAppearOanceV2(int[] numbers, int[] diffOne, int[] diffTwo) {
        if (numbers == null || numbers.length < 2)
            return;

        int xorResult = 0;

        for (int number : numbers)
            xorResult ^= number;

        xorResult &= -xorResult;
        diffOne[0] = 0;
        diffTwo[0] = 0;

        for (int number : numbers) {
            if ((number & xorResult) == 0)
                diffOne[0] ^= number;
            else
                diffTwo[0] ^= number;
        }
    }

    // 未通过牛客
    private void findNumsAppearOanceV3(int[] numbers, int[] diffOne, int[] diffTwo) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        if (numbers == null || numbers.length < 2)
            return;

        for (int number : numbers) {
            if (hashMap.containsKey(number))
                hashMap.put(number, hashMap.get(number) + 1);
            else
                hashMap.put(number, 1);
        }

        boolean targetOne = false, targetTwo = false;

        for (int key : hashMap.keySet()) {
            if (hashMap.get(key) == 1) {
                if (!targetOne) {
                    diffOne[0] = key;
                    targetOne = true;
                }else {
                    diffTwo[0] = key;
                    targetTwo = true;
                }
                if (targetOne && targetTwo)
                    break;
            }
        }
    }

    /**
     * 获取倒数第一个 bit 位为 1 的 index
     * @param value
     * @return
     */
    private int getIndexOfFirstOneBit(int value) {
        int index = 0;

        while (((value & 1) == 0) && (index < Integer.SIZE)) {
            value = value >> 1;
            index++;
        }
        return index;
    }

    // 判断 number 数字第 bit 位是否为 1
    private boolean isSameValueOnBit(int number, int bit) {
        number >>= bit;
        return (number & 1) == 1;
    }
}
