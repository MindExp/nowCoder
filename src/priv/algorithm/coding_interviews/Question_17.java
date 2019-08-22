package priv.algorithm.coding_interviews;

/**
 * 17. 打印从 1 到最大的 n 位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 * 大数问题
 * 测试用例：(3, 1-999), (10, 1-9999999999)，...
 */
public class Question_17 {
    public static void main(String[] args) {
        int[] testInstances = {3, 5, 20};
        Question_17 question_17 = new Question_17();
        for (int testInstance: testInstances)
            question_17.print1ToMaxOfNDigits(testInstance);
    }

    private void print1ToMaxOfNDigits(int n) {
        if (n < 0)
            return;
        char[] number = new char[n];
        this.print1ToMaxOfNDigits(number, 0);
    }

    // 使用递归实现回溯法打印
    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            this.printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[digit] = (char)(i + '0');
            this.print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number){
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
}
