package DP.FrogJumpI;
import java.util.*;

public class Recursion {

    public static int Min(int n , int [] height){

        if(n == 0){
            return 0;
        }


        int oneStep = Min(n-1,height) + Math.abs(height[n] - height[n-1]);
        int twoStep = Integer.MAX_VALUE;

        if(n > 1){
            twoStep = Min(n-2,height) + Math.abs(height[n] - height[n-2]);
        }

        return Math.min(oneStep,twoStep);
    }
    public static void main(String[] args){

        Recursion r = new Recursion();

        int [] height = {30,10,60,10,60,50};
        int n = height.length - 1;
        int [] dp = new int[n+1];

        

        System.out.println(r.Min(n,height));

    }
    
}
