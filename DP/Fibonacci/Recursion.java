package DP.Fibonacci;

public class Recursion {

    public static int fib(int n){
        if(n <= 1){
            return n;
        }

        return fib(n-1) + fib(n-2);
    }
    public static void main(String[]args){

        Recursion r = new Recursion();
        int n = 5;

        System.out.println(r.fib(n));
    }
}
