package org.example;

/**
 * @author mouxh 2021/3/9 13:42
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(a, 1));

    }

    private static int binarySearch(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            mid = (end + start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            mid = (end + start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

}
