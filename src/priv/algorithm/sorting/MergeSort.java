package priv.algorithm.sorting;

public class MergeSort extends AbstractSort {
    @Override
    public void sort(int[] array) {
        this.down2upMergeSort(array);
        // this.up2downMergeSort(array, 0, array.length - 1);
    }

    private boolean invalidData = false;

    /**
     * 自底向上归并
     * @param array
     */
    private void down2upMergeSort(int[] array) {
        if (array == null) {
            this.invalidData = true;
            return;
        }
        int arrayLength = array.length;
        for (int mergeSize = 1; mergeSize < arrayLength; mergeSize += mergeSize) {
            for (int left = 0; left < arrayLength - mergeSize; left += 2 * mergeSize) {
                int right = Math.min(arrayLength - 1, left + 2 * mergeSize - 1), middle = left + mergeSize - 1;
                this.merge(array, left, middle, right);
            }
        }
    }
    /**
     * 自上向下归并
     * @param array
     * @param left
     * @param right
     */
    private void up2downMergeSort(int[] array, int left, int right) {
        if (array == null || left > right || left < 0 || right > array.length - 1) {
            this.invalidData = true;
            return;
        }
        if (array.length == 0 || left == right)
            return;

        int middle = (left + right) / 2;

        this.up2downMergeSort(array, left, middle);
        this.up2downMergeSort(array, middle + 1, right);
        this.merge(array, left, middle, right);
    }

    /**
     * 归并有序子数组
     * @param array
     * @param left
     * @param middle
     * @param right
     */
    public void merge(int[] array, int left, int middle, int right) {
        if (array == null || left > middle || middle > right || left < 0 || right > array.length - 1)
            return;
        // 创建辅组数组
        int[] tempArray = new int[right - left + 1];
        for (int i = 0, j = left; j <= right; i++, j++)
            tempArray[i] = array[j];

        int arrayIndex = left, tempLeft = left - left, tempMiddle = middle - left, tempRight = right - left;
        int leftIndex = tempLeft, rightIndex = tempMiddle + 1;

        while (leftIndex <= tempMiddle || rightIndex <= tempRight) {
            array[arrayIndex++] = tempArray[leftIndex] <= tempArray[rightIndex] ? tempArray[leftIndex++] : tempArray[rightIndex++];

            while (leftIndex > tempMiddle && rightIndex <= tempRight)
                array[arrayIndex++] = tempArray[rightIndex++];
            while (rightIndex > tempRight && leftIndex <= tempMiddle)
                array[arrayIndex++] = tempArray[leftIndex++];
        }
    }
}
