package priv.algorithm.coding_interviews;

import java.util.HashMap;

/**
 * 数组中唯一只出现一次的数字
 * 描述：在一个数组中，除一个数字只出现一次之外，其他数字都出现了三次，请找出那个只出现一次的数字
 */
public class Question_56_2 {
    public static void main(String[] args) {
        int[][] testInstances = {{1, 2, 3, 2, 3, 3, 2, 1, 1, 6}, {1, 2, 3, 2, 1, 3, 6, 3, 2, 1}, {6, 1, 2, 3, 2, 1, 3, 3, 2, 1}};

        Question_56_2 question_56_2 = new Question_56_2();
        int result;
        for (int[] testInstance : testInstances) {
            try {
                result = question_56_2.findAppearOnecNumbersV1(testInstance);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("error.");
            }
        }
    }

    // 推荐方案：位运算，时间复杂度 O(N)，空间复杂度 O(1)
    private int findAppearOnecNumbersV1(int[] numbers) throws Exception{
        if (numbers == null || numbers.length < 1)
            throw new Exception("invalid input data.");

        int[] targetBitState = new int[Integer.SIZE];
        int result = 0;

        for (int number : numbers) {
            int bitMask = 1;
            for (int bitIndex = Integer.SIZE - 1; bitIndex >= 0; bitIndex--) {
                targetBitState[bitIndex] += number & bitMask;
                bitMask <<= 1;
            }
        }

        for (int bit : targetBitState) {
            result <<= 1;
            result += (bit % 3 == 0) ? 0 : 1;
        }
        return result;
    }

    // 时间复杂度 O(N), 空间复杂度 O(N)
    private int findAppearOnecNumbersV2(int[] numbers) {
        if (numbers == null || numbers.length < 4) {
            System.out.println("error input data.");
            return -1;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int number : numbers) {
            if (hashMap.containsKey(number))
                hashMap.put(number, hashMap.get(number) + 1);
            else
                hashMap.put(number, 1);
        }

        for (int key : hashMap.keySet()) {
            if (hashMap.get(key) == 1)
                return key;
        }

        return -1;
    }
}
