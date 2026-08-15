package DP;
import java.util.*;

class Solution{

    public int ninjaTraining(int n,int [][] points){

        int [][] dp = new int[n][4];

        for(int [] row : dp){
            Arrays.fill(row,-1);
        }

        return solve(n-1,3,points,dp);
    }

    private int solve(int day,int last ,int[][] points,int[][] dp){

        if(day == 0){
            int maxi = 0;
            for(int i = 0 ; i < 3;i++){

                if(i != last){
                    maxi = Math.max(maxi,points[0][i]);
                }
            }
        return maxi;
        }

        if(dp[day][last] != -1){
            return dp[day][last];
        }

        int maxi = 0;
        for(int i = 0 ; i < 3;i++){
            if(i != last){
                int curr = points[day][i] + solve(day - 1,i,points,dp);
                maxi = Math.max(maxi,curr);
            }
    }
    dp[day][last] = maxi;

    return dp[day][last];
}
}


class Ninja{
    public static void main(String[] args){

    }
}