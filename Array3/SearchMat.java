package Array3;
import java.util.*;

public class SearchMat {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();

        int [][] mat = new int[p][p];

        for(int i = 0 ; i <p ;i++){
            for(int j = 0; j < p;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int target = 9;

        int rows = mat.length;
        int cols = mat[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while(left <= right){
            int mid = left + (right - left)/2;

            int row = mid/rows;
            int col = mid%cols;

            if(mat[row][col] == target){
                System.out.println(target);
            }
            else if(mat[row][col] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
sc.close();
    }
}
