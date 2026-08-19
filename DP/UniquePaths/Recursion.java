package DP.UniquePaths;

public class Recursion {

    public static int solve(int [][] matrix,int rows,int cols){

        if(rows == 0 && cols == 0){
            return 1;
        }
        if(rows < 0 || cols < 0){
            return 0;
        }

        int up = solve(matrix,rows-1,cols);
        int left = solve(matrix,rows,cols-1);

        return up + left;

    }

    public static void main(String[] args){

        int[][] matrix = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(solve(matrix,n-1,m-1));

    }
}