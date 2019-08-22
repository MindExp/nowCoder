package priv.algorithm.coding_interviews;

/**
 * 42. 连续子数组的最大和
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 */
public class Question_42_$ {
    private int start;
    private int end;

    public static void main(String[] args) {
        int[][] testInstances = {{6, -3, -2, 7, -15, 1, 2, 2}, {1, -2, 3, 10, -4, 7, 2, 5}};
        Question_42_$ question_42$ = new Question_42_$();

        for (int[] testInstance : testInstances)
            System.out.println(question_42$.maxSumOfContinousSubArray(testInstance));
    }

    // 方案一：掌握
    private int maxSumOfContinousSubArray(int[] numbers) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        int length = numbers.length;

        for (int index = 0; index < length; index++) {
            if (currentSum <= 0)
                currentSum = numbers[index];
            else
                currentSum += numbers[index];

            if (currentSum > maxSum)
                maxSum = currentSum;
        }

        return maxSum;
    }

    // 动态规划求解，待完成
    private int maxSumOfContinousSubArrayByDP(int[] numbers) {

        return 0;
    }
}
