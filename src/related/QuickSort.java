package related;

/**
 * 快速排序类
 * @author Bruce He
 * @date 2018.9.28
 */
class QuickSort {
    private int[] numbers;
    private int length;

    /**
     * 对数组 numbers 进行排序
     * @param numbers
     */
    public void sort(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return;

        this.numbers = numbers;
        this.length = numbers.length;

        quickSort(0, this.length - 1);
    }

    /**
     *快速排序具体实现
     * @param low
     * @param high
     */
    private void quickSort(int low, int high) {
        int baseLine = this.numbers[low];  // 快排比较基准值
        int i=low, j=high;

        while (i < j) {
            while (this.numbers[j] >= baseLine && i < j )
                j--;
            if (i < j){
                this.swapValue(i++, j);
                baseLine = this.numbers[j];
            }

            while (this.numbers[i] <= baseLine && i < j)
                i++;
            if (i < j) {
                this.swapValue(i, j--);
                baseLine = this.numbers[i];
            }
        }
        if (low < j)
            quickSort(low, --j);
        if (i < high)
            quickSort(++i, high);
    }

    private void swapValue(int i, int j) {
        int temp = this.numbers[i];
        this.numbers[i] = this.numbers[j];
        this.numbers[j] = temp;
    }
}
