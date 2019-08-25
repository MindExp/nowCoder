package priv.algorithm.sorting;

public class SelectedSort extends AbstractSort {
    @Override
    public void sort(int[] array) {
        int arrayLength = array.length;

        for (int i = 0; i < arrayLength - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (less(array[j], array[minIndex]))
                    minIndex = j;
            }
            swap(array, i, minIndex);
        }
    }
}
