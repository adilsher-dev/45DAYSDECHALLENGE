package DP.HouseRobber;
import java.util.*;
public class Memoization {

    public static int solve(int index,int [] nums,int [] dp){
        if(index == 0){
            return nums[0];
        }

        if(index < 0){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }


        int pick = nums[index] + solve(index - 2,nums,dp);
        int nonPick = solve(index-1,nums,dp);


        return dp[index] = Math.max(pick,nonPick);

    }
    public static void main(String [] args){
        int [] nums = {2,7,9,3,1};
        int n = nums.length - 1;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(solve(n,nums,dp));
    }
}
