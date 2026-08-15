package DP.ClimibingStairs;

import java.util.Arrays;

public class Memoization {

    public static int solve(int index, int[] dp) {

        // Base cases
        if (index == 0) {
            return 1;
        }

        if (index == 1) {
            return 1;
        }

        // If already calculated, return stored answer
        if (dp[index] != -1) {
            return dp[index];
        }

        // Calculate
        int left = solve(index - 1, dp);
        int right = solve(index - 2, dp);

        // Store the answer
        dp[index] = left + right;

        return dp[index];
    }

    public static void main(String[] args) {

        int n = 5;

        int[] dp = new int[n + 1];

        // Fill array with -1
        Arrays.fill(dp, -1);

        int ans = solve(n, dp);

        System.out.println(ans);
    }
}