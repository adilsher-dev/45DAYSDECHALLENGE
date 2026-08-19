package DP.NinjaProblem;
import java.util.*;
public class Memoization {
    
    public static int solve(int day,int last,int [][] points,int [][] dp){

        if(day == 0){
            int maxi = 0;
            for(int i = 0 ; i < 3;i++){
                if(i != last){
                   maxi = Math.max(maxi,points[0][i]);
                }
            }
            return dp[0][last] = maxi;
        }


        if(dp[day][last] != -1){
            return dp[day][last];
        }


        int maxi = 0;

        for(int i = 0; i < 3; i++){
            if(i != last){
                int maxPoints = points[day][i] + solve(day-1,i,points,dp);
                maxi =  Math.max(maxi,maxPoints);
            }
        }
        return dp[day][last] = maxi;
    }
    public static void main(String[]args){
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };
        int n = points.length;
        int [][] dp = new int [n][4];

        for(int [] rows : dp){
            Arrays.fill(rows,-1);
        }

        //int m = points[0].length;

        // last = 3 means there is no previous task
        System.out.println(solve(n - 1, 3, points,dp));
    }
}
