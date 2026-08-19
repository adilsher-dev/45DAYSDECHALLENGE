package DP.UniquePaths;
import java.util.*;

public class Space{

    public static int solve(int [][] matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        int [] prev = new int[m];//this is the prev array

        for(int i = 0; i < n;i++){

            int [] curr = new int[m];//this is the current array

            for(int j = 0; j < m;j++){
                
                if(i == 0 && j == 0){
                    curr[j] =  1;
                    continue;//we don't have to calcalate this after storing in prev[j]
                }

                int up = 0;
                int left = 0;

                if(i > 0){
                    up = prev[j];
                }

                if(j > 0){
                    left = curr[j-1];
                }
                
                curr[j] = up + left;
            }
            prev = curr;

        }
        return prev[m-1];

    }

    public static void main(String[] args){

        int[][] matrix = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };


        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(solve(matrix));

    }
}