package DP.Partition;

public class Tabulation{

    public static boolean partition(int [] arr){

        int n = arr.length;
        int sum = 0;

        for(int i = 0; i < n;i++){
            sum += arr[i];
        }

        if(sum % 2 != 0){
            return false;
        }
        int TARGET = sum/2;

        boolean [][] dp = new boolean[n][TARGET + 1];

        return subset(arr,TARGET,dp);
    }

    public static boolean subset(int [] arr,int k,boolean [][] dp){


        for(int i = 0; i < arr.length;i++){
            dp[i][0] = true;
        }

        if(arr[0] <= k){
            dp[0][arr[0]] = true;
        }

        for(int i = 1; i < arr.length;i++){
            for(int target = 1;target <= k;target++){
                
                boolean notTake = dp[i-1][target];
                boolean Take = false;
                if(target >= arr[i]){
                    Take = dp[i-1][target-arr[i]];
                }
                dp[i][target] = Take || notTake;
            }
        }

        return dp[arr.length-1][k];
      
    }
    public static void main(String[] args){

        int [] arr = {1,5,11,5};
        int n = arr.length;

        boolean result = partition(arr);

        if(result){
            System.out.println("Yes two subsequence exists");
        }
        else{
            System.out.println("No subsequence exists");
        }
    

    }
}