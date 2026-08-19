package DP.MinimumPathSum;
import java.util.*;
public class Space{

    public static int func(int [][] matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        int [] prev = new int[m];

        for(int i = 0; i < n;i++){
            int [] curr = new int[m];
            for(int j = 0; j < m;j++){

                if(i == 0 && j == 0){
                    curr[j] = matrix[0][0];
                    continue;
                }

                int up = Integer.MAX_VALUE;//ex:- (0,1) there is no up so Integer.Maxvalue = up and for left = 1 min is 1 thats why
                int left = Integer.MAX_VALUE;

                if(i > 0){
                    
                    up = prev[j];

                }

                if(j > 0){
                    
                    left = curr[j-1];

                }

                curr[j] = matrix[i][j] + Math.min(up,left);
            }
            prev = curr;
        }

        return prev[m-1];

    }

    public static void main(String[] args){

        int[][] matrix = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };


        System.out.println(func(matrix));

    }
}
