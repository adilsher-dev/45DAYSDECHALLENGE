
package DP.NinjaProblem;
import java.util.*;
public class Tabulation {
    
    public static int solve(int [][] points,int [][] dp){

        int n = points.length;
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(Math.max(points[0][0],points[0][1]),(points[0][2]));


        for(int day = 1; day < n; day++){

            for(int last = 0; last < 4;last++){
                
                int maxi = 0;
                
                for(int i = 0; i < 3; i++){
                    
                    if(i != last){
                        int maxPoints = points[day][i] + dp[day-1][i];
                        maxi =  Math.max(maxi,maxPoints);
                    }
                }
                dp[day][last] = maxi;
            }
        }
        return dp[n-1][3];
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
        System.out.println(solve(points,dp));
    }
}
