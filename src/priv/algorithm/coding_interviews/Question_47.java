package priv.algorithm.coding_interviews;

/**
 * 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 */
public class Question_47 {
    public static void main(String[] args) {
        int[][] testInstance = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};

        Question_47 question_47 = new Question_47();
        int result;
        result = question_47.getMostGiftsV1(testInstance);
        System.out.println(result);
        result = question_47.getMostGiftsV2(testInstance);
        System.out.println(result);
        result = question_47.getMostGiftsV3(testInstance);
        System.out.println(result);
    }

    /**
     * 动态规划：f(i, j) = max(f(i - 1, j), f(i, j - 1)) + value[i][j]
     * @param matrix
     * @return
     */
    private int getMostGiftsV1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length, cols = matrix.length;
        int upResult, leftResult;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0)
                    matrix[i][j] += 0;
                else if (i == 0)
                    matrix[i][j] += matrix[i][j - 1];
                else if (j == 0)
                    matrix[i][j] += matrix[i - 1][j];
                else {
                    upResult = matrix[i - 1][j];
                    leftResult = matrix[i][j - 1];
                    matrix[i][j] += Math.max(upResult, leftResult);
                }
            }

        return matrix[rows - 1][cols - 1];
    }

    private int getMostGiftsV2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length, cols = matrix.length;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                int upResult = 0, leftResult = 0;

                if (i > 0)
                    upResult = matrix[i - 1][j];
                if (j > 0)
                    leftResult = matrix[i][j - 1];

                matrix[i][j] += Math.max(upResult, leftResult);
            }

        return matrix[rows - 1][cols - 1];
    }

    // 在不能修改原始数组的情况下，该方法空间复杂度为 O(cols)
    private int getMostGiftsV3(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length, cols = matrix[0].length;
        int[] maxValue = new int[cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                int upResult = 0, leftResult = 0;

                if (i > 0)
                    upResult = maxValue[j];
                if (j > 0)
                    leftResult = maxValue[j - 1];

                maxValue[j] = Math.max(upResult, leftResult) + matrix[i][j];
            }

        return maxValue[rows - 1];
    }
}
