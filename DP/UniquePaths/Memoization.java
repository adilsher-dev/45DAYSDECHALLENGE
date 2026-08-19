package DP.UniquePaths;
import java.util.*;

public class Memoization {

    public static int solve(int [][] matrix,int rows,int cols,int [][] dp){

        if(rows == 0 && cols == 0){
            return 1;
        }
        if(rows < 0 || cols < 0){
            return 0;
        }

        if(dp[rows][cols] != -1){
            return dp[rows][cols];
        }

        int up = solve(matrix,rows-1,cols,dp);
        int left = solve(matrix,rows,cols-1,dp);

        return dp[rows][cols] = up + left;

    }

    public static void main(String[] args){

        int[][] matrix = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };


        int n = matrix.length;
        int m = matrix[0].length;

        int [][] dp = new int[n][m];

        for(int [] row : dp){
            Arrays.fill(row,-1);
        }

        System.out.println(solve(matrix,n-1,m-1,dp));

    }
}