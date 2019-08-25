package priv.algorithm.sorting;

public class Main {
    public static void main(String[] args){
        int[][] testInstances = {{3, 8, 4, 9, 0, 4, 2, 7, 5, 9, 6, 2, 2, 5}, {0, 3, 4, 9, 3, 4, 2, 3, 7, 2, 3, 4, 20, 12, 3, 0, 37, 2}, {12, 0, 84, 0, 2, 38, 51}};
        BubbleSort bubbleSort = new BubbleSort();
        InsertSort insertSort = new InsertSort();
        SelectedSort selectedSort = new SelectedSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();

        for (int[] testInstance : testInstances) {
            quickSort.sort(testInstance);
            quickSort.printArray(testInstance);
        }
    }
}
