package priv.algorithm.coding_interviews;

/**
 * 4. 二维数组中的查找
 * 题目描述：给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *
 * 测试用例：{{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}}
 */
public class Question_4 {
    public static void main(String[] args) {
        int[][] testInstance = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};

        Question_4 question_4 = new Question_4();
        boolean found = false;
        found = question_4.findElementIn2DimensionalMatrix(testInstance, 5);
        System.out.println(found);
        found = question_4.findElementIn2DimensionalMatrix(testInstance, 20);
        System.out.println(found);
    }

    /**
     *
     * @param numbers
     * @return
     */
    public boolean findElementIn2DimensionalMatrix(int[][] numbers, int target) {
        boolean found = false;

        if (numbers ==null || numbers.length == 0)
            return false;

        int rows = numbers.length, colums = numbers[0].length;
        int row = 0, colum = colums - 1;

        while (row <= rows - 1 && colum >= 0) {
            if (numbers[row][colum] == target)
                return true;
            else if (numbers[row][colum] > target)
                colum--;
            else
                row++;
        }

        return found;
    }
}
