
package DP.FrogJumpI;

public class Space {

    public static int solve(int n,int [] height){

        if(n==0){
            return 0;
        }
 
        int prev1 = 0;
        int prev2 = 0;

        for(int i = 1; i <= n;i++){
        
        
        int oneStep = prev1 + Math.abs(height[i] - height[i-1]);
        int twoStep = Integer.MAX_VALUE;

        if(i > 1){
            twoStep = prev2 + Math.abs(height[i] - height[i-2]);
        }
        int curr = Math.min(oneStep,twoStep);

        prev2 = prev1;
        prev1 = curr;


    }
    return prev1;
}


    
    public static void main(String[]args){

        Space s = new Space();

        int [] height = {30,10,60,10,60,50};
        int n = height.length - 1;
        
        System.out.println(s.solve(n,height));
    }
}
