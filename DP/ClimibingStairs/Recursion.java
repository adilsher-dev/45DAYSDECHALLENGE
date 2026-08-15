package DP.ClimibingStairs;

public class Recursion {

    public static int solve(int index){
        if(index == 0){
            return 1;
        }
        if(index == 1){
            return 1;
        }

        int left = solve(index-1);
        int right = solve(index -2);

        return left + right;
    }
    public static void main(String[] args){

        Recursion r = new Recursion();
        int ans = r.solve(5);
        System.out.println(ans);
    }
}
