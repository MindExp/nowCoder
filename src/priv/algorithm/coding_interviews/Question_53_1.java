package priv.algorithm.coding_interviews;

/**
 * 53. 数字在排序数组中出现的次数
 */
public class Question_53_1 {
    public static void main(String[] args) {
        int[][] testInstances = {{2, 3, 4, 6, 6, 6, 6, 7, 7, 8}, {2, 2, 3, 3, 3, 5, 6, 6}};
        int[][] testTargets = {{2, 3, 4, 6, 7, 8, 1, 10}, {2, 3, 5, 6, 10}};
        int index = 0;
        Question_53_1 question_53_1 = new Question_53_1();

        for (int[] testInstance : testInstances) {
            for (int testTarget : testTargets[index]) {
                int firstIndex, lastIndex, result = 0;
                firstIndex = question_53_1.indexOfTarget(testInstance, testTarget, true);
                lastIndex = question_53_1.indexOfTarget(testInstance, testTarget, false);
                if (firstIndex > -1 && lastIndex > -1)
                    result = lastIndex - firstIndex + 1;
                System.out.println(result);
            }
            index++;
        }

    }

    private int indexOfTarget(int [] searchTree, int target, boolean firstTag) {
        if (searchTree == null || searchTree.length == 0)
            return -1;

        int searchTreeLength = searchTree.length;
        int left = 0, right = searchTreeLength - 1, middle;
        int index = -1;
        boolean firstTarget, lastTarget;

        while (left <= right) {
            middle = (left + right) / 2;
            if (searchTree[middle] == target) {
                if (firstTag) {
                    firstTarget = (middle == 0 || searchTree[middle - 1] < searchTree[middle]);
                    if (firstTarget) {
                        index = middle;
                        break;
                    } else
                        right = middle - 1;
                } else {
                    lastTarget = ((middle == searchTreeLength - 1) || searchTree[middle + 1] > searchTree[middle]);
                    if (lastTarget) {
                        index = middle;
                        break;
                    } else
                        left = middle + 1;
                }
            } else if (searchTree[middle] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return index;
    }
}
