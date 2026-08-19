package DP.UniquePaths2;
import java.util.*;

public class Tabulation{

    public static int solve(int [][] matrix,int [][] dp){

        int n = matrix.length;
        int m = matrix[0].length;

        
        if(matrix[0][0] == 1){
            return 0;
        }
        
        dp[0][0] = 1;

        for(int i = 0; i < n;i++){
            for(int j = 0; j < m;j++){
                
                if(i == 0 && j == 0){
                    continue;
                }

                if(matrix[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
            

                int up = 0;
                int left = 0;

                if(i > 0){

                    if(matrix[i][j] != 1){
                    up = dp[i-1][j];
                    }
                }

                if(j > 0){
                    if(matrix[i][j] != 1){
                    left = dp[i][j-1];
                }
            }

                dp[i][j] = up + left;

            }
        }
        return dp[n-1][m-1];

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

        System.out.println(solve(matrix,dp));

    }
}