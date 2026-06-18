import java.util.Scanner;
//Better Solution...//1st June
public class SetMatrix{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] matrix = new int[n][m];

        for(int i = 0; i < n ;i++){
            for(int j = 0; j < m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        int [] row = new int[n];
        int [] col = new int[m];

        for(int i = 0; i < n ;i++){
            for(int j = 0; j < m;j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[i] = 1;
                }
            }
        }

        for(int i = 0; i < n ;i++){
            for(int j = 0; j < m;j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
        sc.close();    }
}