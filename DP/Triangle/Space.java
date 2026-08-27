import java.util.*;
public class Space{

    public static int solve(int[][] triangle, int i, int j,int n) {

        
        int [] prev = new int[n];

        for(j= 0; j < n;j++){
            prev[j] = triangle[n-1][j];
        }

        for(i=n-2;i >= 0;i--){
            int [] curr = new int[n];
            for(j = i; j >= 0;j--){

                int down = triangle[i][j] + prev[j];
                int diagonal = triangle[i][j] + prev[j+1];

                curr[j] = Math.min(down,diagonal);

            }
            prev = curr;
        }

        return prev[0];
    
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


        int answer = solve(triangle,0,0,n);

        System.out.println(answer);
    }
}