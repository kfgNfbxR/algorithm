package org.example;

import java.util.Arrays;

/**
 * @author mouxh 2021/2/20 14:26
 */
public class 堆排序 {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
//        int[] nums = new int[]{123, 4343, 2, 47, 8, 99, 12, 43356, 74, 3, 543212};
//        heapify(nums);
//        System.out.println(Arrays.toString(nums));
//        for (int i = nums.length - 1; i > 0; i--) {
//            swap(nums, 0, i);
//            siftDown(nums, 0, i - 1);
//        }
//        System.out.println(Arrays.toString(nums));
        System.out.println(Integer.toBinaryString(tableSizeFor(3)));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * 原地建堆，从最后一个父节点开始依次往下沉
     *
     * @param nums 数组
     */
    private static void heapify(int[] nums) {
        int lastParent = (nums.length - 2) / 2;
        for (; lastParent >= 0; lastParent--) { //从最后一个父节点一次下沉
            siftDown(nums, lastParent, nums.length - 1);
        }
    }

    /**
     * 元素下沉
     *
     * @param nums   数组
     * @param parent 需要下沉的父节点
     * @param end    终止元素的位置
     */
    private static void siftDown(int[] nums, int parent, int end) {
        while (parent <= end) {
            int leftChild = parent * 2 + 1; //左节点
            int rightChild = parent * 2 + 2; //右节点
            int pVal = nums[parent]; //父节点的值
            if (leftChild < end) { //存在右节点
                int p = nums[leftChild] >= nums[rightChild] ? leftChild : rightChild; //选取左右节点中值最大的节点
                if (pVal < nums[p]) { //如果父节点小于其任意子节点则交换
                    swap(nums, parent, p);
                    parent = p; //父节点再次尝试下沉
                    continue;
                }
            } else if (leftChild == end) { //仅存在左节点
                int leftVal = nums[leftChild];
                if (pVal < leftVal) { //如果左节点大于父节点则下沉父节点
                    swap(nums, parent, leftChild);
                }
            }
            return; //parent已经是最后一个节点或者父节点大于左右子节点则不处理直接返回
        }
    }

    /**
     * 交换元素
     *
     * @param nums 数组列表
     * @param i    i
     * @param j    j
     */
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
