package org.example.array;

class BestTimeToBuyAndSellStock {
    /**
     * Given an array of stock prices `prices`, find the maximum profit that you can make by buying and selling one share of stock.
     *
     * @param prices The array of stock prices.
     * @return The maximum profit. Returns 0 if no profit can be made.
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // Edge case: Need at least two days to buy and sell.
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // Update minimum buying price
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice; // Update maximum profit
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bs = new BestTimeToBuyAndSellStock();
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test Case 1: " + bs.maxProfit(prices1)); // Expected 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test Case 2: " + bs.maxProfit(prices2)); // Expected 0

        int[] prices3 = {2, 4, 1};
        System.out.println("Test Case 3: " + bs.maxProfit(prices3)); // Expected 2

        int[] prices4 = {}; // Edge case
        System.out.println("Test Case 4: " + bs.maxProfit(prices4)); //Expected 0
    }
}

