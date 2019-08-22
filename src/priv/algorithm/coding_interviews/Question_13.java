package priv.algorithm.coding_interviews;

/**
 * 13. 机器人的运动范围
 * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
 *
 * 测试用例：{threhold, rows, columns, result}
 */
public class Question_13 {
    int threshold;
    int rows;
    int columns;
    boolean[][] visitedMatrix;

    public static void main(String[] args) {
        Question_13 question_13 = new Question_13();
        int[][] testInstances = {{5, 10, 10, 21}, {15, 20, 20, 359}, {10, 1, 100, 29}, {10, 1, 10, 10}, {15, 100, 1, 79},
                {15, 10, 1, 10}, {15, 1, 1, 1}, {0, 1, 1, 1}, {-10, 10, 10, 0}};
        int result = 0;

        for (int[] testInstance: testInstances) {
            result = question_13.movingCount(testInstance[0], testInstance[1], testInstance[2]);
            System.out.println(result);
        }
    }

    private int movingCount(int threshold, int rows, int columns) {
        if (rows <= 0 || columns <= 0)
            return 0;

        this.initParameters(threshold, rows, columns);

        return this.depthFirstSearch(0, 0);
    }

    private void initParameters(int threshold, int rows, int columns) {
        this.threshold = threshold;
        this.rows = rows;
        this.columns = columns;
        this.visitedMatrix = new boolean[rows][columns];
    }

    private int depthFirstSearch(int row, int column) {
        int result = 0;
        boolean dataOutOfBound = row < 0 || row > this.rows - 1 || column < 0 || column > this.columns - 1;

        if (dataOutOfBound || this.addIndexOfRowAndColumn(row, column) > this.threshold) {
            // 如(row, column)节点大于threhold，则不计数，并标记已访问
            if (!dataOutOfBound && this.addIndexOfRowAndColumn(row, column) > this.threshold)
                this.visitedMatrix[row][column] = true;
            return 0;
        }
        // (row, column) 节点小于 threhold 且未被访问，则计数加 1
        if (!visitedMatrix[row][column]){
            this.visitedMatrix[row][column] = true;
            result += 1 + this.depthFirstSearch(row - 1, column) + this.depthFirstSearch(row + 1, column) +
                    this.depthFirstSearch(row, column - 1) + this.depthFirstSearch(row, column + 1);
        }else
            return 0;

        return result;
    }

    private int addIndexOfRowAndColumn(int row, int column) {
        return this.sumElement(row) + this.sumElement(column);
    }

    private int sumElement(int value) {
        int result = 0;
        while (value != 0){
            result += value % 10;
            value /= 10;
        }

        return result;
    }
}
