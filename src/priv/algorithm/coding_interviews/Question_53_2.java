package priv.algorithm.coding_interviews;

/**
 * 53_2. 找出0~n-1中缺失的数字
 * 题目描述：剑指offer p266
 */
public class Question_53_2 {
    public static void main(String[] args) {
        int result;
        int[][] testInstances = {{0, 1, 2, 3, 5, 6}, {1, 2, 3, 4}, {0, 1, 2, 3}};
        Question_53_2 question_53_2 = new Question_53_2();

        for (int[] testInstance : testInstances) {
            result = question_53_2.getMissingNumberV1(testInstance);
            System.out.println(result);
            result = question_53_2.getMissingNumberV2(testInstance);
            System.out.println(result);
        }
    }

    private int getMissingNumberV2(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;

        int left = 0, right = numbers.length - 1, middle, result = -1;
        while (left <= right) {
            middle = (left + right) >> 1;
            if (numbers[middle] != middle) {
                if (middle == 0 || numbers[middle - 1] == middle - 1) {
                    result = middle;
                    break;
                } else
                    right = middle - 1;
            } else
                left = middle + 1;
        }

        return result;
    }

    private int getMissingNumberV1(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;

        int result = -1;
        int left = 0, right = numbers.length - 1, middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (numbers[middle] > middle) {
                right = middle - 1;
                if (right == -1) {
                    result = 0;
                    break;
                }
            }
            else {
                if (middle != numbers.length - 1 && numbers[middle + 1] != numbers[middle] + 1) {
                    result = middle + 1;
                    break;
                }
                left = middle + 1;
            }
        }

        return result;
    }
}
