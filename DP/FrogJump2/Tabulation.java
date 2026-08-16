package DP.FrogJump2;
import java.util.*;

public class Tabulation {

    public static int func(int n,int [] height,int k,int [] dp){
        if(n == 0){
            return 0;
        }

        dp[0] = 0;
        
        for(int i = 1; i <= n;i++){
            int minEnergy = Integer.MAX_VALUE;

            for(int j = 1; j <= k;j++){

            if(i - j >= 0){//i lena hai
                int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                minEnergy = Math.min(minEnergy,jump);
            }
        }
        dp[i] = minEnergy;
    }
    
    return dp[n];
    }
    public static void main(String[] args){
        Tabulation t = new Tabulation();
        int [] height = {10,30,40,50,20};
        int n = height.length - 1;
        int k = 3;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(t.func(n,height,k,dp));
    }
}
