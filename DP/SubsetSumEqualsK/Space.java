package DP.SubsetSumEqualsK;

public class Space {

    public static boolean subset(int[] arr, int k) {
        int n = arr.length;
        
        boolean [] prev = new boolean[k+1];
        prev[0] = true;

        if(arr[0] <= k){
        prev[arr[0]] = true;
        }

        
        for (int i = 1; i < n; i++) {
            boolean [] curr = new boolean[k+1];
            curr[0] = true;
        
            for (int target = 1; target <= k; target++) {
                boolean notTake = prev[target];

                boolean take = false;
                if (target >= arr[i]) {
                    take = prev[target - arr[i]];
                }
                curr[target] = take || notTake;
            }
            prev =curr;
        }
        return prev[k];
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