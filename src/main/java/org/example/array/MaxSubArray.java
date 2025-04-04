package org.example.array;

class MaxSubArray {
    /**
     * Given an integer array `nums`, find the contiguous subarray with the largest sum and return its sum.
     *
     * @param nums The input integer array.
     * @return The maximum subarray sum.
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Edge case: Empty or null array
        }

        int currentMax = nums[0];
        int overallMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]); // Choose to start a new subarray or extend the existing one.
            overallMax = Math.max(overallMax, currentMax);      // Update overall maximum sum.
        }

        return overallMax;
    }

    public static void main(String[] args) {
        MaxSubArray ms = new MaxSubArray();
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test Case 1: " + ms.maxSubArray(nums1)); // Expected 6

        int[] nums2 = {1};
        System.out.println("Test Case 2: " + ms.maxSubArray(nums2)); // Expected 1

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Test Case 3: " + ms.maxSubArray(nums3)); //Expected 23

        int[] nums4 = {-1,-2}; //Edge case
        System.out.println("Test Case 4: " + ms.maxSubArray(nums4)); // Expected -1
    }
}

