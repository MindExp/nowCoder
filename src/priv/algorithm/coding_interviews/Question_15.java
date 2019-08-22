package priv.algorithm.coding_interviews;

/**
 * 15. 二进制中 1 的个数
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 *
 * 测试用例：(0, 0), (1, 1), (2, 1), (3, 2), (4, 1)
 */
public class Question_15 {
    public static void main(String[] args) {
        int[] testInstances = {0, 1, 2, 3, 4};
        int result;
        Question_15 question_15 = new Question_15();

        for (int testInstance: testInstances) {
            result = question_15.countOneInBinaryInteger(testInstance);
            System.out.println(result);
        }
    }

    /**
     * 使用位运算计算整数二进制中 1 的个数
     * @param n
     * @return
     */
    private int countOneInBinaryInteger (int n) {
        int result = 0;

        while (n != 0){
            result++;
            n = n & (n - 1);
        }

        return result;
    }
}
