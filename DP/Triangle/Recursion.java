
public class Recursion {

    public static int solve(int[][] triangle, int i, int j,int n) {

        
        if (i == n - 1) {
            return triangle[i][j];
        }
        
        int down = solve(triangle,i+1,j,n);

        
        int diagonal = solve(triangle,i+1,j+1,n);

    
        return triangle[i][j] + Math.min(down,diagonal);
    }

    public static void main(String[] args) {

        int[][] triangle = {
            {2},
            {3, 4},
            {6, 5, 7},
            {4, 1, 8, 3}
        };

        int n = triangle.length;

        int answer = solve(triangle,0,0,n);

        System.out.println(answer);
    }
}