import java.util.*;
public class Tabulation{

    public static int solve(int[][] triangle, int i, int j,int n,int [][] dp) {

        
        for(j = 0 ; j < n;j++){

            dp[n-1][j] = triangle[n-1][j];
            
        }

        for(i  = n - 2;i >= 0;i--){
            for(j = i; j >= 0;j--){

                int down = triangle[i][j] + dp[i+1][j];
                int diagonal = triangle[i][j] + dp[i+1][j+1];

                dp[i][j] = Math.min(down,diagonal);

            }
        }

        return dp[0][0];
    
    }

    public static void main(String[] args) {

        int[][] triangle = {
            {2},
            {3, 4},
            {6, 5, 7},
            {4, 1, 8, 3}
        };

        int n = triangle.length;
        int m = triangle[0].length;

        int [][] dp = new int[n][n];

        for(int [] row : dp){
            Arrays.fill(row,-1);
        }

        int answer = solve(triangle,0,0,n,dp);

        System.out.println(answer);
    }
}