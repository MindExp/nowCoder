package priv.algorithm.coding_interviews;

/**
 * 10.1 斐波那契数列
 * 求斐波那契数列的第 n 项，n <= 39。
 */
public class Question_10_1 {
    public static void main(String[] args) {
        Question_10_1 question_10_1 = new Question_10_1();
        int result = question_10_1.fibResursion(10);
        System.out.println(result);
        result = question_10_1.fibNonRecursion(10);
        System.out.println(result);
    }

    private int fibResursion(int n) {
        if (n < 0) {
            System.out.println("error input data");
            //返回错误输入标记 -1
            return -1;
        }

        if (n <= 1)
            return n;
        else
            return fibResursion(n - 1) + fibResursion(n - 2);
    }

    private int fibNonRecursion(int n) {
        int pre1 = 0, pre2 = 1, result = 0;
        if (n < 0) {
            System.out.println("error input data");
            //返回错误输入标记 -1
            return -1;
        }
        if (n <= 1)
            return n;

        for (int i = 2; i <= n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }

        return result;
    }
}
