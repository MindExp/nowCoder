package priv.algorithm.coding_interviews;

/**
 * 63. 股票的最大利润
 * 可以有一次买入和一次卖出，买入必须在前。求最大收益。
 */
public class Question_63 {
    public static void main(String[] args) {
        int[][] testInstances = {{7, 1, 5, 3, 6, 4}, {9, 11, 8, 5, 7, 12, 16, 14}};
        Question_63 question_63 = new Question_63();

        for (int[] testInstance : testInstances) {
            int maxProfit = question_63.maxProfit(testInstance);
            System.out.println(maxProfit);
        }
    }

    private int maxProfit(int[] timeStamp) {
        if (timeStamp == null || timeStamp.length == 0)
            return 0;

        int maxProfit = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        int[] dp = new int[timeStamp.length];

        for (int time = 0; time < timeStamp.length; time++) {
            if (timeStamp[time] < minValue)
                minValue = timeStamp[time];
            dp[time] = timeStamp[time] - minValue;

            if (dp[time] > maxProfit)
                maxProfit = dp[time];
        }

        return maxProfit;
    }
}
