package priv.algorithm.leetcode;

import java.util.ArrayList;

/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class Question_54 {
    public static void main(String[] args) {
        int[][][] testInstances = {{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}}, {{10}, {11}, {12}}};
        Question_54 question_54 = new Question_54();

        for (int[][] testInstance : testInstances)
            for (Object item : question_54.printMatrixByClockWise(testInstance).toArray())
                System.out.println(((Integer)item).intValue());
    }

    private ArrayList<Integer> printMatrixByClockWise(int[][] matrix) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return resultList;

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
    /*
    java.lang.ArrayIndexOutOfBoundsException: 0
  at line 7, Solution.spiralOrder
  at line 54, __DriverSolution__.__helper__
  at line 79, __Driver__.main
     */
}
