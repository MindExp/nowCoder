package priv.algorithm.coding_interviews;

/**
 * 10.2 矩形覆盖
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 */
public class Question_10_2 {
    public static void main(String[] args) {
        Question_10_2 question_11 = new Question_10_2();
        int result = question_11.coverRectangleByRecursion(10);
        System.out.println(result);
        result = question_11.coverRectangleByNonRecursion(10);
        System.out.println(result);
    }

    /*
    覆盖方法：从待覆盖矩形左上角看起，每次选择覆盖方法由两种：
    1. 进行 2*1 覆盖，覆盖余下矩形区域 2*(n-1)
    2. 进行 1*2 覆盖，覆盖余下矩形区域 2*(n-1)
     */
    private int coverRectangleByRecursion(int n) {
        if (n < 1) {
            System.out.println("error input data.");
            // 错误输入标记
            return 0;
        }
        if (n <= 2)
            return n;

        int result = this.coverRectangleByRecursion(n-1) + this.coverRectangleByRecursion(n-2);

        return result;
    }

    private int coverRectangleByNonRecursion(int n) {
        if (n < 1) {
            System.out.println("error input data.");
            // 错误输入标记
            return 0;
        }
        if (n <= 2)
            return n;
        int pre1 = 1, pre2 = 2, result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }

        return result;
    }
}
