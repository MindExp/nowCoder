package priv.algorithm.sorting;

public class InsertSort extends AbstractSort {
    @Override
    public void sort(int[] array) {
        int arrayLength = array.length;

        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = i + 1; j > 0 && less(array[j], array[j - 1]); j--)
                swap(array, j, j - 1);
        }
    }
}
