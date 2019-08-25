package priv.algorithm.sorting;

public class Practice {
    public static void main(String[] args) {
        int[][] testInstances = {{3, 8, 4, 9, 0, 4, 2, 7, 5, 9, 6, 2, 2, 5}, {0, 3, 4, 9, 3, 4, 2, 3, 7, 2, 3, 4, 20, 12, 3, 0, 37, 2}, {12, 0, 84, 0, 2, 38, 51}};
        Practice practice = new Practice();
        for (int[] testInstance : testInstances) {
            practice.quickSort(testInstance);
            practice.printArray(testInstance);
        }
    }

    private boolean invalidData = false;

    private void quickSort(int[] array) {
        if (array == null) {
            this.invalidData = true;
            return;
        }
        this.quickSortAction(array, 0, array.length - 1);
    }
    // 三向切分快速排序：待掌握
    private void quickSortActionByThreeRoad(int[] array, int left, int right) {
        if (right <= left)
            return;

        int leftIndex = left, rightIndex = right, index = left + 1;
        int pivot = array[left];

    }

    /**
     * 快速排序
     * @param array
     * @param left
     * @param right
     */
    private void quickSortAction(int[] array, int left, int right) {
        if (left == right || left > right)
            return;
        int pivotIndex = this.partition(array, left, right);
        this.quickSortAction(array, left, pivotIndex - 1);
        this.quickSortAction(array, pivotIndex + 1, right);
    }

    /**
     * 获取快速排序支点
     * @param array
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] array, int left, int right) {
        int pivot = array[left];

        while (left < right) {
            while (left < right && array[right] >= pivot)
                right--;
            if (left < right)
                this.swap(array, left++, right);

            while (left < right && array[left] <= pivot)
                left++;
            if (left < right)
                this.swap(array, left, right--);
        }
        array[left] = pivot;

        return left;
    }

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

    private void up2downMergeSort(int[] array) {
        if (array == null || array.length == 0)
            return;
        this.up2downMergeSortAction(array, 0, array.length - 1);
    }
    /**
     * 自上向下归并
     * @param array
     * @param left
     * @param right
     */
    private void up2downMergeSortAction(int[] array, int left, int right) {
        if (array == null || left > right || left < 0 || right > array.length - 1) {
            this.invalidData = true;
            return;
        }
        if (array.length == 0 || left == right)
            return;

        int middle = (left + right) / 2;

        this.up2downMergeSortAction(array, left, middle);
        this.up2downMergeSortAction(array, middle + 1, right);
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

    /**
     * 选择排序
     * @param array
     */
    private void selectedSort(int[] array) {
        if (array == null || array.length == 0)
            return;

        int arrayLength = array.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            this.swap(array, i, minIndex);
        }
    }

    /**
     * 直接插入排序
     * @param array
     */
    private void insertSort(int[] array) {
        if (array == null || array.length == 0)
            return;

        int arrayLength = array.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = i + 1; j > 0 && array[j] < array[j - 1]; j--)
                this.swap(array, j, j - 1);
        }
    }

    /**
     * 冒泡排序
     * @param array
     */
    private void bubbleSort(int[] array) {
        if (array == null || array.length == 0)
            return;

        int arrayLength = array.length;
        boolean isSorted = false;

        for (int i = 0; i < arrayLength - 1 && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    this.swap(array, j, j + 1);
                    isSorted = false;
                }
            }
        }
    }

    /**
     * 交换元素
     * @param array
     * @param i
     * @param j
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 打印数组
     * @param array
     */
    private void printArray(int[] array) {
        if (array == null || array.length == 0)
            return;

        int arrayLength = array.length;
        System.out.print(array[0]);
        for (int index = 1; index < arrayLength; index++)
            System.out.print(" " + array[index]);
        System.out.println();
    }
}
