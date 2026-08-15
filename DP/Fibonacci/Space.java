package DP.Fibonacci;

public class Space {
    public static int fib(int n){

        if(n <= 1){
            return n;
        }

        int prev2 = 0;
        int prev1 = 1;

        for(int i = 2 ; i <= n;i++){
            int curr = prev1 + prev2;

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    
    }
    public static void main(String[]args){
        int n = 5;
        Space s = new Space();
        int ans = s.fib(n);

        System.out.println(ans);

    }
    
}
