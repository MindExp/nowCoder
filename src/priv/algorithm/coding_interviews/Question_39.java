package priv.algorithm.coding_interviews;

/**
 * 39. 数组中出现次数超过一半的数字
 *
 */
public class Question_39 {
    public static void main(String[] args) {
        int[][] testInstances = {{1, 2, 3, 4, 5, 3, 3, 3, 3, 3, 3, 5}, {1, 2, 2}, {1, 2, 3, 2, 4, 2, 5, 2, 3}};

        Question_39 question_39 = new Question_39();
        for (int[] testInstance : testInstances)
            System.out.println(question_39.findConditionalNumber(testInstance));
    }

    // 多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)
    private int findConditionalNumberByCounting(int[] numbers) {
        int targetIndex = 0, count = 1;

        for (int index = targetIndex + 1; index < numbers.length; index++) {
            count = numbers[index] == numbers[targetIndex] ? count + 1 : count - 1;

            if (count == 0) {
                targetIndex = index;
                count++;
            }
        }

        count = 0;
        for (int number : numbers)
            if (number == numbers[targetIndex])
                count++;

        return 2 * count > numbers.length ? numbers[targetIndex] : 0;
    }

    // 使用快速排序方法查找第 k 大数字，时间复杂度为 O(N)
    private int findConditionalNumber(int[] numbers) {
        if (numbers == null) {
            System.out.println("error input data.");
            return 0;
        }

        int start = 0, end = numbers.length - 1;
        int target, targetIndex = (numbers.length - 1) / 2;

        int index = this.partition(numbers, start, end);
        while (index != targetIndex) {
            if (index < targetIndex)
                index = this.partition(numbers, index + 1, end);
            else
                index = this.partition(numbers, start, index - 1);
        }
        target = numbers[targetIndex];

        if (!checkCondition(numbers, target)) {
            System.out.println("error input data.");
            return 0;
        }

        return target;
    }

    private int partition(int[] numbers, int start, int end) {
        if (start > end) {
            System.out.println("error input data.");
            return 0;
        }

        int pivot = numbers[start];

        while (start < end) {
            while (start < end && pivot <= numbers[end])
                end--;
            if (start < end)
                numbers[start++] = numbers[end];
            while (start < end && pivot >= numbers[start])
                start++;
            if (start < end)
                numbers[end--] = numbers[start];
        }

        numbers[start] = pivot;

        return start;
    }

    private boolean checkCondition(int[] numbers, int target) {
        int total = numbers.length, count = 0;
        boolean validInputData = false;

        for (int number : numbers) {
            if (number == target)
                count++;
        }
        if (2 * count > total)
            validInputData = true;

        return validInputData;
    }
}
