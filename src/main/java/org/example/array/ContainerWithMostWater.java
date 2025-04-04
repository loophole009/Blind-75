package org.example.array;

class ContainerWithMostWater {

    /**
     * Finds the maximum amount of water that can be contained between two lines formed by elements in an array.
     *
     * @param heights The input array representing the heights of vertical lines.
     * @return The maximum area (amount of water) that can be contained.
     */
    public int maxArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0; // Edge case: Handle invalid input array.
        }

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the area between the two lines.
            int currentArea = Math.min(heights[left], heights[right]) * (right - left);

            // Update the maximum area if necessary.
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer that points to the shorter line towards the center.
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cw = new ContainerWithMostWater();

        int[] nums1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Test Case 1: " + cw.maxArea(nums1)); // Expected: 49

        int[] nums2 = {1, 1};
        System.out.println("Test Case 2: " + cw.maxArea(nums2)); // Expected: 1

        int[] nums3 = {4, 3, 2, 1, 4};
        System.out.println("Test Case 3: " + cw.maxArea(nums3)); // Expected: 16

        int[] nums4 = {1, 2, 1};
        System.out.println("Test Case 4: " + cw.maxArea(nums4)); //Expected : 2

        int[] nums5 = {10,8,3,7,6,9};
        System.out.println("Test case 5: "+cw.maxArea(nums5)); //Expected : 49

    }
}

