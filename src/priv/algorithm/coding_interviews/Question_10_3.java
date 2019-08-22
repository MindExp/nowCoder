package priv.algorithm.coding_interviews;

/**
 * 10.3 跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 测试用例：n = -3, n = 0, n = 1, n = 5
 */
public class Question_10_3 {
    public static void main(String[] args) {
        int[] testInstanceStairs = {-3, 0, 1, 5};
        Question_10_3 question_10_3 = new Question_10_3();

        for (int stairs: testInstanceStairs){
            System.out.println(question_10_3.countJumpMethodsRecursion(stairs));
            System.out.println(question_10_3.countJumpMethodsNonRecursion(stairs));
        }
    }

    private int countJumpMethodsRecursion(int stairs) {
        if (stairs < 0){
            System.out.println("error input data.");
            return 0;
        }
        if (stairs <= 2)
            return stairs;
        int result = this.countJumpMethodsRecursion(stairs - 1) + this.countJumpMethodsRecursion(stairs - 2);
        return result;
    }

    private int countJumpMethodsNonRecursion(int stairs) {
        if (stairs < 0){
            System.out.println("error input data.");
            return 0;
        }
        if (stairs <= 2)
            return stairs;

        int result = 0, pre1 = 1, pre2 = 2;
        for (int stair = 3; stair <= stairs; stair++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
