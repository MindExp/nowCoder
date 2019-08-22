package priv.algorithm.coding_interviews;

/**
 * 10.4 变态跳台阶
 *一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 测试用例：n = -3, n = 0, n = 1, n = 5
 */
public class Question_10_4 {
    public static void main(String[] args) {
        int[] testInstanceStairs = {-3, 0, 1, 5};
        Question_10_4 question_10_4 = new Question_10_4();

        for (int stairs: testInstanceStairs){
            System.out.println(question_10_4.countJumpChoices(stairs));
        }
    }

    /*
    f(n) = f(n-1) + f(n-2) + ... + f(0)
    f(n-1) = f(n-2) + ... + f(0)
    故：f(n) = 2 * f(n-1)
     */
    private int countJumpChoices(int stairs) {
        if (stairs < 0){
            System.out.println("error input data.");
            return 0;
        }
        if (stairs <= 2)
            return stairs;

        int result = 0, pre1 = 2, stair = 3;
        while (stair ++ <= stairs){
            result = 2 * pre1;
            pre1 = result;
        }

        return result;
    }
}
