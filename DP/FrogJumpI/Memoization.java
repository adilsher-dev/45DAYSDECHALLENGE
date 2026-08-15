package DP.FrogJumpI;
import java.util.*;

public class Memoization {

    public static int solve(int n,int [] height,int [] dp){
        if(n == 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int oneStep = solve(n-1,height,dp) + Math.abs(height[n] - height[n-1]);
        int twoStep = Integer.MAX_VALUE;

        if(n > 1){
            twoStep = solve(n-2,height,dp) + Math.abs(height[n] - height[n-2]);
        }

        dp[n] = Math.min(oneStep,twoStep);

        return dp[n];
    }

    public static void main(String[]args){

        Memoization m = new Memoization();

        int [] height = {30,10,60,10,60,50};
        int n = height.length - 1;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(m.solve(n,height,dp));

    }
}
