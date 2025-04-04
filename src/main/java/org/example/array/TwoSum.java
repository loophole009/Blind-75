package org.example.array;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    /**
     * Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers that add up to the target. Returns null if no such pair exists.
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null; // Handle edge case: array too short
        }

        Map<Integer, Integer> numMap = new HashMap<>(); // Store number -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }

            numMap.put(nums[i], i); // Store current number and its index
        }

        return null; // No solution found
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();

        // Test cases
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = ts.twoSum(nums1, target1);
        System.out.println("Test Case 1: " + (result1 != null ? "[" + result1[0] + ", " + result1[1] + "]" : "null"));  // Expected [0, 1]

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = ts.twoSum(nums2, target2);
        System.out.println("Test Case 2: " + (result2 != null ? "[" + result2[0] + ", " + result2[1] + "]" : "null"));  // Expected [1, 2]

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = ts.twoSum(nums3, target3);
        System.out.println("Test Case 3: " + (result3 != null ? "[" + result3[0] + ", " + result3[1] + "]" : "null"));  // Expected [0, 1]

        int[] nums4 = {1}; // Edge case
        int target4 = 2;
        int[] result4 = ts.twoSum(nums4, target4);
        System.out.println("Test Case 4: " + (result4 != null ? "[" + result4[0] + ", " + result4[1] + "]" : "null")); // Expected null

        int[] nums5 = {}; // Edge case
        int target5 = 2;
        int[] result5 = ts.twoSum(nums5, target5);
        System.out.println("Test Case 5: " + (result5 != null ? "[" + result5[0] + ", " + result5[1] + "]" : "null")); // Expected null

    }
}

