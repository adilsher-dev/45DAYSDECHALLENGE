package DP.MinimumPathSum;
import java.util.*;
public class Tabulation{

    public static int func(int [][] matrix,int [][] dp){

        int n = matrix.length;
        int m = matrix[0].length;

        dp[0][0] = matrix[0][0];

        for(int i = 0; i < n;i++){
            for(int j = 0; j < m;j++){

                if(i == 0 && j == 0){
                    continue;
                }

                int up = Integer.MAX_VALUE;//ex:- (0,1) there is no up so Integer.Maxvalue = up and for left = 1 min is 1 thats why
                int left = Integer.MAX_VALUE;

                if(i > 0){
                    
                    up = dp[i-1][j];

                }

                if(j > 0){
                    
                    left = dp[i][j-1];

                }

                dp[i][j] = matrix[i][j] + Math.min(up,left);
            }
        }

        return dp[n-1][m-1];

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

        System.out.println(func(matrix,dp));

    }
}
