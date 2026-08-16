package DP.HouseRobber;
import java.util.*;
public class Tabulation {

    public static int solve(int index,int [] nums,int [] dp){
        if(index == 0){
            return nums[0];
        }

        if(index < 0){
            return 0;
        }
        int n = nums.length - 1;

        dp[0] = nums[0];

        for(int i = 1;i <= n;i++){

        int pick = nums[i];
        if(i > 1){
            pick+= dp[i-2];
        }
        int nonPick = dp[i-1];

        dp[i] = Math.max(pick,nonPick);
        }

        return dp[n];
    }
    public static void main(String [] args){
        int [] nums = {2,7,9,3,1};
        int n = nums.length - 1;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(solve(n,nums,dp));
    }
}
