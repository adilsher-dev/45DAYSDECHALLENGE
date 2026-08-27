package DP.MaximumFallingPathSum;
public class Recursion{
    public static int solve(int [][] matrix,int i , int j){
        if(j < 0 || j >= matrix[0].length){
            return Integer.MIN_VALUE;
        }

        if(i == 0){
            return matrix[0][j];
        }

        int up = matrix[i][j] + solve(matrix,i-1,j);
        int left = matrix[i][j] + solve(matrix,i-1,j-1);
        int right = matrix[i][j] + solve(matrix,i-1,j+1);

        return Math.max(up,Math.max(left,right));
    }
    public static void main(String[] args){
        int [][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

        int n = matrix.length;
        int m = matrix[0].length;

        int maxi = Integer.MIN_VALUE;

        for(int j = 0; j < m;j++){
            maxi = Math.max(maxi,solve(matrix,n-1,j));
        }
        System.out.println("Maximum Path Sum:"+maxi);

    }
}