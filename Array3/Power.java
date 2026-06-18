package Array3;

public class Power{
    public static void main(String[] args){
        double x = 2.1000;
        int n = 3;
        double ans = 1;
        long nn = n;

        if(nn < 0){
            nn = -nn;
        }

        while(nn > 0){
            if(nn % 2 ==  1){
                ans = ans * x;
                nn = nn - 1;
            }
            else{
                x = x * x;
                nn = nn / 2;
            }
        }
        if(n < 0){
            System.out.println((double)1.0/(double)ans);
        }
        else{
            System.out.println(ans);
        }
    }
}