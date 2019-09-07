package priv.algorithm.DP;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
public class Question_63 {
    public static void main(String[] args) {
        Question_63 question_63 = new Question_63();
        question_63.countRoutsByDPV1(new int[][] {{0}, {1}});
    }

    /**
     * 动态规划求解
     * @param array
     * @return
     */
    private int countRoutsByDPV1(int[][] array) {
        int rows = array.length, cols = array[0].length;
        // dp[i][j]：从 dp[0][0] 到 dp[i][j] 的路径总数
        int[][] dp = new int[rows][cols];

        if (array[0][0] == 1)
            return 0;
        dp[0][0] = 1;

        for (int indexX = 1; indexX < rows; indexX++)
            dp[indexX][0] = (array[indexX][0] == 0 && dp[indexX - 1][0] == 1) ? 1 : 0;
        for (int indexY = 1; indexY < cols; indexY++)
            dp[0][indexY] = (array[0][indexY] == 0 && dp[0][indexY - 1] == 1) ? 1 : 0;

        for (int indexX = 1; indexX < rows; indexX++) {
            for (int indexY = 1; indexY < cols; indexY++) {
                if (array[indexX][indexY] == 1)
                    dp[indexX][indexY] = 0;
                else
                    dp[indexX][indexY] = dp[indexX - 1][indexY] + dp[indexX][indexY -  1];
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
