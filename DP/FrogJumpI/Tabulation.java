package DP.FrogJumpI;

import java.util.Arrays;

public class Tabulation {

    public static int solve(int n,int [] height,int [] dp){

        if(n==0){
            return 0;
        }
 
        dp[0] = 0;

        for(int i = 1; i <= n;i++){
        
        
        int oneStep = dp[i-1] + Math.abs(height[i] - height[i-1]);
        int twoStep = Integer.MAX_VALUE;

        if(i > 1){
            twoStep = dp[i-2] + Math.abs(height[i] - height[i-2]);
        }
        dp[i] = Math.min(oneStep,twoStep);
    }
    return dp[n];
}


    
    public static void main(String[]args){

        Tabulation t = new Tabulation();

        int [] height = {30,10,60,10,60,50};
        int n = height.length - 1;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(t.solve(n,height,dp));
    }
}
