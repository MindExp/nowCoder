package priv.algorithm.DP;

/**
 * 64. 矩阵的最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class Question_64 {
    public static void main(String[] args) {

    }

    /**
     * 递归暴力求解，时间复杂度较高
     * @param array
     * @param indexX
     * @param indexY
     * @return
     */
    private int calculateByForce(int[][] array, int indexX, int indexY) {
        if (indexX == array.length || indexY == array[0].length)
            return Integer.MAX_VALUE;
        if (indexX == array.length - 1 && indexY == array[0].length - 1)
            return array[indexX][indexY];

        int directionOne = this.calculateByForce(array, indexX + 1, indexY);
        int directionTwo = this.calculateByForce(array, indexX, indexY + 1);

        return array[indexX][indexY] + Math.min(directionOne, directionTwo);
    }

    /**
     * 二维动态规划求解：
     * 可进行数组原位置操作，将空间复杂度降低为 O(1)：dp[i][j] = array[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1])
     * @param array
     * @return
     */
    private int calculateByDP(int[][] array) {
        int rows = array.length, cols = array[0].length;
        // dp[i][j] 代表从 (i, j) 位置到达最右下角的最小路径和
        int[][] dp = new int[rows][cols];

        for (int indexX = array.length - 1; indexX >= 0; indexX--) {
            for (int indexY = array[0].length - 1; indexY >= 0; indexY--) {
                if (indexX == rows - 1 && indexY == cols - 1)
                    dp[indexX][indexY] = array[indexX][indexY];
                else if (indexX == rows - 1)
                    dp[indexX][indexY] = array[indexX][indexY] + dp[indexX][indexY + 1];
                else if (indexY == cols - 1)
                    dp[indexX][indexY] = array[indexX][indexY] + dp[indexX + 1][indexY];
                else
                    dp[indexX][indexY] = array[indexX][indexY] +
                            Math.min(dp[indexX + 1][indexY], dp[indexX][indexY + 1]);
            }
        }
        return dp[0][0];
    }
}
