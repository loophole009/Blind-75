package org.example.array;

class MaxProductSubArray {
    /**
     * Given an integer array `nums`, find the contiguous subarray with the largest product and return its product.
     *
     * @param nums The input integer array.
     * @return The maximum product.
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Edge case: Empty or null array.
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int tempMax = Math.max(current, Math.max(maxSoFar * current, minSoFar * current));
            minSoFar = Math.min(current, Math.min(maxSoFar * current, minSoFar * current));

            maxSoFar = tempMax;
            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxProductSubArray mp = new MaxProductSubArray();
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Test Case 1: " + mp.maxProduct(nums1)); // Expected 6

        int[] nums2 = {-2, 0, -1};
        System.out.println("Test Case 2: " + mp.maxProduct(nums2)); //Expected 0

        int[] nums3 = {2,-5,-2,-4,3};
        System.out.println("Test Case 3: " + mp.maxProduct(nums3)); // Expected 24

        int[] nums4 = {-1,-2,-9,-6}; //Edge case
        System.out.println("Test Case 4: " + mp.maxProduct(nums4)); //Expected 108
    }
}

