package org.example.array;

class SearchInRotatedSortedArray {
    /**
     * Given a sorted array that has been rotated, search for a target value.
     *
     * @param nums The input rotated sorted array.
     * @param target The target value to search for.
     * @return The index of the target if found; otherwise, return -1.
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1; // Edge case: Handle invalid input array.
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Found the target value!
            }

            // Determine which half of the array is sorted.
            if (nums[left] <= nums[mid]) { // Left half is sorted.
                if (target >= nums[left] && target < nums[mid]) {
                    // Target lies within the sorted left half.
                    right = mid - 1;
                } else {
                    // Target does not lie in the sorted left half. Search the right half.
                    left = mid + 1;
                }
            } else { // Right half is sorted.
                if (target > nums[mid] && target <= nums[right]) {
                    // Target lies within the sorted right half.
                    left = mid + 1;
                } else {
                    // Target does not lie in the sorted right half. Search the left half.
                    right = mid - 1;
                }
            }
        }

        return -1; // Target value not found.
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray srsa = new SearchInRotatedSortedArray();

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Test Case 1: " + srsa.search(nums1, 0)); // Expected 4

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Test Case 2: " + srsa.search(nums2, 3)); //Expected -1

        int[] nums3 = {1};
        System.out.println("Test Case 3: " + srsa.search(nums3, 0)); // Expected -1

        int[] nums4 = {5,1,3}; //Edge case
        System.out.println("Test Case 4: " + srsa.search(nums4, 5)); //Expected 0
    }
}

