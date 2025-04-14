package org.example.dp;

class ClimbingStairs {

    /**
     * Calculates the number of distinct ways to climb n stairs when you can take either 1 or 2 steps at a time.
     * Uses dynamic programming (Fibonacci sequence) for an efficient solution.
     * @param n The number of stairs.
     * @return The number of distinct ways to climb the stairs.
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();

        System.out.println("Test Case 1: " + cs.climbStairs(2)); // Expected: 2
        System.out.println("Test Case 2: " + cs.climbStairs(3)); // Expected: 3
        System.out.println("Test Case 3: " + cs.climbStairs(4)); // Expected: 5
    }

}

