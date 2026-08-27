import java.util.*;
public class Memoization{

    public static int solve(int[][] triangle, int i, int j,int n,int [][] dp) {

        
        if (i == n - 1) {
            return triangle[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        
        int down = solve(triangle,i+1,j,n,dp);

        
        int diagonal = solve(triangle,i+1,j+1,n,dp);

        
        return dp[i][j] = triangle[i][j] + Math.min(down,diagonal);
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