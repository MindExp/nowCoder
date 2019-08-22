package priv.algorithm.coding_interviews;

/**
 * 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *
 * 测试用例：{4, 6, 8, 9, 2, 3, 4}, {1, 2, 3, 4}, {4, 4, 1, 4, 4, 4, 4}, {4, 4, 4, 4, 4, 1, 4}
 */
public class Question_11 {
    public static void main(String[] args) {
        int[][] testInstance = {{4, 6, 8, 9, 2, 3, 4}, {1, 2, 3, 4}, {4, 4, 1, 4, 4, 4, 4}, {4, 4, 4, 4, 4, 1, 4}};
        Question_11 question_11 = new Question_11();

        for (int[] test: testInstance) {
            System.out.println(question_11.findMinimumElement(test, 0, test.length - 1));
            System.out.println(question_11.findMinimumElement(test));
        }
    }

    private int findMinimumElement(int[] reversedArray, int start, int end) {
        if (reversedArray == null || start < 0 || end < 0 || start > end) {
            System.out.println("error input data.");
            return -1;
        }
        if (start == end)
            return reversedArray[start];

        int mininum;
        int middle = (start + end) / 2;

        if (reversedArray[middle] > reversedArray[end])
            mininum = this.findMinimumElement(reversedArray, middle + 1, end);
        else if (reversedArray[middle] < reversedArray[end])
            mininum = this.findMinimumElement(reversedArray, start, middle);
        else {
            int mininumLeft = this.findMinimumElement(reversedArray, start, middle);
            int mininumRight = this.findMinimumElement(reversedArray, middle + 1, end);

            if (mininumLeft < mininumRight)
                mininum = mininumLeft;
            else
                mininum = mininumRight;
        }

        return mininum;
    }

    private int findMinimumElement(int[] reversedArray) {
        int mininum, middle;
        int start = 0, end = reversedArray.length - 1;

        while (start < end) {
            middle = (start + end) / 2;

            if (reversedArray[middle] == reversedArray[end] && reversedArray[middle] == reversedArray[start]){
                mininum = this.findMininumElementByLinearSearch(reversedArray, start, end);
                return mininum;
            }else if (reversedArray[middle] > reversedArray[end])
                start = middle + 1;
            else if (reversedArray[middle] <= reversedArray[end])
                end = middle;
        }
        mininum = reversedArray[start];

        return mininum;
    }

    private int findMininumElementByLinearSearch(int[] array, int start, int end) {
        int mininum = array[start];

        while (++start <= end) {
            if (array[start] < mininum)
                mininum = array[start];
        }

        return mininum;
    }
}
