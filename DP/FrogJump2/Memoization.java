package DP.FrogJump2;
import java.util.*;

public class Memoization {

    public static int func(int n,int [] height,int k,int [] dp){
        if(n == 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int minEnergy = Integer.MAX_VALUE;

        for(int j = 1; j <= k;j++){

            if(n - j >= 0){
                int jump = func(n - j,height,k,dp) + Math.abs(height[n] - height[n - j]);
                minEnergy = Math.min(minEnergy,jump);
            }
        }
        return dp[n] = minEnergy;
    }
    public static void main(String[] args){
        Memoization m = new Memoization();
        int [] height = {10,30,40,50,20};
        int n = height.length - 1;
        int k = 3;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(m.func(n,height,k,dp));
    }
}
