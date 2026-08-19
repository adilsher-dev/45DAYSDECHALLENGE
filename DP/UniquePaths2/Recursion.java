package DP.UniquePaths2;

public class Recursion {

    public static int solve(int [][] matrix,int rows,int cols){

        if(rows >= 0 && cols >= 0 && matrix[rows][cols] == 1){
            return 0;
        }

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
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(solve(matrix,n-1,m-1));

    }
}