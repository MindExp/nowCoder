package priv.algorithm.DP;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Question_53 {
    public static void main(String[] args) {

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

    /**
     * 常规方案
     * @param numbers
     * @return
     */
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
}
