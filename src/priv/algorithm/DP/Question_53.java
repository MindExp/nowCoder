package priv.algorithm.DP;

import java.util.Scanner;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Question_53 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question_53 question_53 = new Question_53();
        while (scanner.hasNextLine()) {
            String[] strArray = scanner.nextLine().trim().split(" ");
            int arrayLength = strArray.length;
            int[] array = new int[arrayLength];

            for (int index = 0; index < arrayLength; index++)
                array[index] = Integer.parseInt(strArray[index]);

            int maxSubSequentialSum = question_53.maxSumOfContiniousSubArrayByDPV1(array);
            System.out.println(maxSubSequentialSum);
        }
    }

    /**
     * 掌握：动态规划求解
     * @param array
     * @return
     */
    private int maxSumOfContiniousSubArrayByDPV1(int[] array) {
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
     * 优化版动态规划
     * @param array
     * @return
     */
    private int maxSumOfContiniousSubArrayByDPV2(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int pre = array[0], maxSum = pre;

        for (int index = 1; index < array.length; index++) {
            pre = Math.max(pre + array[index], array[index]);
            maxSum = Math.max(pre, maxSum);
        }
        return maxSum;
    }

    /**
     * 常规方案：同优化版动态规划方案
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
