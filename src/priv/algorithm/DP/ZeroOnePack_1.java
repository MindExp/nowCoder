package priv.algorithm.DP;
import java.util.Scanner;

/**
 * 0-1 背包问题
 */
public class ZeroOnePack_1 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        ZeroOnePack_1 zeroOnePack_1 = new ZeroOnePack_1();

        while (scanner.hasNextLine()) {
            int volumes = scanner.nextInt();
            int items = scanner.nextInt();
            int[] weights = new int[items];
            int[] values = new int[items];

            for (int item = 0; item < items; item++) {
                weights[item] = scanner.nextInt();
                values[item] = scanner.nextInt();
            }
            int maxValue = zeroOnePack_1.getPackMaxValue(volumes, items, weights, values);
            System.out.println(maxValue);
        }
    }

    /**
     * 背包问题常规解法：空间复杂度 O(N * M)，时间复杂度 O(N * M)
     * @param volumes
     * @param items
     * @param weights
     * @param values
     * @return
     */
    private int getPackMaxValue(int volumes, int items, int[] weights, int[] values) {
        // dp[i][j] 表示将 i 个商品放入容量为 j 的背包中能获取的最大价值
        int[][] dp = new int[items + 1][volumes + 1];

        for (int item = 1; item < items + 1; item++) {
            for (int volume = 1; volume < volumes + 1; volume++) {
                // 第 item 个商品无法放入背包
                if (weights[item - 1] > volume)
                    dp[item][volume] = dp[item - 1][volume];
                // 第 item 个商品能放入背包：1. 放入情况；2.不放入情况
                else
                    dp[item][volume] = Math.max(dp[item - 1][volume - weights[item - 1]] + values[item - 1],
                            dp[item - 1][volume]);
            }
        }

        return dp[items][volumes];
    }

    /**
     * 0-1 背包问题优化解法/用逆序实现
     * @param volumes
     * @param items
     * @param weights
     * @param values
     * @return
     */
    private int getPackMaxValueAdvanced(int volumes, int items, int[] weights, int[] values) {
        // dp[i] 表示容量为 i 的背包最大获取价值
        int[] dp = new int[volumes + 1];

        // 逆序实现
        for (int item = 1; item < items + 1; item++) {
            for (int volume = volumes; volume > weights[item - 1]; volume--)
                dp[volume] = Math.max(dp[volume - weights[item - 1]] + values[item - 1], dp[volume]);
        }

        return dp[volumes];
    }
}
