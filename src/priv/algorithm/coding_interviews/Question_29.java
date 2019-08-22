package priv.algorithm.coding_interviews;

import java.util.ArrayList;

/**
 * 29. 顺时针打印矩阵
 */
public class Question_29 {
    public static void main(String[] args) {
        int[][][] testInstances = {{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}}, {{10}, {11}, {12}}};
        Question_29 question_29 = new Question_29();

        for (int[][] testInstance : testInstances)
            for (Object item : question_29.printMatrixByClockWise(testInstance).toArray())
                System.out.println(((Integer)item).intValue());
    }

    private ArrayList<Integer> printMatrixByClockWise(int[][] matrix) {
        if (matrix == null)
            return null;

        ArrayList<Integer> resultList = new ArrayList<>();
        int rows = matrix.length, columns = matrix[0].length;
        int start = 0;

        while (2 * start < rows && 2 * start < columns) {
            resultList.addAll(this.printCycleInMatrix(matrix, start, rows, columns));
            start++;
        }

        return resultList;
    }

    private ArrayList<Integer> printCycleInMatrix(int[][] matrix, int start, int rows, int columns) {
        int endX = rows - 1 - start, endY =columns - 1 - start;
        ArrayList<Integer> resultList = new ArrayList<>();

        // 从左到右打印一行
        for (int index = start; index <= endY; index++)
            resultList.add(matrix[start][index]);
        // 从上到下打印一列
        if (start < endX) {
            for (int index = start + 1; index <= endX; index++)
                resultList.add(matrix[index][endY]);
        }
        // 从右到左打印一行
        if (start < endY && start < endX) {
            for (int index = endY - 1; index >= start ; index--)
                resultList.add(matrix[endX][index]);
        }
        // 从下到上打印一行
        if (start < endX && start < endY) {
            for (int index = endX - 1; index > start; index--) {
                resultList.add(matrix[index][start]);
            }
        }

        return resultList;
    }
}
