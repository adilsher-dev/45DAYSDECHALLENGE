package DP.ClimibingStairs;

public class Tabulation {

    public static int solve(int n) {

        // Base cases
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        // DP array
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        // Fill the table from bottom to top
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5;

        int ans = solve(n);

        System.out.println(ans);
    }
}