package DP.ClimibingStairs;

public class SpaceOptimization {

    public static int solve(int n) {

        // Base cases
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        // Previous two values
        int prev2 = 1;  // dp[0]
        int prev1 = 1;  // dp[1]

        // Calculate from 2 to n
        for (int i = 2; i <= n; i++) {

            int curr = prev1 + prev2;

            // Move forward
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {

        int n = 5;

        int ans = solve(n);

        System.out.println(ans);
    }
}