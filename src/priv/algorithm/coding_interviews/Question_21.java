package priv.algorithm.coding_interviews;

/**
 * 21. 调整数组顺序使奇数位于偶数前面
 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样。
 */
public class Question_21 {
    public static void main(String[] args) {

    }

    /*
    时间复杂度O(n), 空间复杂度O(n)
     */
    private void reOrderArray(int[] nums) {
        int oddCount = 0, index = 0;
        int[] copyNums = nums.clone();

        for (int num : nums)
            if (!this.isEven(num))
                oddCount++;

        for (int copyNum : copyNums)
            if (this.isEven(copyNum))
                nums[oddCount++] = copyNum;
            else
                nums[index++] = copyNum;
    }

    /*
    冒泡法时间换空间：时间复杂度O(n**2)，空间复杂度O(1)
     */
    private void reOrderArrayByBubble(int[] nums) {
        boolean changeIten = false;

        for (int epoch = 1 ; epoch < nums.length; epoch++) {
            for (int index = 0; index < nums.length - epoch; index++) {
                if (this.isEven(nums[index]) && !this.isEven(nums[index + 1])) {
                    this.swapItem(nums, index, index + 1);
                    changeIten = true;
                }
            }
            if (!changeIten)
                break;
        }
    }

    private boolean isEven(int n) {
        return n % 2 == 0;
    }

    private void swapItem(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
