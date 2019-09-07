package priv.algorithm.DP;

import java.util.Scanner;

/**
 * 多重背包问题：每类物品都有个数限制，第 i 类物品最多可以装 num[i] 次
 * 完全背包：每类物品可以无限次装进包内
 */
public class ZeroOnePack_2 {
    public  static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        ZeroOnePack_2 zeroOnePack_2 = new ZeroOnePack_2();
        while (scanner.hasNextLine()) {
            int volumes = scanner.nextInt();
            int items = scanner.nextInt();
            int[] weights = new int[items];
            int[] values = new int[items];
            int[] counts = new int[items];

            for (int item = 0; item < items; item++) {
                weights[item] = scanner.nextInt();
                values[item] = scanner.nextInt();
                counts[item] = scanner.nextInt();
            }
            int maxValue = zeroOnePack_2.getPackMaxValue(volumes, items, weights, values, counts);
            System.out.println(maxValue);
        }
    }

    /**
     * 多重背包问题：每类物品都有个数限制，第 i 类物品最多可以装 num[i] 次
     * @param volumes
     * @param items
     * @param weights
     * @param values
     * @param counts
     * @return
     */
    private int getPackMaxValue(int volumes, int items, int[] weights, int[] values, int[] counts) {
        int[][] dp = new int[items + 1][volumes + 1];

        for (int item = 1; item < items + 1; item++) {
            for (int volume = 1; volume < volumes + 1; volume++) {
                if (weights[item - 1] > volume)
                    dp[item][volume] = dp[item - 1][volume];
                else {
                    // 考虑商品数量限制
                    int maxCount = Math.min(counts[item - 1], volume / weights[item - 1]);

                    for (int count = 0; count < maxCount; count++)
                        dp[item][volume] = Math.max(dp[item - 1][volume],
                                dp[item - 1][volume - count * weights[item - 1]] + count *values[item - 1]);
                }
            }
        }

        return dp[items][volumes];
    }

    /**
     * 完全背包问题
     * 方案一：可转换为多重背包问题求解/根据 volumes 进行转换
     * @param volumes
     * @param items
     * @param weights
     * @param values
     * @return
     */
    private int getCompletePackMaxValueV1(int volumes, int items, int[] weights, int[] values) {
        int[] counts = new int[items];

        for (int item = 0; item < items; item++)
            counts[item] = volumes / weights[item];

        return this.getPackMaxValue(volumes, items, weights, values, counts);
    }

    /**
     * 完全背包问题
     * 方案二：顺序求解
     * @param volumes
     * @param items
     * @param weights
     * @param values
     * @return
     */
    private int getCompletePackMaxValueV2(int volumes, int items, int[] weights, int[] values) {
        int[] dp = new int[volumes + 1];

        for (int item = 1; item < items + 1; item++) {
            // 顺序实现
            for (int volume = weights[item - 1]; volume < volumes + 1; volume++) {
                dp[volume] = Math.max(dp[volume - weights[item - 1]] + values[item - 1], dp[volume]);
            }
        }

        return dp[volumes];
    }
}
