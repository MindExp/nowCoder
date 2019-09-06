package priv.algorithm.DP;

import java.util.Scanner;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯，需要 n 阶你才能到达楼顶，每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Question_70 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question_70 question_70 = new Question_70();

        while (sc.hasNext()) {
            int stairs = sc.nextInt();
            int result = question_70.climbStairs(0, stairs);
            System.out.println(result);
        }
    }

    private boolean inValidData = false;

    /**
     * 动态规划：dp[i] = dp[i - 1] + dp[i - 2]
     * @param stairs
     * @return
     */
    private int climbStairs(int stairs) {
        if (stairs < 0)
            this.inValidData = true;
        if (stairs <= 2)
            return stairs;

        int pre2 = 1, pre1 = 2, result = 0;

        for (int stair = 2; stair < stairs; stair++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    /**
     * 递归解法
     * @param stairs
     * @return
     */
    private int climbStairs(int stair, int stairs) {
        if (stair == stairs)
            return 1;
        if (stair > stairs)
            return 0;

        int result = this.climbStairs(stair + 1, stairs) + this.climbStairs(stair + 2, stairs);
        return result;
    }
}
