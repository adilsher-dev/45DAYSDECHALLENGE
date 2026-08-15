package DP.Fibonacci;
import java.util.*;

public class Tabulation {

    public static int fib(int n,int [] dp){

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];

    }
    public static void main(String[] args){
        int n = 5;
        int [] dp = new int[n+1];

        Arrays.fill(dp,-1);

        Tabulation t = new Tabulation();

        System.out.println(t.fib(n,dp));

    }
}
