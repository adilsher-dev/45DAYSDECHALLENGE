package DP.SubsetSumEqualsK;

public class Tabulation {

    public static boolean subset(int[] arr, int k) {
        int n = arr.length;
        // Primitive boolean array defaults all values to false
        boolean[][] dp = new boolean[n][k + 1];

        // Base Case 1: Target = 0 is always achievable (empty set)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base Case 2: Target equal to first element
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill DP table iteratively
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[i - 1][target];

                boolean take = false;
                if (target >= arr[i]) {
                    take = dp[i - 1][target - arr[i]];
                }

                dp[i][target] = take || notTake;
            }
        }

        return dp[n - 1][k];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 5;

        boolean result = subset(arr, k);

        if (result) {
            System.out.println("Yes subsequence exists");
        } else {
            System.out.println("No subsequence exists");
        }
    }
}