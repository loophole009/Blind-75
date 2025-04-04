package org.example.array;

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate {
    /**
     * Given an integer array `nums`, return true if any value appears at least twice in the array, and false otherwise.
     *
     * @param nums The input integer array.
     * @return True if there are duplicates, false otherwise.
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false; // Edge case: Array too short to have duplicates.
        }

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Found a duplicate
            }
            seen.add(num); // Add the current number to the set
        }

        return false; // No duplicates found
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test Case 1: " + cd.containsDuplicate(nums1)); // Expected true

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test Case 2: " + cd.containsDuplicate(nums2)); // Expected false

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Test Case 3: " + cd.containsDuplicate(nums3)); // Expected true

        int[] nums4 = {}; // Edge case
        System.out.println("Test Case 4: " + cd.containsDuplicate(nums4)); //Expected false

        int[] nums5 = {1}; //Edge case
        System.out.println("Test Case 5: " + cd.containsDuplicate(nums5)); //Expected false
    }
}

