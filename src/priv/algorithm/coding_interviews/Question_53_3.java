package priv.algorithm.coding_interviews;

/**
 * 53_3. 数组中数值和下标相等的元素
 * 题目描述：剑指offer p267
 * 单调递增的数组中每个元素均为整数且唯一，找出数组中任意一个数值和下标相等的元素
 */
public class Question_53_3 {
    public static void main(String[] args) {
        int[][] testInstances = {{-5, -3, 1, 2, 4, 9}, {-3, -2, 0, 3}, {0, 3, 5, 7}, {-3, -2, -1}};
        Question_53_3 question_53_3 = new Question_53_3();
        int result;

        for (int[] testInstance : testInstances) {
            result = question_53_3.getNumber(testInstance);
            System.out.println(result);
        }
    }

    /**
     * 假设数组中下标 i 对应元素为 m:
     * 1. m = i, return m
     * 2. m > i, 则 array[i + k] > i + k
     * 3. m < i, 则 array[i - k] < i - k
     * @param numbers
     * @return
     */
    private int getNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;

        int left = 0, right = numbers.length - 1, middle, result = -1;
        while (left <= right) {
            middle = (left + right) >> 1;
            if (numbers[middle] == middle) {
                result = middle;
                break;
            }
            else if (numbers[middle] > middle)
                right = middle - 1;
            else
                left = middle + 1;
        }

        return result;
    }
}
