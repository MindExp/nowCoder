package priv.algorithm.sorting;

public class QuickSort extends AbstractSort{
    @Override
    public void sort(int[] array) {
        if (array == null) {
            this.invalidData = true;
            return;
        }
        this.quickSortAction(array, 0, array.length - 1);
    }

    private boolean invalidData = false;

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
}
