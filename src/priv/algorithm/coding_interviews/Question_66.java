package priv.algorithm.coding_interviews;

/**
 * 66. 构建乘积数组
 * 给定一个数组 A[0, 1,..., n-1]，请构建一个数组 B[0, 1,..., n-1]，其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。要求不能使用除法。
 */
public class Question_66 {
    public static void main(String[] args) {
        int[][] testInstances = {{1, 2, 3, 4, 5, 6}, {2, 4, 6, 8}};
        Question_66 question_66 = new Question_66();

        for (int[] testInstance : testInstances) {
            int[] target = question_66.multiply(testInstance);
            question_66.printArray(target);
        }
    }

    /**
     * 从前向后扫描与从后向前扫描
     * @param A
     * @return
     */
    private int[] multiply(int[] A) {
        int ALength = A.length;
        int[] B = new int[ALength];

        for (int i = 0, product = 1; i < ALength; i++) {
            B[i] = product;
            product *= A[i];
        }

        for (int j = ALength - 1, product = 1; j >= 0; j--) {
            B[j] *= product;
            product *= A[j];
        }

        return B;
    }

    private void printArray(int[] array) {
        if (array == null)
            return;

        for (int num : array)
            System.out.print(num + " ");
        System.out.println();
    }
}
