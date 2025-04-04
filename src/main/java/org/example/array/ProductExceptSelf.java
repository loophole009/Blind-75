package org.example.array;

class ProductExceptSelf {
    /**
     * Given an integer array `nums`, return a new array where each element is the product of all other elements except itself.
     * You must solve this problem without using division.
     *
     * @param nums The input integer array.
     * @return A new array with the products calculated for each element.
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null; // Edge case: Need at least two elements.
        }

        int n = nums.length;
        int[] result = new int[n];

        // Calculate prefix products
        int prefixProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        // Calculate postfix products and multiply with existing values in result array.
        int postfixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfixProduct;
            postfixProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf pes = new ProductExceptSelf();
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = pes.productExceptSelf(nums1);
        System.out.print("Test Case 1: ");
        for (int num : result1) {
            System.out.print(num + " "); // Expected 24 12 8 6
        }
        System.out.println();

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = pes.productExceptSelf(nums2);
        System.out.print("Test Case 2: ");
        for (int num : result2) {
            System.out.print(num + " "); // Expected 0 0 9 0 0
        }
        System.out.println();

        int[] nums3 = {1,0}; //Edge case
        int[] result3 = pes.productExceptSelf(nums3);
        System.out.print("Test Case 3: ");
        for (int num : result3) {
            System.out.print(num + " "); // Expected 0 1
        }
        System.out.println();

    }
}

