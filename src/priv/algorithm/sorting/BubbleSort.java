package priv.algorithm.sorting;

public class BubbleSort extends AbstractSort {
    @Override
    public void sort(int[] array) {
        int arrayLength = array.length;

        for (int i = 0; i < arrayLength - 1; i++) {
            boolean swaped = false;

            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (less(array[j], array[j + 1])) {
                    swap(array, j, j + 1);
                    swaped = true;
                }
            }
            if (!swaped)
                break;
        }
    }

    /**
     * 掌握该方案
     * @param array
     */
    public void sortV1(int[] array) {
        if (array == null || array.length <= 1)
            return;

        int arrayLength = array.length;
        boolean isSorted = false;
        for (int i = 0; i < arrayLength - 1 && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    isSorted = false;
                    this.swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * V1 变体写法
     * @param array
     */
    protected void sortV2(int[] array) {
        int arrayLength = array.length;
        boolean isSorted = false;

        for (int i = arrayLength - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(array[j + 1], array[j])) {
                    isSorted = false;
                    swap(array, j, j + 1);
                }
            }
        }
    }

}
