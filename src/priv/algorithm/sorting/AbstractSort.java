package priv.algorithm.sorting;

public abstract class AbstractSort {
    public abstract void sort(int[] array);

    protected boolean less(int m, int n) {
        return m < n;
    }

    protected void printArray(int[] array) {
        if (array == null || array.length == 0)
            return;

        int arrayLength = array.length;
        System.out.print(array[0]);
        for (int index = 1; index < arrayLength; index++)
            System.out.print(" " + array[index]);
        System.out.println();
    }

    protected void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
