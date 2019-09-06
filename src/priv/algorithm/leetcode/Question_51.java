package priv.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 51. n 皇后
 * 如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class Question_51 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            Question_51 question_51 = new Question_51();

            question_51.solveNQueues(n);
            System.out.println(question_51.counter);
            // question_51.printSolutions();
        }
    }

    private int maxQueue;
    private int[] queueArray;
    private int counter = 0;
    private ArrayList<ArrayList<String>> resultList = new ArrayList<>();

    private void solveNQueues(int n) {
        this.maxQueue = n;
        queueArray = new int[this.maxQueue];

        // 起点
        this.solution(0);
    }

    /**
     *
     * @param currentQueue 代表当前第 currentQueue 个皇后
     */
    private void solution(int currentQueue) {
        if (currentQueue == this.maxQueue) {
            this.counter++;
            this.addSolution();
            return;
        }

        // 确定第 currentQueue 个皇后放置位置
        for (int column = 0; column < this.maxQueue; column++) {
            this.queueArray[currentQueue] = column;

            if (!this.conflict(currentQueue))
                this.solution(currentQueue + 1);
        }
    }

    private boolean conflict(int currentQueue) {
        for (int preQueue = 0; preQueue < currentQueue; preQueue++) {
            // 列冲突
            boolean columnConflict = (queueArray[preQueue] == queueArray[currentQueue] );
            // 正斜角冲突
            boolean conflictOne = (preQueue - this.queueArray[preQueue] == currentQueue - this.queueArray[currentQueue]);
            // 反斜角冲突
            boolean conflictTwo = (preQueue + this.queueArray[preQueue] == currentQueue + this.queueArray[currentQueue]);

            if (columnConflict || conflictOne || conflictTwo)
                return true;
        }
        return false;
    }

    private void addSolution() {
        ArrayList<String> result = new ArrayList<>();

        for (int queue = 0; queue < this.maxQueue; queue++) {
            int position = this.queueArray[queue];
            StringBuffer str = new StringBuffer("\"....\"\n");
            str.setCharAt(position + 1, 'Q');
            result.add(str.toString());
        }
        this.resultList.add(result);
    }

    private void printSolutions() {
        System.out.print("[");
        for (ArrayList<String> solution : this.resultList) {
            System.out.println(solution);
        }
        System.out.println("]");
    }
}
