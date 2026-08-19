package DP.MinimumPathSum;

public class Recursion {

    public static int func(int [][] matrix,int rows,int cols){

        if(rows == 0 && cols == 0){
            return matrix[0][0];
        }

        if(rows < 0 || cols < 0){
            return Integer.MAX_VALUE;
        }

        int up = func(matrix,rows-1,cols);
        int left = func(matrix,rows,cols-1);

        return matrix[rows][cols] + Math.min(up,left);

    }

    public static void main(String[] args){

        int[][] matrix = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(func(matrix,n-1,m-1));

    }
}
