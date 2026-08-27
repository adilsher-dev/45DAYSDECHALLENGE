package DP.MaximumFallingPathSum;
import java.util.*;
public class Space{
    public static int solve(int [][] matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        int [] prev = new int[m];

        for(int j = 0; j < m ;j++){
            prev[j] = matrix[0][j];
        }

        for(int i = 1; i< n;i++){
            int [] curr =  new int[m];
            for(int j = 0;j<m;j++){

            
            int up = matrix[i][j] + prev[j];

            int left = Integer.MIN_VALUE;

            if(j > 0){
            
            left = matrix[i][j] +  prev[j-1];
            }

            int right = Integer.MIN_VALUE;

            if(j < m - 1){
            right = matrix[i][j] + prev[j+1];
            }
            
            curr[j] = Math.max(up,Math.max(left,right));
        }
        prev = curr;
    }


        int maxi = Integer.MIN_VALUE;

        for(int j = 0 ; j < m;j++){
            maxi = Math.max(maxi,prev[j]);
        }

        return maxi;
    }
    public static void main(String[] args){
        int [][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

        int n = matrix.length;
        int m = matrix[0].length;

        
        System.out.println(solve(matrix));
    }
}