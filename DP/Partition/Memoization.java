package DP.Partition;

public class Memoization{

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

        Boolean [][] dp = new Boolean[n][TARGET + 1];

        return subset(arr,n-1,TARGET,dp);
    }

    public static boolean subset(int [] arr,int idx,int target,Boolean [][] dp){

        if(target == 0){
            return true;
        }
        if(idx == 0){
            return arr[0] == target;
        }

        if(dp[idx][target] != null){
            return dp[idx][target];
        }

        boolean notTake = subset(arr,idx-1,target,dp);

        boolean Take = false;
        if(target >= arr[idx]){
            Take = subset(arr,idx-1,target-arr[idx],dp);
        }

        return dp[idx][target] =Take || notTake;
      
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