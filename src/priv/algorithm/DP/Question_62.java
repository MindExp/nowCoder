package priv.algorithm.DP;

/**
 * 62. 矩阵的总路径数
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 */
public class Question_62 {
    public static void main(String[] args) {

    }

    /**
     * 动态规划求解 V1
     * 状态转移方程：dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
     * @param array
     * @return
     */
    private int countRoutsByDPV1(int[][] array) {
        int rows = array.length, cols = array[0].length;
        // dp[i][j]：dp[i][j] 到 dp[rows - 1][cols - 1] 的路径总数
        int[][] dp = new int[rows][cols];

        for (int indexX = rows - 1; indexX >= 0; indexX--) {
            for (int indexY = cols - 1; indexY >= 0; indexY--) {
                if (indexX == rows - 1)
                    dp[indexX][indexY] = 1;
                else if (indexY == cols - 1)
                    dp[indexX][indexY] = 1;
                else
                    dp[indexX][indexY] = dp[indexX + 1][indexY] + dp[indexX][indexY + 1];
            }
        }
        return dp[0][0];
    }

    /**
     * 动态规划求解 V2
     * 状态转移方程：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     * @param array
     * @return
     */
    private int countRoutsByDPV2(int[][] array) {
        int rows = array.length, cols = array[0].length;
        // dp[i][j]：从 dp[0][0] 到 dp[i][j] 的路径总数
        int[][] dp = new int[rows][cols];

        for (int indexX = 0; indexX < rows; indexX++)
            dp[indexX][0] = 1;
        for (int indexY = 0; indexY < cols; indexY++)
            dp[0][indexY] = 1;

        for (int indexX = 1; indexX < rows; indexX++) {
            for (int indexY = 1; indexY < cols; indexY++) {
                dp[indexX][indexY] = dp[indexX - 1][indexY] + dp[indexX][indexY - 1];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    /**
     * 方案二：dp[j] 代表到达第 j 列，dp[j] = dp[j] + dp[j - 1]
     * @param array
     * @return
     */
    private int countRoutsByDPV3(int[][] array) {
        int rows = array.length, cols = array[0].length;
        int[] dp = new int[cols];
        dp[0] = 1;

        for (int indexX = 0; indexX < rows; indexX++) {
            for (int indexY = 1; indexY < cols; indexY++) {
                dp[indexY] = dp[indexY] + dp[indexY - 1];
            }
        }
        return dp[cols - 1];
    }

    /**
     * 回溯求解，容易超时
     * @param array
     * @return
     */
    private int countRoutsByBackTracking(int[][] array, int indexX, int indexY) {
        if (indexX == array.length || indexY == array[0].length)
            return 0;
        if (indexX == array.length - 1 && indexY == array[0].length - 1)
            return 1;

        int directionOne = this.countRoutsByBackTracking(array, indexX + 1, indexY);
        int directionTwo = this.countRoutsByBackTracking(array, indexX, indexY + 1);
        return directionOne + directionTwo;
    }
}
