package DP.UniquePaths2;
import java.util.*;

public class Memoization{

    public static int solve(int [][] matrix,int rows,int cols,int [][] dp){

        if(rows >= 0 && cols >= 0 && matrix[rows][cols] == 1){
            return 0;
        }

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
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
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