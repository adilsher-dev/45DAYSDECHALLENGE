package DP.MaximumFallingPathSum;
import java.util.*;
public class Tabulation{
    public static int solve(int [][] matrix,int [][] dp){

        int n = matrix.length;
        int m = matrix[0].length;

        for(int j = 0; j < m ;j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1; i< n;i++){
            for(int j = 0;j<m;j++){

            
            int up = matrix[i][j] + dp[i-1][j];

            int left = Integer.MIN_VALUE;

            if(j > 0){
            
            left = matrix[i][j] + dp[i-1][j-1];
            }

            int right = Integer.MIN_VALUE;

            if(j < m - 1){
            right = matrix[i][j] + dp[i-1][j+1];
            }
            
            dp[i][j] = Math.max(up,Math.max(left,right));
        }
    }


        int maxi = Integer.MIN_VALUE;

        for(int j = 0 ; j < m;j++){
            maxi = Math.max(maxi,dp[n-1][j]);
        }

        return maxi;
    }
    public static void main(String[] args){
        int [][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

        int n = matrix.length;
        int m = matrix[0].length;

        int [][] dp = new int[n][m];

        for(int [] row : dp){
            Arrays.fill(row,-1);
        }

        System.out.println(solve(matrix,dp));
    }
}