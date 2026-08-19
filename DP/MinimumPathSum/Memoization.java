package DP.MinimumPathSum;
import java.util.*;
public class Memoization{

    public static int func(int [][] matrix,int rows,int cols,int [][] dp){

        if(rows == 0 && cols == 0){
            return matrix[0][0];
        }

        if(rows < 0 || cols < 0){
            return Integer.MAX_VALUE;
        }

        if(dp[rows][cols] != -1){
            return dp[rows][cols];
        }

        int up = func(matrix,rows-1,cols,dp);
        int left = func(matrix,rows,cols-1,dp);

        return dp[rows][cols] = matrix[rows][cols] + Math.min(up,left);

    }

    public static void main(String[] args){

        int[][] matrix = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        int [][] dp = new int[n][m];

        for(int [] row : dp){
            Arrays.fill(row,-1);
        }

        System.out.println(func(matrix,n-1,m-1,dp));

    }
}
