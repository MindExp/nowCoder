package priv.algorithm.coding_interviews;

/**
 * 64. 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Question_64 {
    public static void main(String[] args) {
        int[] testInstances = {1, 2, 3, 4, 5, 100};
        Question_64 question_64 = new Question_64();

        for (int testInstance : testInstances) {
            int reuslt = question_64.solutionV1(testInstance);
            System.out.println(reuslt);
        }
    }

    private int solutionV2(int n) {
        int sum = n;
        boolean temp = n > 0 && (sum += this.solutionV2(n - 1)) > 0;

        return sum;
    }
    // 错误方案
    private int solutionV1(int n) {
        if (n <= 0)
            return 0;

        counterV1[] counter = new counterV1[20];

        return counterV1.getSum();
    }
}

class counterV1 {
    private static int sum = 0;

    public counterV1() {
        counterV1.sum += 1;
    }

    public static int getSum() {
        return sum;
    }
}
