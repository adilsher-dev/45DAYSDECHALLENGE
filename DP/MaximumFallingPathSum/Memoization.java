package DP.MaximumFallingPathSum;
import java.util.*;
public class Memoization{
    public static int solve(int [][] matrix,int i , int j,int [][] dp){
        if(j < 0 || j >= matrix[0].length){
            return Integer.MIN_VALUE;
        }

        if(i == 0){
            return matrix[0][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = matrix[i][j] + solve(matrix,i-1,j,dp);
        int left = matrix[i][j] + solve(matrix,i-1,j-1,dp);
        int right = matrix[i][j] + solve(matrix,i-1,j+1,dp);

        return dp[i][j] = Math.max(up,Math.max(left,right));
    }
    public static void main(String[] args){
        int [][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

        int n = matrix.length;
        int m = matrix[0].length;

        int maxi = Integer.MIN_VALUE;

        int [][] dp = new int[n][m];

        for(int [] row : dp){
            Arrays.fill(row,-1);
        }

        for(int j = 0; j < m;j++){
            maxi = Math.max(maxi,solve(matrix,n-1,j,dp));
        }
        System.out.println("Maximum Path Sum:"+maxi);

    }
}