package priv.algorithm.coding_interviews;

/**
 * 42. 连续子数组的最大和
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 */
public class Question_42 {
    private int start;
    private int end;

    public static void main(String[] args) {
        int[][] testInstances = {{6, -3, -2, 7, -15, 1, 2, 2}, {1, -2, 3, 10, -4, 7, 2, 5}};
        Question_42 question_42 = new Question_42();

        for (int[] testInstance : testInstances)
            System.out.println(question_42.maxSumOfContiniousSubArray(testInstance));
    }

    // 方案一：掌握
    private int maxSumOfContiniousSubArray(int[] numbers) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        int length = numbers.length;

        for (int index = 0; index < length; index++) {
            if (currentSum <= 0)
                currentSum = numbers[index];
            else
                currentSum += numbers[index];

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    /**
     * 动态规划求解
     * @param array
     * @return
     */
    private int maxSumOfContiniousSubArrayByDP(int[] array) {
        if (array == null)
            return 0;
        // dp[i]：以 array[i] 为结束的最大连续和
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int maxSum = array[0];

        for (int index = 1; index < array.length; index++) {
            dp[index] = Math.max(dp[index - 1] + array[index], array[index]);
            maxSum = Math.max(maxSum, dp[index]);
        }
        return maxSum;
    }
}
