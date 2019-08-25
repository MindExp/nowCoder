package related;

import java.util.*;

/**
 * @author Bruce He
 * @date 2018.9.28
 */
class Solution {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        for (int i=0; i < nums.length; i++) {
            temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 在一个元素为 1 到 100 的整数数组中，如何搜索缺失元素？
     * @param nums
     */
    public static ArrayList findMissingElements(int[] nums, int count) {
        BitSet bitSet = new BitSet(count);

        for (int num : nums) {
            bitSet.set(num - 1);
        }

        System.out.println(bitSet.toString());

        ArrayList<Integer> missingElementsArrayList = new ArrayList<>();  // 保存缺失值数组
        int missingElement=0, missingCount=count - nums.length;

        for(int i=0; i < missingCount; i++) {
            missingElement = bitSet.nextClearBit(missingElement);  // 查找缺失元素
            missingElementsArrayList.add(++missingElement);  // 添加缺失元素
        }

        for (int i: missingElementsArrayList) {
            System.out.println(i);
        }

        return missingElementsArrayList;
    }

    /**
     * 给定一个数组，如何搜索重复元素？
     * @param nums
     * @param <Type> 使用泛型方法
     * @return
     */
    public static <Type> ArrayList findDuplicateElements(Type[] nums) {
        HashMap<Type, Integer> hashMap = new HashMap<>();
        ArrayList<Type> duplicateElementsArrayList = new ArrayList<>();

        Arrays.sort(nums);

        for (int i=0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) == null) {
                hashMap.put(nums[i], i);
                continue;
            }
            duplicateElementsArrayList.add(nums[i]);  // 添加重复元素
        }

        for (Type i : duplicateElementsArrayList)
            System.out.println(i);

        return duplicateElementsArrayList;
    }

    /**
     * 给定一个乱序数组，如何搜索最大和最小元素？
     * @param nums
     */
    public static void findMaxAndMinElement(int[] nums) {
        int max = 0, min = 0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] > nums[max])
                max = i;
            else if (nums[i] < nums[min])
                min = i;
        }
        System.out.println("Max:"  +nums[max] +"Min:"+ nums[min]);
    }

    /**
     * 给定一个数值，如何搜索整数数组中加和为该数值的成对元素？
     * @param nums
     * @param number
     */
    public static void findPairElementSumToNumber(int[] nums, int number) {

        /*
            HashMap不是线程安全的，而HashTable是线程安全的。
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Hashtable<Integer, Integer> pairElementsHashTable = new Hashtable<>();  // 保存 Pair Element
        int count = 0;

        for (int i =0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) != null) {
                count = hashMap.get(nums[i]).intValue();
                hashMap.put(nums[i], ++count);
            }
            else
                hashMap.put(nums[i], 1);
        }

        int elementOne, elementTwo;

        for (int i =0; i < nums.length; i++) {
            elementOne = nums[i];  // 第一个元素
            elementTwo = number - nums[i];  // 第二个元素

            boolean situationOne, situationTwo;
            situationOne = elementOne != elementTwo && hashMap.containsKey(elementTwo);
            situationTwo = elementOne == elementTwo && hashMap.get(elementOne) > 1;

            if (situationOne || situationTwo)
                pairElementsHashTable.put(elementOne, elementTwo);
        }

        for (int key : pairElementsHashTable.keySet()){
            System.out.println("("+ key + ", "+pairElementsHashTable.get(key) + ")");
        }
    }

    /**
     * 给定一个数组，如何用 Java 删除重复元素？如何在不使用库的情况下移除数组中的重复元素？
     * @param numbersWithDunplicates
     */
    public static int[] deleteDuplicateElemens(int[] numbersWithDunplicates) {
        int[] result = new int[numbersWithDunplicates.length];

        Arrays.sort(numbersWithDunplicates);
        if (numbersWithDunplicates.length > 0)
            result[0] = numbersWithDunplicates[0];

        for (int i=1, j = 0; i < numbersWithDunplicates.length; i++) {
            if (numbersWithDunplicates[i] != result[j])
                result[++j] = numbersWithDunplicates[i];
        }

        for (int i : result)
            System.out.println(i);
        return result;
    }

    /**
     * 如何使用快速排序算法对整数数组进行排序？
     */
    public static int[] quickSortForArray (int[] numbers) {
        new QuickSort().sort(numbers);
        return numbers;
    }

    /**
     * 如何使用 Java 反转一个数组？
     */
    public static void reverseAnArray (int[] numbers) {
        int temp, center = numbers.length / 2;

        for (int i=0; i <= center; i++) {
            temp = numbers[i];
            numbers[i] = numbers[numbers.length - i -1];
            numbers[numbers.length - i -1] = temp;
        }
    }

    /**
     * 寻找最长回文字符串
     * @param str
     */
    public static String findLongestPlalindromeString(String str) {
        StringBuffer handledStr = new StringBuffer();

        // 字符串预处理
        for (int i = 0; i < str.length(); i++) {
            handledStr.append(str.charAt(i));
            handledStr.append('#');
        }

        // 记录字符串中以字符为中心的最长回文字符串长度
        int[] psLength = new int[handledStr.length()];
        // 回文中心右侧边界
        int rightSideBoarder = 0;
        // 右侧边界回文中心
        int rightSideBoarderCenter = 0;
        // 最长回文字符串中心
        int longestCenter = 0;
        // 最长回文长度
        int longestSize = 0;


        // 寻找最长回文字符串
        for (int i = 0; i < handledStr.length(); i++) {
            // 是否需要中心扩展
            boolean needCenterExpandding = true;

            // 判断是否位于边界之内
            if (rightSideBoarder > i) {
                // 计算当前字符相对 rightSideBoarderCenter 对称位置
                int leftCenter = 2 * rightSideBoarderCenter - i;

                // 如果回文长度超过 rightSideBoarder 则需要对当前字符中心回文长度进行调整
                if (i + psLength[leftCenter] < rightSideBoarder) {
                    // 未超出右侧边界，则当前字符中心最长回文字符串长度为 psLength[leftCenter]
                    psLength[i] = psLength[leftCenter];
                    needCenterExpandding = false;
                } else
                    // 初始化最小回文长度
                    psLength[i] = rightSideBoarder - i;
            }
            // 进行中心扩展并更新右侧边界 rightSideBoarder 以及 右侧边界对应中心 rightSideBoarderCenter
            if (needCenterExpandding) {
                // 开始中心扩展
                while (i - psLength[i] - 1 >= 0 && i + psLength[i] + 1 < handledStr.length()) {
                    if (handledStr.charAt(i - psLength[i] - 1) == handledStr.charAt(i + psLength[i] + 1))
                        psLength[i]++;
                    else
                        break;
                }

                // 更新右侧边界 rightSideBoarder 以及 右侧边界对应中心 rightSideBoarderCenter
                rightSideBoarder = i + psLength[i];
                rightSideBoarderCenter = i;

                // 更新最长回文中心以及长度
                if (longestSize < psLength[i]) {
                    longestCenter = i;
                    longestSize = psLength[i];
                }
            }
        }

        // 去掉预处理添加的 '#' 字符
        StringBuffer sb = new StringBuffer();
        for (int i = longestCenter - longestSize; i <= longestCenter + longestSize; i++)
            if (handledStr.charAt(i) != '#')
                sb.append(handledStr.charAt(i));

        return sb.toString();
    }

    /**
     * 如何在一次传递中找到单链表的中间元素？
     */

}
