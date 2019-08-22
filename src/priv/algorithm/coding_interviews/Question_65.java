package priv.algorithm.coding_interviews;

import java.util.Scanner;

/**
 * 65. 不用加减乘除做加法
 */
public class Question_65 {
    public static void main(String[] args) {
        Question_65 question_65 = new Question_65();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            System.out.println(question_65.addOperation(num1, num2));
        }
    }

    private int addOperation(int num1, int num2) {
        int sum;
        int carry;

        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while (carry != 0);

        return num1;
    }
}
