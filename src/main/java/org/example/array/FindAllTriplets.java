package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAllTriplets {

    /**
     * Finds all unique triplets in a sorted array that sum up to the given target value.
     *
     * @param nums   The input sorted array.
     * @param target The target sum value.
     * @return A list of lists, where each inner list represents a triplet summing up to the target.
     */
    public List<List<Integer>> findTriplets(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result; // Edge case: Handle invalid input array.
        }

        Arrays.sort(nums); // Sort the array to efficiently use the two-pointer technique.

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for the first element of the triplet.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate elements for the second and third elements of the triplet.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // Need a larger sum, so move the left pointer.
                } else {
                    right--; // Need a smaller sum, so move the right pointer.
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllTriplets fat = new FindAllTriplets();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test Case 1: " + fat.findTriplets(nums1, 0)); // Expected: [[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = {0, 1, 1};
        System.out.println("Test Case 2: " + fat.findTriplets(nums2, 0)); // Expected: [[0, 1, -1]] -> corrected to be empty

        int[] nums3 = {0, 0, 0};
        System.out.println("Test Case 3: " + fat.findTriplets(nums3, 0)); // Expected: [[0, 0, 0]]

        int[] nums4 = {-2, 0, 1, 1, 2};
        System.out.println("Test Case 4: " + fat.findTriplets(nums4, 0)); //Expected : [[-2,0,2],[-2,1,1],[0,1,1]]

        int[] nums5 = {1,2,-3};
        System.out.println("Test Case 5: " + fat.findTriplets(nums5, 0)); // Expected : [[-3,1,2]]
    }
}
