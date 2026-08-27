package DP.PartitionMinDiff;

public class Tabulation {

    public static boolean[][] subset(int[] arr, int k) {
        int n = arr.length;
        
        boolean[][] dp = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }


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

        return dp;
    }

    public static int minDiff(int [] arr){

        int n = arr.length;
        int totalSum = 0;

        for(int num : arr){
            totalSum += num;
        }

        boolean [][] dp = subset(arr,totalSum);

        int minDiff = Integer.MAX_VALUE;

        for(int s1 = 0; s1 <= totalSum/2;s1++){
            if(dp[n-1][s1]){
                int s2 = totalSum - s1;
                minDiff = Math.min(minDiff,Math.abs(s2 - s1));
            }
        }
        return minDiff;

    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 7, 3};
        

        int result = minDiff(arr);

        System.out.println(result);
    }
}