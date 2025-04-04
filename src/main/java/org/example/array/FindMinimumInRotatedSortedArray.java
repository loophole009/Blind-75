package org.example.array;

class FindMinimumInRotatedSortedArray {
    /**
     * Given a sorted and rotated array, find the minimum element.
     *
     * @param nums The input sorted and rotated array.
     * @return The minimum element.
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; // Edge case: Handle invalid input
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum element is in the right half
                left = mid + 1;
            } else {
                // Minimum element is in the left half or at mid
                right = mid;
            }
        }

        return nums[left]; // 'left' will point to the minimum element.
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray frmsa = new FindMinimumInRotatedSortedArray();
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Test Case 1: " + frmsa.findMin(nums1)); // Expected 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Test Case 2: " + frmsa.findMin(nums2)); //Expected 0

        int[] nums3 = {11, 13, 15, 17}; //Already sorted, edge case
        System.out.println("Test Case 3: " + frmsa.findMin(nums3)); // Expected 11
    }
}

