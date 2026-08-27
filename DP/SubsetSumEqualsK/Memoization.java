package DP.SubsetSumEqualsK;
import java.util.*;

public class Memoization{

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
            notTake = subset(arr,idx-1,target-arr[idx],dp);
        }

        return dp[idx][target] = notTake || Take;
      
    }
    public static void main(String[] args){

        int [] arr = {1,2,3,4};
        int k = 5;

        int n = arr.length;

        Boolean [][] dp = new Boolean[n][k+1];

        boolean result = subset(arr,arr.length-1,k,dp);

        if(result){
            System.out.println("Yes subsequence exists");
        }
        else{
            System.out.println("No subsequence exists");
        }

    }
}