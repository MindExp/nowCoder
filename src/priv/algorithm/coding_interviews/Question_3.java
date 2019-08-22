package priv.algorithm.coding_interviews;

/**
 * 3. 数组中重复的数字
 * 题目描述：在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * 测试用例：{2, 3, 4, 5, 3, 3, 4, 6}, {1, 2, 3, 4}
 */
public class Question_3 {
    public static void main(String[] args) {
        int[][] testInstance = {{2, 3, 4, 5, 3, 3, 4, 6}, {1, 2, 3, 0}};

        Question_3 question_3 = new Question_3();

        for (int i = 0; i < testInstance.length; i++)
            System.out.println(question_3.findOneDuplicateElement(testInstance[i]));

    }

    /**
     *
     * @param number
     * @return
     */
    public int findOneDuplicateElement(int[] number) {
        // 若不存在重复元素则返回 -1 标记
        int index = 0, duplicateElemet = - 1;
        int length = number.length;
        int one;

        while (index != length) {
            one = number[index];
            if (one != index){
                if (number[one] != one){
                    this.swapElement(number, index, one);
                }else {
                    duplicateElemet = one;
                    break;
                }
            }else
                index++;
        }

        return duplicateElemet;
    }

    /**
     *
     * @param number
     * @param index_one
     * @param index_another
     */
    private void swapElement(int[] number, int index_one, int index_another) {
        int temp = number[index_one];
        number[index_one] = number[index_another];
        number[index_another] = temp;
    }
}